package getpostinfo.repository;

import java.util.List;

public interface GetPostRepository {
	
	
	public List<String> getPost(String userId) throws Exception;

}
