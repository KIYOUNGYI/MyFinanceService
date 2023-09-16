package org.liki.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientFactory {

//  private final String MY_YAHOO_FIN_REST_API_URL = "http://172.16.101.49:3000";//일단 테스트니까
//  private final String MY_YAHOO_FIN_REST_API_URL = "http://localhost:3000";//일단 테스트니까

  private final String MY_YAHOO_FIN_REST_API_URL = "http://172.29.81.234:3000";


  @Bean
  public WebClient myWebClient() {

    return WebClient.builder()
        .baseUrl(MY_YAHOO_FIN_REST_API_URL)
        .build();
  }
}
