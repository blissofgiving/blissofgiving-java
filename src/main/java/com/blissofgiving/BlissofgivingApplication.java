package com.blissofgiving;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.blissofgiving.config.aws.AwsEventListener;


@SpringBootApplication
public class BlissofgivingApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication app=new SpringApplication(BlissofgivingApplication.class);
		app.setAddCommandLineProperties(false);
		app.addListeners(new AwsEventListener());
		app.run(args);
	}
}
