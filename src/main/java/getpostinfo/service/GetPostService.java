package getpostinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Post;

@Service
public interface GetPostService {
	
	public List<Post> getPost(String userId) throws Exception;

}
