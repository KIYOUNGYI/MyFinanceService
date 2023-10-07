package org.liki.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.liki.client.adapter.out.persistence.query", "org.liki.client.adapter.out.persistence.repository", "org.liki.client.adapter.out.persistence.entity"})
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }
}