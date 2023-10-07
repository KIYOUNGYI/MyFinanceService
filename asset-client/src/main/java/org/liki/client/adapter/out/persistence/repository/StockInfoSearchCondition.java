package org.liki.client.adapter.out.persistence.repository;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockInfoSearchCondition {

  private List<String> tickers;
}
