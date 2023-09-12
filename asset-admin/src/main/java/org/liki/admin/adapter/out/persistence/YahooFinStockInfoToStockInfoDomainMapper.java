package org.liki.admin.adapter.out.persistence;

import lombok.extern.slf4j.Slf4j;
import org.liki.admin.adapter.out.external.yfin.YahooFinStockInfoResponse;
import org.liki.admin.domain.StockInfo;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class YahooFinStockInfoToStockInfoDomainMapper {


  public static StockInfo yahooFinStockInfoToStockInfoDomainMapper(YahooFinStockInfoResponse res, String ticker) {

    log.error(" YahooFinStockInfoToStockInfoDomainMapper.yahooFinStockInfoToStockInfoDomainMapper");
    log.info("  res : {}", res);

    return StockInfo.builder()
//        .companyName(res)
        .ticker(ticker)
        .oneYearTargetEst(res.getOneYearTargetEst() != null ? res.getOneYearTargetEst() : null)
        .fiftyTwoWeekRange(res.getFiftyTwoWeekRange() != null ? res.getFiftyTwoWeekRange() : null)
        .ask(res.getAsk() != null ? res.getAsk() : null)
        .avgVolume(res.getAvgVolume() != null ? res.getAvgVolume() : null)
        .beta(res.getBeta() != null ? res.getBeta() : null)
        .daysRange(res.getDaysRange() != null ? res.getDaysRange() : null)
        .eps(res.getEps() != null ? res.getEps() : null)
        .earningsDate(res.getEarningsDate() != null ? res.getEarningsDate() : null)
        .exDividendDate(res.getExDividendDate() != null ? res.getExDividendDate() : null)
        .exDividendDate(res.getExDividendDate() != null ? res.getExDividendDate() : null)
        .forwardDividendAndYield(res.getForwardDividendAndYield() != null ? res.getForwardDividendAndYield() : null)
        .marketCap(res.getMarketCap() != null ? res.getMarketCap() : null)
        .open(res.getOpen() != null ? res.getOpen() : null)
        .peRatio(res.getPeRatio() != null ? res.getPeRatio() : null)
        .previousClose(res.getPreviousClose() != null ? res.getPreviousClose() : null)
        .quotePrice(res.getQuotePrice() != null ? res.getQuotePrice() : null)
        .volume(res.getVolume() != null ? res.getVolume() : null)
        .build();


  }
}
