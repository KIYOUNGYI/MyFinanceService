package org.liki.client.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.adapter.out.persistence.entity.MemberJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntity;
import org.liki.client.adapter.out.persistence.entity.MemberPortfolioJpaEntityV2;
import org.liki.client.adapter.out.persistence.entity.StockInfoJpaEntity;
import org.liki.client.adapter.out.service.MemberServiceAdapter;
import org.liki.client.adapter.out.service.StockInfoServiceAdapter;
import org.liki.client.application.port.in.MemberPortfolioCommand;
import org.liki.client.application.port.in.MemberPortfolioCommandV2;
import org.liki.client.application.port.in.ParseCsvUploadFileUseCase;
import org.liki.client.application.port.in.RegisterMemberPortfolioByCsvUseCase;
import org.liki.client.application.port.out.GetMemberPort;
import org.liki.client.application.port.out.GetStockInfoByTickersPort;
import org.liki.client.application.port.out.RegisterMemberCashPort;
import org.liki.client.application.port.out.RegisterMemberCashPortV2;
import org.liki.client.application.port.out.RegisterMemberPortfolioPort;
import org.liki.client.application.port.out.RegisterMemberPortfolioPortV2;
import org.liki.client.domain.CsvPortfolioElement;
import org.liki.client.domain.Member;
import org.liki.client.domain.StockInfo;
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

  private final RegisterMemberCashPort registerMemberCashPort;

  private final MemberServiceAdapter externalMemberServiceAdapter;

  private final StockInfoServiceAdapter externalStockInfoServiceAdapter;

  private final RegisterMemberPortfolioPortV2 registerMemberPortfolioPortV2;

  private final RegisterMemberCashPortV2 registerMemberCashPortV2;

  @Override
  public void registerMemberPortfolioByCsvFile(Long memberId, MultipartFile file) {

    List<CsvPortfolioElement> csvPortfolioElements = parseCsvUploadFileUseCase.parseCsvFile(file);

    List<String> tickers = csvPortfolioElements.stream().filter(t -> !t.getTicker().equals("")).map(t -> t.getTicker()).collect(Collectors.toList());
    Map<String, StockInfoJpaEntity> stockInfoMapByTickersMap = getStockInfoByTickersPort.getStockInfoMapByTickers(tickers);

    MemberJpaEntity memberJpaEntity = getMemberPort.getMember(memberId);

    List<MemberPortfolioCommand> memberPortfolioCommandList = new ArrayList<>();

    List<CsvPortfolioElement> filteredElements = csvPortfolioElements.stream().filter(t -> !t.getTicker().equals("usd")).collect(Collectors.toList());

    for (CsvPortfolioElement csvPortfolioElement : filteredElements) {

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

    for (CsvPortfolioElement csvPortfolioElement : csvPortfolioElements) {
      if (csvPortfolioElement.getTicker().equals("usd") || csvPortfolioElement.getTicker().equals("USD")) {
        Double cashAmount = csvPortfolioElement.getAvgPrice();
        registerMemberCashPort.registerMemberCash(memberJpaEntity, cashAmount);
        break;
      }
    }

  }

  @Override
  public void registerMemberPortfolioByCsvFileV2(Long memberId, MultipartFile file) {

    List<CsvPortfolioElement> csvPortfolioElements = parseCsvUploadFileUseCase.parseCsvFile(file);

    Member member = externalMemberServiceAdapter.getMemberByMemberId(memberId);

    List<MemberPortfolioCommandV2> memberPortfolioCommandV2List = new ArrayList<>();

    List<CsvPortfolioElement> filteredElements = csvPortfolioElements.stream().filter(t -> !t.getTicker().equals("usd")).collect(Collectors.toList());

    Map<String, StockInfo> stockInfosByTickers = externalStockInfoServiceAdapter.getStockInfosByTickers(filteredElements.stream().map(t -> t.getTicker()).collect(Collectors.toList()));

    for (CsvPortfolioElement csvPortfolioElement : filteredElements) {

      String ticker = csvPortfolioElement.getTicker();
      StockInfo stockInfo = stockInfosByTickers.get(ticker.toLowerCase());

//      log.error("ticker : {}, stockInfo : {}", ticker, stockInfo);
//      log.error("===========================================");

      memberPortfolioCommandV2List.add(MemberPortfolioCommandV2.builder()
          .memberId(member.getMemberId())
          .stockInfoId(stockInfo.getStockInfoId())
          .count(csvPortfolioElement.getCount())
          .avgPrice(csvPortfolioElement.getAvgPrice())
          .build());
    }


    List<MemberPortfolioJpaEntityV2> memberPortfolioV2 = registerMemberPortfolioPortV2.createMemberPortfolioV2(memberPortfolioCommandV2List);
//    log.info("memberPortfolioV2 = {}", memberPortfolioV2);

    for (CsvPortfolioElement csvPortfolioElement : csvPortfolioElements) {
      if (csvPortfolioElement.getTicker().equals("usd") || csvPortfolioElement.getTicker().equals("USD")) {
        registerMemberCashPortV2.registerMemberCash(memberId, csvPortfolioElement.getAvgPrice());
        break;
      }
    }


  }
}
