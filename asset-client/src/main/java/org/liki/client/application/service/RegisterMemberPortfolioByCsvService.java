package org.liki.client.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.GetStockInfoByTickersUseCase;
import org.liki.client.application.port.in.MemberPortfolioCommand;
import org.liki.client.application.port.in.ParseCsvUploadFileUseCase;
import org.liki.client.application.port.in.RegisterMemberPortfolioByCsvUseCase;
import org.liki.client.application.port.in.RegisterMemberPortfolioCommand;
import org.liki.client.application.port.in.RegisterMemberPortfolioUseCase;
import org.liki.client.domain.CsvPortfolioElement;
import org.liki.client.domain.Member;
import org.liki.client.domain.MemberPortfolio;
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

  private final GetStockInfoByTickersUseCase getStockInfoByTickersUseCase;

  private final RegisterMemberPortfolioUseCase registerMemberPortfolio;


  @Override
  public void registerMemberPortfolioByCsvFile(Member member, MultipartFile file) {

    //read file (csv -> List<pojo>)
    List<CsvPortfolioElement> csvPortfolioElements = parseCsvUploadFileUseCase.parseCsvFile(file);

    //stockInfo 에서 종목 정보 db 에 있는거 가져오고 (나중엔 no-sql ex> dynamodb 에서 가져오도록 변경)
    List<String> tickers = csvPortfolioElements.stream().filter(t -> !t.getTicker().equals("")).map(t -> t.getTicker()).collect(Collectors.toList());

    Map<String, StockInfo> stockInfosByTickers = getStockInfoByTickersUseCase.getStockInfosByTickers(tickers);

    List<MemberPortfolioCommand> memberPortfolioCommandList = new ArrayList<>();

    for (CsvPortfolioElement csvPortfolioElement : csvPortfolioElements) {

      String ticker = csvPortfolioElement.getTicker();

      memberPortfolioCommandList.add(MemberPortfolioCommand.builder()
          .member(member)
          .stockInfo(stockInfosByTickers.get(ticker))
          .count(csvPortfolioElement.getCount())
          .avgPrice(csvPortfolioElement.getAvgPrice())
          .build());
    }

    RegisterMemberPortfolioCommand build = RegisterMemberPortfolioCommand.builder().memberPortfolioCommandList(memberPortfolioCommandList).build();
    List<MemberPortfolio> result = registerMemberPortfolio.registerMemberPortfolio(build);

  }
}
