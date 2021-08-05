package createpost.repository;

import static constants.AppConstants.LIST_OF_POSTS;
import static constants.AppConstants._ID;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;

import entity.Post;
import entity.UserData;

/**
 * @author sunny
 *
 */
@Component
public class CreatePostRepositoryImpl implements CreatePostRepository {

	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Boolean createPost(Post post, String userId) {
		UserData userData = getUserDataById(userId);
		Update update = new Update();
		if (Objects.nonNull(getUserDataById(userId))) {
			userData.getListOfPosts().add(post);
			update.set(LIST_OF_POSTS, userData.getListOfPosts());
			Query query = new Query(Criteria.where(_ID).is(userId));
			final WriteResult result = mongoTemplate.upsert(query, update, UserData.class);
			Boolean postCreated = result.getN() > 0 ? Boolean.TRUE : Boolean.FALSE;
			return postCreated;

		} else {
			update.set(LIST_OF_POSTS, Arrays.asList(post));
			Query query = new Query(Criteria.where(_ID).is(userId));
			final WriteResult result =mongoTemplate.upsert(query, update, UserData.class);
			Boolean postCreated = result.getN() > 0 ? Boolean.TRUE : Boolean.FALSE;
			return postCreated;
		}
	}

	@Override
	public UserData getUserDataById(String id) {
		return mongoTemplate.findById(id, UserData.class);
	}
}
