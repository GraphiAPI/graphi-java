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

  private String key;
  private String absoluteKey;
  private String returnKey;
  private String endpointName;
  private GraphiEndpoint endpoint;
  private String __using;
  private Map<String, Object> __args;

  private Query parent;
  private Map<String, Query> children = new HashMap<>();

  private QueryExecutor executor = Graphi.getDefaultExecutor();

  /* Create Root Query */
  public Query() {
    key = absoluteKey = returnKey = ROOT;
  }

  /* send absoluteKey=null or empty string to mark this query as root */
  public Query(Graphi graphi, Query parent, String key, Map<String, Object> queryBody) {
    this.parent = parent;
    this.key = key;
    this.absoluteKey = parent.getAbsoluteKey() + "." + key;

    /* Example query key -> "post: findPost", "post", "findPost", "post:", ":findPost" */
    String[] namePlusEndpointName = key.split(":");
    returnKey = namePlusEndpointName[0].isEmpty() ? namePlusEndpointName[1] : namePlusEndpointName[0];
    endpointName = namePlusEndpointName[namePlusEndpointName.length - 1];
    endpoint = graphi.getSchema().getGraphiEndpoint(endpointName);
    __using = (String)queryBody.remove(__USING);
    __args = (Map<String, Object>)queryBody.remove(__ARGS);
    for (String innerQueryKey : queryBody.keySet()) {
      children.put(innerQueryKey, new Query(graphi, this, innerQueryKey,
        (Map<String, Object>)queryBody.get(innerQueryKey)));
    }
  }

  public void

  public void tryExecute() {

  }

  /**************************************************/
  /* Getters
  /**************************************************/

  public String getKey() {
    return key;
  }

  public String getAbsoluteKey() {
    return absoluteKey;
  }

  public String getReturnKey() {
    return returnKey;
  }

  public GraphiEndpoint getEndpoint() {
    return endpoint;
  }

  public String get__using() {
    return __using;
  }

  public Map<String, Object> get__args() {
    return __args;
  }

  public Query getParent() {
    return parent;
  }

  public Map<String, Query> getChildren() {
    return children;
  }

}
