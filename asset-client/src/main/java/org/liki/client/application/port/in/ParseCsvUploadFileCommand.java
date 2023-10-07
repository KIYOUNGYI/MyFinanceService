package org.liki.client.application.port.in;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ParseCsvUploadFileCommand {

  MultipartFile file;

  public ParseCsvUploadFileCommand(MultipartFile file) {
    this.file = file;
  }

}
