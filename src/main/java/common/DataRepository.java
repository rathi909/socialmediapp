package common;

import static common.CommonUtils.getShortUuid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Repository;

import entity.Post;
import entity.UserInformation;

/**
 * @author sunny
 * This class is loaded after the application is started and it will also create a basic map with some dummy data. 
 */
@Repository
public class DataRepository {

	final Map<String, UserInformation> map = new HashMap<>();

	@EventListener(ApplicationReadyEvent.class)
	private void doSetUpIntialRepository() {

		map.put("thomas", getUserInformation(new ArrayList<String>(Arrays.asList("kim")), Arrays.asList(PostBuilder
				.getInstance().postId(getShortUuid()).postContent("Got placed in cs").build())));

		map.put("steffard", getUserInformation(new ArrayList<String>(Arrays.asList("kamil")), Arrays.asList(PostBuilder
				.getInstance().postId(getShortUuid()).postContent("Moved to england").build())));

	}

	public Map<String, UserInformation> getMap() {
		return map;
	}

	private UserInformation getUserInformation(List<String> followerList, List<Post> posts) {
		return UserInformationBuilder.getInstance().followerList(followerList).listOfPosts(posts).build();
	}

}
