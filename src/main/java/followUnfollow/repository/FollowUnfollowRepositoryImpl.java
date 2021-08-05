package followUnfollow.repository;

import static constants.AppConstants.FOLLOWER_LIST;
import static constants.AppConstants._ID;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.WriteResult;

import entity.UserData;

/**
 * @author sunny
 *
 */
@Repository
public class FollowUnfollowRepositoryImpl implements FollowUnfollowRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Boolean addFollowe(String UserId, String followerId) throws Exception {
		Update update = new Update();
		UserData userData = mongoTemplate.findById(UserId, UserData.class);
		if (userData == null) {
			throw new Exception("Followe id can be followed as it doesn't exist in db");
		} else {
			if (Objects.nonNull(userData.getFollowerList()) && !userData.getFollowerList().contains(followerId)) {
				userData.getFollowerList().add(followerId);
				update.set(FOLLOWER_LIST, userData.getFollowerList());
				Query query = new Query(Criteria.where(_ID).is(UserId));
				final WriteResult result = mongoTemplate.upsert(query, update, UserData.class);
				Boolean isFollwed = result.getN() > 0 ? Boolean.TRUE : Boolean.FALSE;
				return isFollwed;
			}
			if (Objects.isNull(userData.getFollowerList())) {
				update.set(FOLLOWER_LIST, Arrays.asList(followerId));
				Query query = new Query(Criteria.where(_ID).is(UserId));
				final WriteResult result = mongoTemplate.upsert(query, update, UserData.class);
				Boolean isFollwed = result.getN() > 0 ? Boolean.TRUE : Boolean.FALSE;
				return isFollwed;
			}
		}
		return Boolean.FALSE;

	}

	public Boolean removeFollowe(String UserId, String followerId) throws Exception {
		UserData userData = mongoTemplate.findById(UserId, UserData.class);
		if (userData == null) {
			throw new Exception("User id can be unfollowed as it doesn't exist in db");
		} else {
			if ((Objects.nonNull(userData.getFollowerList())
					&& userData.getFollowerList().contains(followerId))) {
				userData.getFollowerList().remove(followerId);
				Update update = new Update();
				update.set(FOLLOWER_LIST, userData.getFollowerList());
				Query query = new Query(Criteria.where(_ID).is(UserId));
				final WriteResult result = mongoTemplate.upsert(query, update, UserData.class);
				Boolean isRemoved = result.getN() > 0 ? Boolean.TRUE : Boolean.FALSE;
				return isRemoved;
			}
		}
		return Boolean.FALSE;
	}

}
