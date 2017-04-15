package hu.me;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class HangmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HangmanApplication.class, args);
		//ehez soha nem nyúlunk
		//f
		
		//http://localhost:8181/h2-console/

		//postman adat felvitel:
//		{
//			"firstName": "John",
//			"lastName": "Doe"
//		}
		
	}
}
