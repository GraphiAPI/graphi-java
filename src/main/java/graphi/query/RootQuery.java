package graphi.query;

import java.util.Map;

public class RootQuery extends Query {

  private QueryExecutionPlan executionPlan;

  public RootQuery(Map<String, Map<String, Object>> queryMap) {
    super(queryMap, null);
  }
}
