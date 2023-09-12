package org.liki.admin.adapter.out.external.yfin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YahooFinStockInfoRequest {

  private String ticker;
}
