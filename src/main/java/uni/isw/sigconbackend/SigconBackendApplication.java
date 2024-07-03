package uni.isw.sigconbackend;

import java.util.TimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SigconBackendApplication {

	public static void main(String[] args) {
            //System.out.println("Setting the timezone"+TimeZone.getTimeZone("GMT-5").getID());
            TimeZone.setDefault(TimeZone.getTimeZone("GMT-5"));
            SpringApplication.run(SigconBackendApplication.class, args);                
	}
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
                }
            };
        }
}
