package org.liki.admin.adapter.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "StockInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockInfoJpaEntity {

  @Id
  @GeneratedValue
  private Long idStockInfo;
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
  public StockInfoJpaEntity(String companyName, String ticker, Double oneYearTargetEst, String fiftyTwoWeekRange, String ask, Double avgVolume, Double beta, String daysRange, Double eps,
      String earningsDate, String exDividendDate, String forwardDividendAndYield, String marketCap, Double open, Double peRatio, Double previousClose, Double quotePrice, Double volume) {
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
}
