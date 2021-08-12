package common;

import java.time.Instant;

import entity.Post;

/**
 * @author sunny .
 * This is Builder class for the post.
 *
 */

public class PostBuilder {


	private final Post post = new Post();

	private PostBuilder() {

	}

	public static PostBuilder getInstance() {

		return new PostBuilder();

	}

	public Post build() {

		return post;

	}


	public PostBuilder postId(final String postId) {
		post.setPostId(postId);
		return this;

	}

	public PostBuilder postContent(final String postContent) {
		post.setPostContent(postContent);
		return this;

	}

	public PostBuilder instant(final Instant instant) {
		post.setDateTimeOfPost(instant);
		return this;

	}

}
