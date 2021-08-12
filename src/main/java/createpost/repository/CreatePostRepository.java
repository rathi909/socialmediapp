package createpost.repository;

import org.springframework.stereotype.Repository;

import entity.Post;

/**
 * @author sunny
 *
 */
@Repository
public interface CreatePostRepository{
	
	public Boolean createPost(Post post, String userId);
	
}
