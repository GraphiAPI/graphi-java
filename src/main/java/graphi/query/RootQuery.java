package graphi.query;

import graphi.Graphi;

import java.util.Map;

public class RootQuery extends Query {

  private QueryExecutionPlan executionPlan;

  public RootQuery(Graphi graphi, Map<String, Object> queryBody) {
    super(graphi, new Query(), ROOT, queryBody);
  }

}
