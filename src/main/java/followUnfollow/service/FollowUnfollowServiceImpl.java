package followUnfollow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import followUnfollow.repository.FollowUnfollowRepository;

@Service
public class FollowUnfollowServiceImpl implements FollowUnfollowService {

	@Autowired
	private FollowUnfollowRepository followRepository;

	@Override
	public Boolean followUserById(String UserId, String followerId) throws Exception {
		return followRepository.addFollowe(UserId, followerId);
	}

	@Override
	public Boolean UnfollowUser(String UserId, String followerId) throws Exception {
		return followRepository.removeFollowe(UserId, followerId);
	}

}
