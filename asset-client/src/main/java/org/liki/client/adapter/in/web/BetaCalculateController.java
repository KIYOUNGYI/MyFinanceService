package org.liki.client.adapter.in.web;


import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.BetaCalculateUseCase;
import org.liki.common.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController//굳이 의미가 있나 (webadapter 를 의미상 단다는게 - 일단 헥사곤탈 아키텍쳐 샘플이 그러하니 속는셈치고 해보자)
@RequiredArgsConstructor
@Slf4j
public class BetaCalculateController {

  private final BetaCalculateUseCase betaCalculateUseCase;


  @GetMapping("/api/portfolio/beta")
  public void calculateBeta(HttpServletRequest request) {

    log.info("calculateBeta() called");

    Long memberId = 10L;//일단 임시로 10L로 설정


    return;
  }

}
