package com.dst.atripiera.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GitHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitHubApplication.class, args);
	}

}
