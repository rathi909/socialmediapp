package entity;

import java.time.Instant;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Post {
	
	@Id
	private String postId;
	
	private String postContent;
	
	private Instant dateTimeOfPost;
	
}
