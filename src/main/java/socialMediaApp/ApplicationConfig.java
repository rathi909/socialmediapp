package socialMediaApp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"controller","createpost", "followunfollow","getpostinfo","common" })
public class ApplicationConfig {

}