package followUnfollow.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface FollowUnfollowRepository  {
	
	public Boolean addFollowe(String UserId,String followerId)  throws Exception;
	
	public Boolean removeFollowe(String UserId, String followerId)  throws Exception;

}
