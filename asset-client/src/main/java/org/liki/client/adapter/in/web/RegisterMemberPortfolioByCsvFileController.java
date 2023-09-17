package org.liki.client.adapter.in.web;

import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.GetMemberCommand;
import org.liki.client.application.port.in.GetMemberUseCase;
import org.liki.client.application.port.in.RegisterMemberPortfolioByCsvUseCase;
import org.liki.client.domain.Member;
import org.liki.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;


@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class RegisterMemberPortfolioByCsvFileController {

  private final GetMemberUseCase getMemberUseCase;
  private final RegisterMemberPortfolioByCsvUseCase registerMemberPortfolioByCsvUseCase;

  @PostMapping("/api/portfolio/upload-csv")
  public void registerMemberPortfolioByCsvFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws IOException {

    //TODO : token validation

    //TODO : call member-sevice to get member id
    Long memberId = 1L;//일단 임시로 1L로 설정
    GetMemberCommand command = GetMemberCommand.builder().id(memberId).build();
    Member member = getMemberUseCase.getMember(command);

    registerMemberPortfolioByCsvUseCase.registerMemberPortfolioByCsvFile(member, file);

    return;
  }


}
