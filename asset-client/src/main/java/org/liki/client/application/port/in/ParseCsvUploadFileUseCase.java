package org.liki.client.application.port.in;

import java.util.List;
import org.liki.client.domain.CsvPortfolioElement;
import org.springframework.web.multipart.MultipartFile;

public interface ParseCsvUploadFileUseCase {

  List<CsvPortfolioElement> parseCsvFile(MultipartFile file);
}
