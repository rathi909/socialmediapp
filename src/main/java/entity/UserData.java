package entity;

import static constants.AppConstants.USER_DATA;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection=USER_DATA)
public class UserData {
	
	@Id
	private String usedId;
	
	
	@Builder.Default
	List<Post> listOfPosts = new ArrayList<>(0) ;
	
	@Builder.Default
	private List<String> followerList = new ArrayList<>(0);
}
