package getpostinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import getpostinfo.repository.GetPostRepository;

@Service
public class GetPostServiceImpl  implements GetPostService{
	
	@Autowired
	private GetPostRepository getPostRepository;

	@Override
	public List<String> getPost(String userId) throws Exception {
		return getPostRepository.getPost(userId);
	}

}
