package createpost.repository;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import common.DataRepository;
import common.UserInformationBuilder;
import entity.Post;

/**
 * @author sunny This is repository class that will create the post and save in
 *         the database.
 */
@Component
public class CreatePostRepositoryImpl implements CreatePostRepository {

	@Autowired
	private DataRepository dataRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Boolean createPost(Post post, String userId) {
		if (dataRepository.getMap().containsKey(userId)) {
			dataRepository.getMap().get(userId).getListOfPosts().add(post);
			return true;
		} else {
			dataRepository.getMap().put(userId,
					UserInformationBuilder.getInstance().listOfPosts(new ArrayList(Arrays.asList(post))).build());
			return true;
		}
	}
}
