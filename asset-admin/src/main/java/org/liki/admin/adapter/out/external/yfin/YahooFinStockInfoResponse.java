package org.liki.admin.adapter.out.external.yfin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * To avoid the UnrecognizedPropertyException error when deserializing JSON into your DTO (YahooFinStockInfoResponse), you can use Jackson's @JsonIgnoreProperties annotation to ignore unknown
 * properties. Here's how you can modify your DTO class:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using = PERatioDeserializer.class)
public class YahooFinStockInfoResponse {

  @JsonProperty("1y Target Est")
  private Double oneYearTargetEst;
  @JsonProperty("52 Week Range")
  private String fiftyTwoWeekRange;

  @JsonProperty("Ask")
  private String ask;

  @JsonProperty("Avg. Volume")
  private Double avgVolume;

  @JsonProperty("Beta (5Y Monthly)")
  private Double beta;//핵심

  @JsonProperty("Day's Range")
  private String daysRange;

  @JsonProperty("EPS (TTM)")
  private Double eps;//(TTM)

  @JsonProperty("Earnings Date")
  private String earningsDate;

  @JsonProperty("Ex-Dividend Date")
  private String exDividendDate;

  @JsonProperty("Forward Dividend & Yield")
  private String forwardDividendAndYield;

  @JsonProperty("Market Cap")
  private String marketCap;

  @JsonProperty("Open")
  private Double open;

  @JsonProperty("PE Ratio (TTM)")
  private Double peRatio;

  @JsonProperty("Previous Close")
  private Double previousClose;

  @JsonProperty("Quote Price")
  private Double quotePrice;

  @JsonProperty("Volume")
  private Double volume;

  @JsonProperty("Bid")
  private String bid;

//   "Expense Ratio (net)": "0.86%"

}
