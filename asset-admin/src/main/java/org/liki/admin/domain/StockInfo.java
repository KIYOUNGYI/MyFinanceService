package org.liki.admin.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;

/**
 * {
 *   "1y Target Est": 224.18,
 *   "52 Week Range": "101.81 - 313.80",
 *   "Ask": "249.03 x 800",
 *   "Avg. Volume": 125584417.0,
 *   "Beta (5Y Monthly)": 2.09,
 *   "Bid": "248.98 x 1800",
 *   "Day's Range": "246.67 - 256.52",
 *   "EPS (TTM)": 3.5,
 *   "Earnings Date": "Oct 17, 2023 - Oct 23, 2023",
 *   "Ex-Dividend Date": NaN,
 *   "Forward Dividend & Yield": "N/A (N/A)",
 *   "Market Cap": "788.737B",
 *   "Open": 251.22,
 *   "PE Ratio (TTM)": 71.0,
 *   "Previous Close": 251.49,
 *   "Quote Price": 248.5,
 *   "Volume": 117545652.0
 * }
 */
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class StockInfo {

  private Long stockInfoId;
  private String companyName;
  private String ticker;
  private Double oneYearTargetEst;
  private String fiftyTwoWeekRange;
  private String ask;
  private Double avgVolume;
  private Double beta;//핵심
  private String daysRange;
  private Double eps;//(TTM)
  private String earningsDate;
  private String exDividendDate;
  private String forwardDividendAndYield;
  private String marketCap;
  private Double open;
  private Double peRatio;
  private Double previousClose;
  private Double quotePrice;
  private Double volume;

  @Builder
  public StockInfo(Long stockInfoId, String companyName, String ticker, Double oneYearTargetEst, String fiftyTwoWeekRange, String ask, Double avgVolume, Double beta, String daysRange, Double eps,
      String earningsDate, String exDividendDate, String forwardDividendAndYield, String marketCap, Double open, Double peRatio, Double previousClose, Double quotePrice, Double volume) {
    this.stockInfoId = stockInfoId;
    this.companyName = companyName;
    this.ticker = ticker;
    this.oneYearTargetEst = oneYearTargetEst;
    this.fiftyTwoWeekRange = fiftyTwoWeekRange;
    this.ask = ask;
    this.avgVolume = avgVolume;
    this.beta = beta;
    this.daysRange = daysRange;
    this.eps = eps;
    this.earningsDate = earningsDate;
    this.exDividendDate = exDividendDate;
    this.forwardDividendAndYield = forwardDividendAndYield;
    this.marketCap = marketCap;
    this.open = open;
    this.peRatio = peRatio;
    this.previousClose = previousClose;
    this.quotePrice = quotePrice;
    this.volume = volume;
  }

  public static StockInfo generateStockInfo(
      IdStockInfo idStockInfo,
      CompanyName companyName,
      Ticker ticker,
      OneYearTargetEst oneYearTargetEst,
      FiftyTwoWeekRange fiftyTwoWeekRange,
      Ask ask,
      AvgVolume avgVolume,
      Beta beta,
      DaysRange daysRange,
      Eps eps,
      EarningsDate earningsDate,
      ExDividendDate exDividendDate,
      ForwardDividendAndYield forwardDividendAndYield,
      MarketCap marketCap,
      Open open,
      PeRatio peRatio,
      PreviousClose previousClose,
      QuotePrice quotePrice,
      Volume volume
  ) {

    return new StockInfo(
        idStockInfo.idStockInfo,
        companyName.companyName,
        ticker.ticker,
        oneYearTargetEst.oneYearTargetEst,
        fiftyTwoWeekRange.fiftyTwoWeekRange,
        ask.ask,
        avgVolume.avgVolume,
        beta.beta,
        daysRange.daysRange,
        eps.eps,
        earningsDate.earningsDate,
        exDividendDate.exDividendDate,
        forwardDividendAndYield.forwardDividendAndYield,
        marketCap.marketCap,
        open.open,
        peRatio.peRatio,
        previousClose.previousClose,
        quotePrice.quotePrice,
        volume.volume
    );
  }

  @Value
  @AllArgsConstructor
  public static class IdStockInfo {

    Long idStockInfo;
  }

  @Value
  public static class CompanyName {

    public CompanyName(String companyName) {
      this.companyName = companyName;
    }

    String companyName;
  }

  @Value
  public static class Ticker {

    public Ticker(String ticker) {
      this.ticker = ticker;
    }

    String ticker;
  }

  @Value
  public static class OneYearTargetEst {

    public OneYearTargetEst(Double oneYearTargetEst) {
      this.oneYearTargetEst = oneYearTargetEst;
    }

    Double oneYearTargetEst;
  }

  @Value
  public static class FiftyTwoWeekRange {

    public FiftyTwoWeekRange(String fiftyTwoWeekRange) {
      this.fiftyTwoWeekRange = fiftyTwoWeekRange;
    }

    String fiftyTwoWeekRange;
  }

  @Value
  public static class Ask {

    public Ask(String ask) {
      this.ask = ask;
    }

    String ask;
  }

  @Value
  public static class AvgVolume {

    public AvgVolume(Double avgVolume) {
      this.avgVolume = avgVolume;
    }

    Double avgVolume;
  }

  @Value
  public static class Beta {

    public Beta(Double beta) {
      this.beta = beta;
    }

    Double beta;
  }

  @Value
  public static class DaysRange {

    public DaysRange(String daysRange) {
      this.daysRange = daysRange;
    }

    String daysRange;
  }

  @Value
  public static class Eps {

    public Eps(Double eps) {
      this.eps = eps;
    }

    Double eps;
  }

  @Value
  public static class EarningsDate {

    public EarningsDate(String earningsDate) {
      this.earningsDate = earningsDate;
    }

    String earningsDate;
  }

  @Value
  public static class ExDividendDate {

    public ExDividendDate(String exDividendDate) {
      this.exDividendDate = exDividendDate;
    }

    String exDividendDate;
  }

  @Value
  public static class ForwardDividendAndYield {

    public ForwardDividendAndYield(String forwardDividendAndYield) {
      this.forwardDividendAndYield = forwardDividendAndYield;
    }

    String forwardDividendAndYield;
  }

  @Value
  public static class MarketCap {

    public MarketCap(String marketCap) {
      this.marketCap = marketCap;
    }

    String marketCap;
  }

  @Value
  public static class Open {

    public Open(Double open) {
      this.open = open;
    }

    Double open;
  }

  @Value
  public static class PeRatio {

    public PeRatio(Double peRatio) {
      this.peRatio = peRatio;
    }

    Double peRatio;
  }

  @Value
  public static class PreviousClose {

    public PreviousClose(Double previousClose) {
      this.previousClose = previousClose;
    }

    Double previousClose;
  }

  @Value
  public static class QuotePrice {

    public QuotePrice(Double quotePrice) {
      this.quotePrice = quotePrice;
    }

    Double quotePrice;
  }

  @Value
  public static class Volume {

    public Volume(Double volume) {
      this.volume = volume;
    }

    Double volume;
  }
}
