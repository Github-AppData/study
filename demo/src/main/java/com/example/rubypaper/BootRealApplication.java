package com.example.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BootRealApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRealApplication.class, args);
	}

}
