package graphi;


import com.fasterxml.jackson.annotation.JsonRawValue;

public class GraphiRequestPayload {

  @JsonRawValue
  private String rawQuery;

  @JsonRawValue
  private String rawData;

  public String getRawQuery() {
    return rawQuery;
  }

  public void setRawQuery(String rawQuery) {
    this.rawQuery = rawQuery;
  }

  public String getRawData() {
    return rawData;
  }

  public void setRawData(String rawData) {
    this.rawData = rawData;
  }
}
