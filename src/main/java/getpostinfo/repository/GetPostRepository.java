package getpostinfo.repository;

import java.util.List;

import entity.Post;

public interface GetPostRepository {
	
	public List<Post> getPost(String userId) throws Exception;


}
