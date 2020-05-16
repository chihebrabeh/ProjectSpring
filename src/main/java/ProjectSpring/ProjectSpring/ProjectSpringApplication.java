package ProjectSpring.ProjectSpring;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
@Getter
@Setter
@NoArgsConstructor
@Slf4j
public class ProjectSpringApplication implements ApplicationRunner, CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ProjectSpringApplication.class);

	@Autowired
	RestTemplate  restTemplate;

	@Value("${spring.application.name}")
	private String name;

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		logger.info("this name of application is " );
		SpringApplication.run(ProjectSpringApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("test");
		return 	"Hello Spring ";
	}
	@RequestMapping(value = "/name")
	public String name() {
		return name;
	}
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("Hello World from Application Runner");
	}
	@Override
	public void run(String... arg0) throws Exception {
		System.out.println("Hello world from Command Line Runner");
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
