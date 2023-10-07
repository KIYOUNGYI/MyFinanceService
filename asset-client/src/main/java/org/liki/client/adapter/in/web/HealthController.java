package org.liki.client.adapter.in.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.common.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class HealthController {

  @GetMapping("/api/health")
  public String healthCheck() {
    log.info("asset-client healthCheck() called");
    return "Everything is fine!";
  }

}
