package controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import createpost.service.CreatePostService;
import entity.Post;
import followUnfollow.service.FollowUnfollowService;
import getpostinfo.service.GetPostService;

/**
 * @author sunny
 *
 */
@RestController
public class SocialMediaController {

	@Autowired
	private CreatePostService createPostService;

	@Autowired
	private FollowUnfollowService followUnfollowService;

	@Autowired
	private GetPostService getPostService;

	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * @param userId
	 * @param postId
	 * @param content
	 * @return
	 */
	@PostMapping(value = "/createPost/{userId:.+}/{postId:.+}/{content:.+}")
	public ResponseEntity<HttpStatus> createPost(@PathVariable("userId") final String userId,
			@PathVariable final String postId, @PathVariable final String content) {

		if (!createPostService.createPost(
				Post.builder().postId(postId).postContent(content).dateTimeOfPost(Instant.now()).build(), userId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	/**
	 * @param followeId
	 * @param followerId
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/followUser/{followeId:.+}/{followerId:.+}")
	public ResponseEntity<HttpStatus> followUser(@PathVariable final String followerId,
			@PathVariable("followeId") final String followeId) throws Exception {
		if (!followUnfollowService.followUserById(followeId, followerId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * @param followeId
	 * @param followerId
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping(value = "/UnfollowUser/{followeId:.+}/{followerId:.+}")
	public ResponseEntity<HttpStatus> UnfollowUser(@PathVariable final String followerId,
			@PathVariable("followeId") final String followeId) throws Exception {
		if (!followUnfollowService.UnfollowUser(followeId, followerId)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/getUserPosts/{userId:.+}")
	public ResponseEntity<String> getNewsFeed(@PathVariable("userId") final String userId) throws Exception {
		return new ResponseEntity<String>(objectMapper.writeValueAsString(getPostService.getPost(userId)),
				HttpStatus.OK);
	}

}
