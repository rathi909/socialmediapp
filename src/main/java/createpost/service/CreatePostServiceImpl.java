package createpost.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import createpost.repository.CreatePostRepository;
import entity.Post;

/**
 * @author sunny
 * This is service class for createPost.
 */
@Service
public class CreatePostServiceImpl implements CreatePostService{
	
	@Autowired
	private CreatePostRepository createPostRepository;

	@Override
	public Boolean createPost(Post post, String userId) {
		return createPostRepository.createPost(post,userId);
	}

}
