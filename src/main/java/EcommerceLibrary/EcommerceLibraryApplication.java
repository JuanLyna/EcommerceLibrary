package EcommerceLibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class EcommerceLibraryApplication {

	public static void main(String[] args) {
		ApplicationContext context=  SpringApplication.run(EcommerceLibraryApplication.class, args);

	}

	@GetMapping("/")
		public String helloWorl (){
			return "index" ;
		}
}
