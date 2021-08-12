package followUnfollow.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FollowUnfollowRepository  {
	
	public Boolean addFollowe(String userId,String followerId)  throws Exception;
	
	public Boolean removeFollowe(String userId, String followerId)  throws Exception;

}
