package graphi.query;

import graphi.query.executor.QueryExecutor;
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

  private String pathName;
  private String fullName;
  private String name;
  private String endpointName;
  private String __using;
  private QueryArguments __args;
  private Query parent;
  private Map<String, Query> children;
  private QueryExecutor executor;
  private boolean namedQuery = false; /* a fake query to change data output format */
  private GraphiJEndpoint endpoint;
  private QueryExecutionPlan executionPlan;
  private boolean isRootQuery = true;

  public Query(boolean isRootQuery) {
    this.children = new HashMap<>();
    this.isRootQuery = isRootQuery;
  }

  /* send path=null or empty string to mark this query as root */
  public Query(Map<String, Map<String, Object>> queryMap, String path) {
    this(path == null || path.isEmpty());
    this.pathName = path;
    queryMap.forEach((queryName, queryDef) -> {
      fullName = queryName;
      String[] namePlusEndpointName = fullName.split(":");
      name = namePlusEndpointName[0];
      endpointName = namePlusEndpointName[namePlusEndpointName.length - 1];
      namedQuery = resolveNamedQuery(queryDef);
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

  private Query getRootQuery() {
    return isRootQuery ? this : parent.getRootQuery();
  }

  private Map<String, Object>

  /**************************************************/
  /* Getters & Setters
  /**************************************************/
  //todo

}
