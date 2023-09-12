package org.liki.admin.adapter.out.external.yfin;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class PERatioDeserializer extends JsonDeserializer<Double> {
  @Override
  public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {
    String value = jsonParser.getText();
    if (value == null || value.equalsIgnoreCase("NaN")) {
      return null;
    }

    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      // Handle parsing errors if needed
      return null;
    }
  }
}




