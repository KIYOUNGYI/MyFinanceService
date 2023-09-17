package org.liki.client.application.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface RegisterMemberPortfolioByCsvUseCase {

  void registerMemberPortfolioByCsvFile(Long memberId, MultipartFile file);
}
