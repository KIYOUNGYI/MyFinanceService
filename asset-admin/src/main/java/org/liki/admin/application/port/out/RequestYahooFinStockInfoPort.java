package org.liki.admin.application.port.out;

import org.liki.admin.adapter.out.external.yfin.YahooFinStockInfoResponse;

public interface RequestYahooFinStockInfoPort {

  YahooFinStockInfoResponse getStockInfo(String ticker);
}
