package cl.hakusach.hakusach;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class HakusachApplication extends SpringBootServletInitializer  {

	@Override
  	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	return application.sources(HakusachApplication.class);
  	}

	public static void main(String[] args) {
		SpringApplication.run(HakusachApplication.class, args);
	}

	@Bean
    public Executor asyncExcecutor() {
    	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    	executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("AssyncGlotIoRuns-");
        executor.initialize();
        return executor;
    }

}
