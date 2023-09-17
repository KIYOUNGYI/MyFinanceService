package org.liki.client.application.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.liki.client.application.port.in.ParseCsvUploadFileUseCase;
import org.liki.client.domain.CsvPortfolioElement;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ParseCsvUploadFileService implements ParseCsvUploadFileUseCase {

  @Override
  public List<CsvPortfolioElement> parseCsvFile(MultipartFile file) {
    if (file.isEmpty()) {
      throw new RuntimeException("File is empty");
    } else {

      // parse CSV file to create a list of `User` objects
      try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

        // create csv bean reader
        CsvToBean<CsvPortfolioElement> csvToBean = new CsvToBeanBuilder(reader)
            .withType(CsvPortfolioElement.class)
            .withIgnoreLeadingWhiteSpace(true)
            .build();

        // convert `CsvToBean` object to list of PortfolioElement
        List<CsvPortfolioElement> csvPortfolioElements = csvToBean.parse();
        log.info("portfolioElements: {}", csvPortfolioElements);

        return csvPortfolioElements;


      } catch (Exception ex) {
        log.error("Failed to parse CSV file {}", ex);
        throw new RuntimeException(ex);
      }
    }
  }
}
