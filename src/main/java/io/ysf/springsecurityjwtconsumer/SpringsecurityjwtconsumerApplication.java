package io.ysf.springsecurityjwtconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("io.ysf.springsecurityjwtconsumer")
public class SpringsecurityjwtconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityjwtconsumerApplication.class, args);
	}

}
