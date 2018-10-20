package cl.hakusach.hakusach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HakusachApplication extends SpringBootServletInitializer  {

	@Override
  	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(HakusachApplication.class);
  	}

	public static void main(String[] args) {
		SpringApplication.run(HakusachApplication.class, args);
	}
}
