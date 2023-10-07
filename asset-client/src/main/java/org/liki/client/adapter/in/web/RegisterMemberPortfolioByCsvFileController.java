package org.liki.client.adapter.in.web;

import io.jsonwebtoken.Claims;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.RegisterMemberPortfolioByCsvUseCase;
import org.liki.client.config.JwtProvider;
import org.liki.client.domain.AuthPayload;
import org.liki.common.WebAdapter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterMemberPortfolioByCsvFileController {

  private final RegisterMemberPortfolioByCsvUseCase registerMemberPortfolioByCsvUseCase;
  private final JwtProvider jwtProvider;


  @PostMapping("/api/portfolio/upload-csv")
  public void registerMemberPortfolioByCsvFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {

    //TODO : token validation

    //TODO : call member-sevice to get member id

    String token = request.getHeader(HttpHeaders.AUTHORIZATION);

    Long memberId = jwtProvider.parseJwtTokenAndReturnMemberId(token);
    System.out.println("memberId ==== > " + memberId);

    registerMemberPortfolioByCsvUseCase.registerMemberPortfolioByCsvFile(memberId, file);

    return;
  }


}
