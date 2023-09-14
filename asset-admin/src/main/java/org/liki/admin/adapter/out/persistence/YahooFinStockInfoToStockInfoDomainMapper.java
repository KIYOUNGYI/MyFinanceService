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

    Double peRatio = res.getPeRatio();
    System.out.println(">> peRatio => " + peRatio);

    return StockInfo.builder()
//        .companyName(res)
        .ticker(ticker)
        .oneYearTargetEst(res.getOneYearTargetEst() == null ? null : ((Double.isNaN(res.getOneYearTargetEst()) ? null : res.getOneYearTargetEst())))
        .fiftyTwoWeekRange(res.getFiftyTwoWeekRange() != null ? res.getFiftyTwoWeekRange() : null)
        .ask(res.getAsk() != null ? res.getAsk() : null)
        .avgVolume(res.getAvgVolume() == null ? null : ((Double.isNaN(res.getAvgVolume()) ? null : res.getAvgVolume())))
        .beta(res.getBeta() == null ? null : ((Double.isNaN(res.getBeta()) ? null : res.getBeta())))
        .daysRange(res.getDaysRange() != null ? res.getDaysRange() : null)
        .eps(res.getEps() == null ? null : ((Double.isNaN(res.getEps()) ? null : res.getEps())))
        .earningsDate(res.getEarningsDate() != null ? res.getEarningsDate() : null)
        .exDividendDate(res.getExDividendDate() != null ? res.getExDividendDate() : null)
        .exDividendDate(res.getExDividendDate() != null ? res.getExDividendDate() : null)
        .forwardDividendAndYield(res.getForwardDividendAndYield() != null ? res.getForwardDividendAndYield() : null)
        .marketCap(res.getMarketCap() != null ? res.getMarketCap() : null)
        .volume(res.getOpen() == null ? null : ((Double.isNaN(res.getOpen()) ? null : res.getOpen())))
        .peRatio(res.getPeRatio() == null ? null : ((Double.isNaN(res.getPeRatio()) ? null : res.getPeRatio())))
        .previousClose(res.getPreviousClose() == null ? null : ((Double.isNaN(res.getPreviousClose()) ? null : res.getPreviousClose())))
        .quotePrice(res.getQuotePrice() == null ? null : ((Double.isNaN(res.getQuotePrice()) ? null : res.getQuotePrice())))
        .volume(res.getVolume() == null ? null : ((Double.isNaN(res.getVolume()) ? null : res.getVolume())))
        .build();


  }
}
