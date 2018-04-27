package graphi;

import graphi.query.QueryResult;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphiResponse {

  private final GraphiRequest request;
  private final QueryResult result;
  private Object data;
  private List<Map> errors;

  public GraphiResponse(GraphiRequest request) {
    this.request = request;
    this.data = new HashMap<>();
    this.errors = new LinkedList<>();
    this.result = new QueryResult();
  }

  public static GraphiResponse empty() {
    return new GraphiResponse(Collections.emptyMap(), Collections.emptyList());
  }

}
