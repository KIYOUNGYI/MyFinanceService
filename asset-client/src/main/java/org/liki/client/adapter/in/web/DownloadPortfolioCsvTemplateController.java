package org.liki.client.adapter.in.web;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.liki.common.WebAdapter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@WebAdapter//굳이 의미가 있나,
@RestController
public class DownloadPortfolioCsvTemplateController {

  @GetMapping("/api/portfolio/download-csv-template")
  public ResponseEntity<Resource> downloadCsvTemplate() throws IOException {

    log.info("downloadCsvTemplate() called");

    // Load the CSV template file from the resources directory
    Resource resource = new ClassPathResource("templates/portfolio_sample_upload.csv");

    // Set the content type and attachment disposition headers
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=portfolio_sample_upload.csv");

    // Return the file as a ResponseEntity
    return ResponseEntity.ok()
        .headers(headers)
        .contentType(MediaType.APPLICATION_OCTET_STREAM)
        .body(resource);
  }
}
