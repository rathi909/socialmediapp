package createpost.repository;

import org.springframework.stereotype.Repository;

import entity.Post;
import entity.UserData;

/**
 * @author sunny
 *
 */
@Repository
public interface CreatePostRepository{
	
	
	public Boolean createPost(Post post, String userId);
	
	public UserData getUserDataById(String id);

}
