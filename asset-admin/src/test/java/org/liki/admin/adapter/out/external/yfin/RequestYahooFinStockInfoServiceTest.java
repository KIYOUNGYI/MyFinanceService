package org.liki.admin.adapter.out.external.yfin;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RequestYahooFinStockInfoServiceTest {

  @Autowired
  RequestYahooFinStockInfoService service;

  @Test
  void api_call_test() {

    YahooFinStockInfoResponse tsla = service.getStockInfo("TSLA");
    System.out.println("tsla = " + tsla.toString());
  }

  //https://domdom.tistory.com/457


}