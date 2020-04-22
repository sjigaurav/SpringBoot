package com.example.demo;

import java.io.File;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import controller.FileUploadController;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@SpringBootApplication	
@ComponentScan({"com.example.demo","controller"})
public class DemoApplication {

	public static void main(String[] args) {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(DemoApplication.class, args);
	}
	
	  public void run(ApplicationArguments arg0) throws Exception {
	      System.out.println("Hello World from Application Runner");
	   }

}
