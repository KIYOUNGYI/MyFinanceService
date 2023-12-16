package org.liki.client.application.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface RegisterMemberPortfolioByCsvUseCase {

//  void registerMemberPortfolioByCsvFile(Member member, MultipartFile file);

  void registerMemberPortfolioByCsvFile(Long memberId, MultipartFile file);

  void registerMemberPortfolioByCsvFileV2(Long memberId, MultipartFile file);
}
