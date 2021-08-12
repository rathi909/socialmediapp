package getpostinfo.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.DataRepository;
import entity.Post;

/**
 * @author sunny
 * This Class is used to get post for Used id;
 */
@Repository
public class GetPostRepositoryImpl implements GetPostRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GetPostRepositoryImpl.class);

	@Autowired
	private DataRepository dataRepository;

	
	@Override
	public List<Post> getPost(String userId) throws Exception {
		List<Post> postList = new ArrayList<>();
		if (dataRepository.getMap().keySet().contains(userId)) {
			if (Objects.nonNull(dataRepository.getMap().get(userId).getListOfPosts())) {
				postList.addAll(dataRepository.getMap().get(userId).getListOfPosts());
			}
			dataRepository.getMap().keySet().forEach(x -> {
				if (dataRepository.getMap().get(x).getFollowerList().contains(userId)) {
					if (Objects.nonNull(dataRepository.getMap().get(x).getListOfPosts())) {
						postList.addAll(dataRepository.getMap().get(x).getListOfPosts());
					}
				}
			});
			Collections.sort(postList, (l1, l2) -> l2.getDateTimeOfPost().compareTo(l1.getDateTimeOfPost()));
			return postList.stream().limit(20).collect(Collectors.toList());
		}
		else {
			LOGGER.debug("User id not found {}", userId);
			throw new Exception("User id is not found in the database, so posts will be not be there");
		}
	}

}
