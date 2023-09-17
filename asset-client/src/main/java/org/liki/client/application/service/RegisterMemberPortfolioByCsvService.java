package org.liki.client.application.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.ParseCsvUploadFileUseCase;
import org.liki.client.application.port.in.RegisterMemberPortfolioByCsvUseCase;
import org.liki.client.domain.CsvPortfolioElement;
import org.liki.common.UseCase;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@UseCase
@Service
@RequiredArgsConstructor
public class RegisterMemberPortfolioByCsvService implements RegisterMemberPortfolioByCsvUseCase {

  private final ParseCsvUploadFileUseCase parseCsvUploadFileUseCase;

//  private final

  @Override
  public void registerMemberPortfolioByCsvFile(Long memberId, MultipartFile file) {

    //read file (csv -> List<pojo>)
    List<CsvPortfolioElement> csvPortfolioElements = parseCsvUploadFileUseCase.parseCsvFile(file);

    //stockInfo 에서 종목 정보 db 에 있는거 가져오고 (나중엔 no-sql ex> dynamodb 에서 가져오도록 변경)
    List<String> tickers = csvPortfolioElements.stream().map(t -> t.getTicker()).collect(Collectors.toList());

    // 그걸 바탕으로 member_portfolio 에 insert


  }
}
