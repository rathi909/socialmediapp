package getpostinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Post;
import getpostinfo.repository.GetPostRepository;

/**
 * @author sunny
 * Service class for the get Post.
 */
@Service
public class GetPostServiceImpl  implements GetPostService{
	
	@Autowired
	private GetPostRepository getPostRepository;


	public List<Post> getPost(String userId) throws Exception {
		return getPostRepository.getPost(userId);
	}
	
}
