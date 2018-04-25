package graphi.query;

import graphi.query.executor.CommandExecutor;
import graphi.schema.GraphiJEndpoint;

import java.util.HashMap;
import java.util.Map;

import static graphi.Graphi.*;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
public class Query {

  public static final String NAMED_QUERY = "namedQuery";
  private static final String __USING = "__using";
  private static final String __ARGS = "__args";

  private String fullName;
  private String name;
  private String endpointName;
  private String __using;
  private QueryArguments __args;
  private Map<String, Query> children;
  private CommandExecutor executor;
  private boolean executeAsync = true;
  private boolean namedQuery = false; /* a fake query to change data output format */
  private GraphiJEndpoint endpoint;

  public Query() {
    children = new HashMap<>();
  }

  public Query(Map<String, Map<String, Object>> queryMap) {
    queryMap.forEach((key, obj) -> {
      fullName = key;
      String[] namePlusEndpointName = fullName.split(":");
      name = namePlusEndpointName[0];
      endpointName = namePlusEndpointName[namePlusEndpointName.length - 1];
      namedQuery = resolveNamedQuery(obj);
      if (!namedQuery) {
        endpoint = graphi().getSchema().getGraphiEndpoint(endpointName);
        namedQuery = endpoint == null;
      }
      if (namedQuery) return;



    });
  }

  private boolean resolveNamedQuery(Map<String, Object> obj) {
    return NAMED_QUERY.equals(endpointName) || NAMED_QUERY.equals(obj.get(__USING));
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
