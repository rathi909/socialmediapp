package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunny
 * Entity class for the UserInformation.
 */
public class UserInformation {
	
	private List<Post> listOfPosts = new ArrayList<>(0) ;
	
	private List<String> followerList = new ArrayList<>(0);

	
	public List<Post> getListOfPosts() {
		return listOfPosts;
	}

	public void setListOfPosts(List<Post> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}

	public List<String> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<String> followerList) {
		this.followerList = followerList;
	}


}
