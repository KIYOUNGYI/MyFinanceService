package org.liki.client.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.application.port.in.MemberPortfolioCommand;
import org.liki.client.application.port.in.ParseCsvUploadFileUseCase;
import org.liki.client.application.port.in.RegisterMemberPortfolioByCsvUseCase;
import org.liki.client.application.port.out.GetMemberPort;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.client.application.port.out.RegisterMemberPortfolioPort;
import org.liki.client.domain.CsvPortfolioElement;
import org.liki.common.UseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@UseCase
@Service
@Transactional
@RequiredArgsConstructor
public class RegisterMemberPortfolioByCsvService implements RegisterMemberPortfolioByCsvUseCase {

  private final ParseCsvUploadFileUseCase parseCsvUploadFileUseCase;

  private final GetStockInfoByTickersPort getStockInfoByTickersPort;

  private final GetMemberPort getMemberPort;

  private final RegisterMemberPortfolioPort registerMemberPortfolioPort;

  @Override
  public void registerMemberPortfolioByCsvFile(Long memberId, MultipartFile file) {

    List<CsvPortfolioElement> csvPortfolioElements = parseCsvUploadFileUseCase.parseCsvFile(file);

    List<String> tickers = csvPortfolioElements.stream().filter(t -> !t.getTicker().equals("")).map(t -> t.getTicker()).collect(Collectors.toList());
    Map<String, StockInfoJpaEntity> stockInfoMapByTickersMap = getStockInfoByTickersPort.getStockInfoMapByTickers(tickers);

    MemberJpaEntity memberJpaEntity = getMemberPort.getMember(memberId);

    List<MemberPortfolioCommand> memberPortfolioCommandList = new ArrayList<>();

    for (CsvPortfolioElement csvPortfolioElement : csvPortfolioElements) {

      String ticker = csvPortfolioElement.getTicker();
      StockInfoJpaEntity stockInfoJpaEntity = stockInfoMapByTickersMap.get(ticker);

      //Exception 처리
      if (stockInfoJpaEntity == null) {
        stockInfoJpaEntity = stockInfoMapByTickersMap.get(ticker.toLowerCase());
      }

      memberPortfolioCommandList.add(MemberPortfolioCommand.builder()
          .memberJpaEntity(memberJpaEntity)
          .stockInfoJpaEntity(stockInfoJpaEntity)
          .count(csvPortfolioElement.getCount())
          .avgPrice(csvPortfolioElement.getAvgPrice())
          .build());
    }

    List<MemberPortfolioJpaEntity> memberPortfolio = registerMemberPortfolioPort.createMemberPortfolio(memberPortfolioCommandList);
    log.info("memberPortfolio = {}", memberPortfolio);

  }
}
