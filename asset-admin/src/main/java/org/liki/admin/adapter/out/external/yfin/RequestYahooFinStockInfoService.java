package org.liki.admin.adapter.out.external.yfin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.admin.application.port.out.RequestYahooFinStockInfoPort;
import org.liki.common.ExternalSystemAdapter;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@ExternalSystemAdapter
@RequiredArgsConstructor
public class RequestYahooFinStockInfoService implements RequestYahooFinStockInfoPort {

  private final WebClient myWebClient;

  @Override
  public YahooFinStockInfoResponse getStockInfo(String ticker) {

    String block = myWebClient.get()
        .uri("/api/stock-info/" + ticker)
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .bodyToMono(String.class)
        .block();

    System.out.println("block = " + block);
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(JsonReadFeature.ALLOW_NON_NUMERIC_NUMBERS.mappedFeature());
    try {
      System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
      YahooFinStockInfoResponse yahooFinStockInfoResponse = mapper.readValue(block, YahooFinStockInfoResponse.class);
      System.out.println("yahooFinStockInfoResponse =>>>> " + yahooFinStockInfoResponse);
      // yahooFinStockInfoResponse =>>>> YahooFinStockInfoResponse(oneYearTargetEst=null, fiftyTwoWeekRange=16.10 - 47.14, ask=41.65 x 1000, avgVolume=9.5964383E7, beta=3.46, daysRange=41.22 - 41.81, eps=null, earningsDate=null, exDividendDate=null, forwardDividendAndYield=null, marketCap=null, open=41.34, peRatio=NaN, previousClose=41.88, quotePrice=41.25, volume=1.8263459E7, bid=41.64 x 1100)
      return yahooFinStockInfoResponse;

    } catch (JsonProcessingException e) {
      System.out.println("error => " + e);
      throw new RuntimeException(e);
    }
  }
}
