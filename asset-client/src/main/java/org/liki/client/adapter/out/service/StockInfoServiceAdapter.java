package org.liki.client.adapter.out.service;

import java.util.List;
import org.liki.common.CommonHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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

  public Object getStockInfosByTickers(List<String> tickers) {

    try {
      return commonHttpClient.sendGetRequest(assetAdminServiceUrl + "/api/stock-info?tickers=" + String.join(",", tickers)).body();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

}
