package getpostinfo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GetPostService {
	
	public List<String> getPost(String userId) throws Exception;

}
