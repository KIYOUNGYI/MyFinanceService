package org.liki.client.adapter.in.web;

import com.sun.xml.bind.v2.TODO;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.liki.common.WebAdapter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@WebAdapter
@RestController
@RequiredArgsConstructor
@Slf4j
public class UploadMemberPortfolioByCsvFileController {


  //TODO: 인증/권한 체크

  @PostMapping("/api/portfolio/upload-csv")
  public void registerMemberPortfolioByCsvFile(@RequestParam("file") MultipartFile file) throws IOException {


  }


}
