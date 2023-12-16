package org.liki.admin.application.port.in;

import java.util.List;
import org.liki.admin.domain.StockInfo;


public interface GetStockInfoListUseCase {

  List<StockInfo> getStockInfoList(List<String> tickers);
}
