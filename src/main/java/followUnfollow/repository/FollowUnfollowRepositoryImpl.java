package followUnfollow.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.DataRepository;

/**
 * @author sunny
 * This class is used to follow and unfollow user and save in db.
 */
@Repository
public class FollowUnfollowRepositoryImpl implements FollowUnfollowRepository {

	@Autowired
	private DataRepository dataRepository;

	/** Follow user**/
	@Override
	public Boolean addFollowe(String userId, String followerId) throws Exception {
		if (dataRepository.getMap().containsKey(userId) && dataRepository.getMap().containsKey(followerId)) {
			dataRepository.getMap().get(userId).getFollowerList().add(followerId);
			return true;
		} else {
			throw new Exception("Add follower can't be completed as Either userId id or follower doesn't exist in db");
		}

	}

	/** unfollow user**/
	@Override
	public Boolean removeFollowe(String userId, String followerId) throws Exception {
		if (dataRepository.getMap().containsKey(userId) && dataRepository.getMap().containsKey(followerId)) {
			dataRepository.getMap().get(userId).getFollowerList().remove(followerId);
			return true;
		} else {
			throw new Exception("Remove follower can't be completed as Either userId id or follower doesn't exist in db");
		}
	}

}
