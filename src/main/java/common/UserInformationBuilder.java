package common;

import java.util.List;

import entity.Post;
import entity.UserInformation;

/**
 * @author sunny This class is used to UserInformation.
 */
public class UserInformationBuilder {

	private final UserInformation userInformation = new UserInformation();

	private UserInformationBuilder() {

	}

	public static UserInformationBuilder getInstance() {

		return new UserInformationBuilder();

	}

	public UserInformation build() {

		return userInformation;

	}

	public UserInformationBuilder listOfPosts(final List<Post> listOfPosts) {
		userInformation.setListOfPosts(listOfPosts);
		return this;

	}

	public UserInformationBuilder followerList(List<String> followerList) {
		userInformation.setFollowerList(followerList);
		return this;

	}

}
