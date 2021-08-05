package getpostinfo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import entity.Post;
import entity.UserData;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class GetPostRepositoryImpl implements GetPostRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<String> getPost(String userId) throws Exception {
		List<Post> postList = new ArrayList<>();
		UserData userData = mongoTemplate.findById(userId, UserData.class);
		if (userData == null) {
			log.debug("User id not found {}",userId);
			throw new Exception("User id is not found in the database, so posts will be not be there");
		} else {
			if (!userData.getListOfPosts().isEmpty()) {
				postList.addAll(userData.getListOfPosts());
			}
			userData.getFollowerList().forEach(follower -> {
				UserData followerUserDta = mongoTemplate.findById(follower, UserData.class);
				if (Objects.nonNull(followerUserDta)) {
					List<Post> emptyList = followerUserDta.getListOfPosts();
					if (!emptyList.isEmpty()) {
						postList.addAll(emptyList);
					}
				}
			});

			Collections.sort(postList, (l1, l2) -> l2.getDateTimeOfPost().compareTo(l1.getDateTimeOfPost()));
		}
		return postList.stream().map(Post::getPostId).limit(20).collect(Collectors.toList());
	}

}
