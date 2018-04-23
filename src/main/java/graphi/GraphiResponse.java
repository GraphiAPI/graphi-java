package graphi;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GraphiResponse {

  private Object data;
  private List<Map> errors;

  public GraphiResponse(List<Map> errors) {
    this.errors = errors;
  }

  public GraphiResponse(Object data, List<Map> errors) {
    this.data = data;
    this.errors = errors;
  }

  public static GraphiResponse empty() {
    return new GraphiResponse(Collections.emptyMap(), Collections.emptyList());
  }

}
