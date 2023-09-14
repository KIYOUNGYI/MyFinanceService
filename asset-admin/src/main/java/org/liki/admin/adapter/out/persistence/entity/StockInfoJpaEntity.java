package org.liki.admin.adapter.out.persistence.entity;

import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.admin.domain.StockInfo;

@Entity
@Table(name = "StockInfo")
//@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
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

  private Timestamp createdAt;

  private Timestamp updatedAt;

  @PrePersist
  public void prePersist() {
    this.createdAt = new Timestamp(Instant.now().toEpochMilli());
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = new Timestamp(Instant.now().toEpochMilli());
  }

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

  public StockInfoJpaEntity updateBeta(Double givenBetaValue) {
    this.beta = givenBetaValue;
    return this;
  }

  public StockInfoJpaEntity updateStockInfo(StockInfo domain) {

    log.error("StockInfoJpaEntity.updateStockInfo");

    this.oneYearTargetEst = domain.getOneYearTargetEst();
    this.fiftyTwoWeekRange = domain.getFiftyTwoWeekRange();
    this.ask = domain.getAsk();
    this.avgVolume = domain.getAvgVolume();
    this.beta = domain.getBeta();
    this.daysRange = domain.getDaysRange();
    this.eps = domain.getEps();
    this.earningsDate = domain.getEarningsDate();
    this.exDividendDate = domain.getExDividendDate();
    this.forwardDividendAndYield = domain.getForwardDividendAndYield();
    this.marketCap = domain.getMarketCap();
    this.open = domain.getOpen();
    this.peRatio = domain.getPeRatio();
    this.previousClose = domain.getPreviousClose();
    this.quotePrice = domain.getQuotePrice();
    this.volume = domain.getVolume();

    return this;
  }
}
