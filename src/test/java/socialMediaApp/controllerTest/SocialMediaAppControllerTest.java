package socialMediaApp.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author sunny
 *
 */
public class SocialMediaAppControllerTest extends AbstractTest {

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
		final String uri = "/createPost/shubham/0000/going to ";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
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
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 200);
	}

	@Test
	public void testUnFollowUserUrlCorrect() throws Exception {
		final String uri = "/UnfollowUser/Sonam/parul";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 200);
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
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 200);
	}
	
	@Test
	public void testgetNewsFeedUrlNotCorrect() throws Exception {
		final String uri = "/getUserPo";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
		int status = mvcResult.getResponse().getStatus();
		assertEquals(status, 404);
	}
}
