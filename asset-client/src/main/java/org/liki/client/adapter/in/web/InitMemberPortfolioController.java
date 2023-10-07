package org.liki.client.adapter.in.web;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.InitMemberPortfolioCommand;
import org.liki.client.application.port.in.InitMemberPortfolioUseCase;
import org.liki.common.WebAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class InitMemberPortfolioController {

  private final InitMemberPortfolioUseCase initMemberPortfolioUseCase;

  /**
   * soft-delete 으로 구현하는게 맞지 않나 싶다.
   */
  @DeleteMapping("/api/portfolio")
  public void initMemberPortfolio(HttpServletRequest request) {

    //TODO : token validation

    //TODO : call member-sevice to get member id
    Long memberId = 10L;//일단 임시로 1L로 설정

    //TODO : call portfolio-service to delete member portfolio
    log.info("deleteMemberPortfolio() called");

    InitMemberPortfolioCommand command = InitMemberPortfolioCommand.builder().memberId(memberId).build();

    initMemberPortfolioUseCase.initMemberPortfolio(command);

    return;
  }

}
