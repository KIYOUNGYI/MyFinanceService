package org.liki.client.adapter.out.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.domain.StockInfo;
import org.liki.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StockInfoServiceAdapter {

  private final CommonHttpClient commonHttpClient;

  private final String assetAdminServiceUrl;

  public StockInfoServiceAdapter(CommonHttpClient commonHttpClient,
      @Value("${service.asset-admin.url}")
      String assetAdminServiceUrl) {
    this.commonHttpClient = commonHttpClient;
    this.assetAdminServiceUrl = assetAdminServiceUrl;
  }

  public Map<String, StockInfo> getStockInfosByTickers(List<String> tickers) {

    try {
      String body = commonHttpClient.sendGetRequest(assetAdminServiceUrl + "/api/stockInfo?tickers=" + String.join(",", tickers)).body();
      ObjectMapper objectMapper = new ObjectMapper();
      List<StockInfo> stockInfos = objectMapper.readValue(body, new TypeReference<List<StockInfo>>() {
      });

      Map<String, StockInfo> stockInfoMap = stockInfos.stream()
          .collect(Collectors.toMap(StockInfo::getTicker, stockInfo -> stockInfo));

      return stockInfoMap;

    } catch (Exception e) {
      log.error("error : ", e);
      throw new RuntimeException(e);
    }

  }

}
