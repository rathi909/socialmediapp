package socialMediaApp.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.PostBuilder;

/**
 * @author sunny
 *
 */
public class SocialMediaControllerTest extends AbstractTest {

	@Autowired
	ObjectMapper ObjectMapper;

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testCreatepostUrlIsNotCorrect() throws Exception {
		final String uri = "/createPost/shubham//going to ";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 404);
	}

	@Test
	public void testCreatepostUrlCorrect() throws Exception {
		final String uri = "/createPost/shubham ";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
						.content(ObjectMapper
								.writeValueAsString(PostBuilder.getInstance().postContent("Moved to London").build())))
				.andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 201);

	}

	@Test
	public void testFollowUserUrlNotCorrect() throws Exception {
		final String uri = "/followUser/shubham ";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 404);
	}

	@Test
	public void testFollowUserUrlCorrect() throws Exception {
		final String uri = "/followUser/Sonam/parul";
		try {
			mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
		} catch (Exception ex) {
			assertEquals(ex.getCause().getMessage(),
					"Add follower can't be completed as Either userId id or follower doesn't exist in db");
		}
	}

	@Test
	public void testUnFollowUserUrlCorrect() throws Exception {
		final String uri = "/UnfollowUser/Sonam/parul";
		try {
			mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
		} catch (Exception ex) {
			assertEquals(ex.getCause().getMessage(),
					"Add follower can't be completed as Either userId id or follower doesn't exist in db");
		}
	}

	@Test
	public void testUnFollowUserNegative() throws Exception {
		final String uri = "/Unfollow/Sonam/parul";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 404);
	}

	@Test
	public void testgetNewsFeed() throws Exception {
		final String uri = "/getUserPosts/Sonam";
		try {
			mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		} catch (Exception ex) {
			assertEquals(ex.getCause().getMessage(),
					"User id is not found in the database, so posts will be not be there");
		}

	}

	@Test
	public void testgetNewsFeedUrlNotCorrect() throws Exception {
		final String uri = "/getUserPo";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 404);
	}
}
