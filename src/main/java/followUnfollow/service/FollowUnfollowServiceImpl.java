package followUnfollow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import followUnfollow.repository.FollowUnfollowRepository;

/**
 * @author sunny
 * This is service class for Follow Unfollow service.
 */
@Service
public class FollowUnfollowServiceImpl implements FollowUnfollowService {

	@Autowired
	private FollowUnfollowRepository followRepository;

	@Override
	public Boolean followUserById(String userId, String followerId) throws Exception {
		return followRepository.addFollowe(userId, followerId);
	}
	
	@Override
	public Boolean UnfollowUser(String userId, String followerId) throws Exception {
		return followRepository.removeFollowe(userId, followerId);
	}

}
