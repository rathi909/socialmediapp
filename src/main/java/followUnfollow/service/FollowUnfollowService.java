package followUnfollow.service;

import org.springframework.stereotype.Service;

/**
 * @author sunny
 *
 */
@Service
public interface FollowUnfollowService  {

	public Boolean followUserById(String UserId, String followerId)  throws Exception;
	
	public Boolean UnfollowUser(String UserId, String followerId)  throws Exception;
}
