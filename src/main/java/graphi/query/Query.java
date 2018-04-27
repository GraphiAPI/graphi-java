package graphi.query;

import graphi.query.executor.QueryExecutor;
import graphi.schema.GraphiJEndpoint;

import java.util.Map;

import static graphi.Graphi.*;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
public class Query {

  public static final String __USING = "__using";
  public static final String __ARGS = "__args";

  private Query parent;
  private String path;
  private String key;
  private String returnKey;
  private String endpointName;
  private String __using;
  private QueryArguments __args;
  private Map<String, Query> children;
  private QueryExecutor executor;
  private boolean namedQuery = true; /* a fake query to change data output format */
  private GraphiJEndpoint endpoint;

  /* send path=null or empty string to mark this query as root */
  public Query(Map<String, Map<String, Object>> queryMap, Query parent) {
    this.parent = parent;
    queryMap.forEach((queryName, queryDef) -> {
      key = queryName;
      String[] namePlusEndpointName = key.split(":");
      returnKey = namePlusEndpointName[0];
      endpointName = namePlusEndpointName[namePlusEndpointName.length - 1];
      endpoint = graphi().getSchema().getGraphiEndpoint(endpointName);
      namedQuery = endpoint == null;

      if (namedQuery) return;



    });
  }

  private String resolvePath() {

  }

  public Query getRootQuery() {
    return getParent() == null ? this : parent.getRootQuery();
  }

  private Map<String, Object>

  /**************************************************/
  /* Getters & Setters
  /**************************************************/
  //todo

  public static String get_using() {
    return __USING;
  }

  public static String get_args() {
    return __ARGS;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getReturnKey() {
    return returnKey;
  }

  public void setReturnKey(String returnKey) {
    this.returnKey = returnKey;
  }

  public String getEndpointName() {
    return endpointName;
  }

  public void setEndpointName(String endpointName) {
    this.endpointName = endpointName;
  }

  public String get__using() {
    return __using;
  }

  public void set__using(String __using) {
    this.__using = __using;
  }

  public QueryArguments get__args() {
    return __args;
  }

  public void set__args(QueryArguments __args) {
    this.__args = __args;
  }

  public Query getParent() {
    return parent;
  }

  public void setParent(Query parent) {
    this.parent = parent;
  }

  public Map<String, Query> getChildren() {
    return children;
  }

  public void setChildren(Map<String, Query> children) {
    this.children = children;
  }

  public QueryExecutor getExecutor() {
    return executor;
  }

  public void setExecutor(QueryExecutor executor) {
    this.executor = executor;
  }

  public boolean isNamedQuery() {
    return namedQuery;
  }

  public void setNamedQuery(boolean namedQuery) {
    this.namedQuery = namedQuery;
  }

  public GraphiJEndpoint getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(GraphiJEndpoint endpoint) {
    this.endpoint = endpoint;
  }
}
