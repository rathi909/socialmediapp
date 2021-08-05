package socialMediaApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan({"controller","createpost", "followunfollow","getpostinfo"})
@EnableMongoRepositories({ "createpost.repository","followunfollow.repository","getpostinfo.repository" })
public class ApplicationConfig {

	 @Bean
	   public MongoDbFactory mongoDbFactory() 
	   {
	        MongoClient mongoClient = new MongoClient("localhost", 27017);
	        return new SimpleMongoDbFactory(mongoClient, "socialmediaapp");
	    }
	 
	    @Bean
	    public MongoTemplate mongoTemplate()
	    {
	        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
	        return mongoTemplate;
	    }
}