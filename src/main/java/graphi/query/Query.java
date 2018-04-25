package graphi.query;

import graphi.Graphi;
import graphi.query.executor.CommandExecutor;
import graphi.schema.GraphiJEndpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
public class Query {

  private String name;
  private QueryArguments arguments;
  private Map<String, Query> children;
  private CommandExecutor executor;
  private Boolean executeAsync = true;
  private Boolean namedQuery = false; /* a fake query to change data output format */
  private GraphiJEndpoint endpoint;

  public Query() {
    children = new HashMap<>();
  }

  public Query(Map<String, Object> queryMap) {
    queryMap.forEach((key, obj) -> {
      String[] namePlusCommandName = key.split(":");
      name = namePlusCommandName[0];
      endpoint = resolveEndpoint(namePlusCommandName);
      namedQuery = resolveNamedQuery();
      if (namedQuery) return;

    });
  }

  private GraphiJEndpoint resolveEndpoint(String[] namePlusCommandName) {
    return Graphi.graphi().getSchema()
      .getGraphiEndpoint(namePlusCommandName[namePlusCommandName.length - 1]);
  }

  private Boolean resolveNamedQuery() {
    return endpoint == null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Map<String, Query> getChildren() {
    return children;
  }

  public void setChildren(Map<String, Query> children) {
    this.children = children;
  }

  public CommandExecutor getExecutor() {
    return executor;
  }

  public void setExecutor(CommandExecutor executor) {
    this.executor = executor;
  }

  public Boolean getExecuteAsync() {
    return executeAsync;
  }

  public void setExecuteAsync(Boolean executeAsync) {
    this.executeAsync = executeAsync;
  }

}
