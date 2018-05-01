package graphi.query;

import graphi.Graphi;
import graphi.query.executor.QueryExecutor;
import graphi.schema.GraphiEndpoint;

import java.util.HashMap;
import java.util.Map;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
@SuppressWarnings("unchecked")
public class Query {

  public static final String ROOT = "root";
  public static final String __USING = "__using";
  public static final String __ARGS = "__args";

  private boolean namedQuery = true; /* a fake query to change data output format */
  private String key;
  private String absoluteKey;
  private String returnKey;
  private String endpointName;
  private GraphiEndpoint endpoint;
  private String __using;
  private QueryArguments __args;

  private Query parent;
  private Map<String, Query> children = new HashMap<>();

  /* Create Root Query */
  public Query() {
    key = absoluteKey = returnKey = ROOT;
    namedQuery = true;
  }

  /* send absoluteKey=null or empty string to mark this query as root */
  public Query(Graphi graphi, Query parent, Map<String, Object> queryMap) {
    __using = (String)queryMap.remove(__USING);
    __args = resolveArguments((Map<String, Object>)queryMap.remove(__ARGS));
    if (queryMap.isEmpty()) return;

    this.parent = parent;
    for (String queryName : queryMap.keySet()) {
      key = queryName;
      absoluteKey = parent.getAbsoluteKey() + "." + key;
      /*Example query key -> "post: findPost", "post", ":findPost" */
      String[] namePlusEndpointName = key.split(":");
      returnKey = namePlusEndpointName[0].isEmpty() ? namePlusEndpointName[1] : namePlusEndpointName[0];
      endpointName = namePlusEndpointName[namePlusEndpointName.length - 1];
      endpoint = graphi.getSchema().getGraphiEndpoint(endpointName);
      namedQuery = endpoint == null;
      if (namedQuery) {

      }
    }
    this.parent.getChildren().put(key, this);
  }

  private QueryArguments resolveArguments(Map<String, Object> args) {
    if (args == null) return null;
  }


  public Query getRootQuery() {
    return getParent() == null ? this : parent.getRootQuery();
  }

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

  public String getAbsoluteKey() {
    return absoluteKey;
  }

  public void setAbsoluteKey(String absoluteKey) {
    this.absoluteKey = absoluteKey;
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

  public GraphiEndpoint getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(GraphiEndpoint endpoint) {
    this.endpoint = endpoint;
  }
}
