package graphi;

import java.util.List;
import java.util.Map;

public class GraphiOutput {

  private Object data;
  private List<Map> errors;

  public GraphiOutput(List<Map> errors) {
    this.errors = errors;
  }

  public GraphiOutput(Object data, List<Map> errors) {
    this.data = data;
    this.errors = errors;
  }

}
