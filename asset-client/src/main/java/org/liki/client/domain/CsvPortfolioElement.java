package org.liki.client.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class CsvPortfolioElement {


  @CsvBindByName(column = "종목 100개")
  private String ticker;
  @CsvBindByName(column = "보유량")
  private String count;
  @CsvBindByName(column = "평단가")
  private Double avgPrice;

  public CsvPortfolioElement() {
  }

  public CsvPortfolioElement(String ticker, String count, Double avgPrice) {
    this.ticker = ticker;
    this.count = count;
    this.avgPrice = avgPrice;
  }
}