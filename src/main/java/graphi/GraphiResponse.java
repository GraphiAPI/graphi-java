package graphi;

import graphi.query.QueryResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphiResponse {

  private Object data;
  private List<Map> errors;
  private final QueryResult result;

  public GraphiResponse() {
    this.data = new HashMap<>();
    this.errors = new LinkedList<>();
    this.result = new QueryResult();
  }

  public GraphiResponse(List<Map> errors) {
    this();
    this.errors.addAll(errors);
  }

  public GraphiResponse(Object data, List<Map> errors) {
    this();
  }

  public static GraphiResponse empty() {
    return new GraphiResponse(Collections.emptyMap(), Collections.emptyList());
  }

}
