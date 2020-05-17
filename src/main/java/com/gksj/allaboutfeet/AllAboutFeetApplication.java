package com.gksj.allaboutfeet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class AllAboutFeetApplication {

  public static void main(String[] args) {
    SpringApplication.run(AllAboutFeetApplication.class, args);
  }

}
