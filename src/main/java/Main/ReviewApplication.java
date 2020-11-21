package Main;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

//	@Primary
//	@Bean
//	public String message() {
//		System.out.println("Creating message bean");
//		return "Hello, Spring!";
//	}
//
//	@Bean
//	public String uppercaseMessage(MessageService ms) {
//		System.out.println("Creating uppercase message");
//		return ms.uppercaseMessage();
//	}
//
//	@Bean
//	public String lowercaseMessage(MessageService ms) {
//		System.out.println("Creating lowercase message");
//		return ms.lowercaseMessage();
//	}
}
