package entity;

import java.time.Instant;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import common.JsonDateSerializer;

/**
 * @author sunny
 * Entity class for the Post.
 */
public class Post {
	
	private String postId;
	
	private String postContent;
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Instant dateTimeOfPost;
	
	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Instant getDateTimeOfPost() {
		return dateTimeOfPost;
	}

	public void setDateTimeOfPost(Instant dateTimeOfPost) {
		this.dateTimeOfPost = dateTimeOfPost;
	}

}
