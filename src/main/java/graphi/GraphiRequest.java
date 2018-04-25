package graphi;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.query.Query;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiRequest {

  private final GraphiResponse response;
  private final String payload;
  private final Query queryGraph;
  private final Object data;

  public GraphiRequest(String payload) throws IOException {
    this.response = new GraphiResponse();
    this.payload = payload;
    ObjectMapper mapper = new ObjectMapper();
    Map payloadMap = mapper.readValue(payload, Map.class);

    if (payloadMap == null || payloadMap.isEmpty()) {
      throw new IllegalArgumentException("Payload is null or empty.");
    }
    Map<String, Map<String, Object>> queryMap = (Map<String, Map<String, Object>>)payloadMap.get("query");
    Object data = new HashMap<>();
    if (queryMap == null) {
      /* if `queryGraph` param is missing, then whole payload is queryGraph, and data is empty */
      queryMap = new HashMap<>(payloadMap);
    } else {
      data = payloadMap.get("data");
    }

    this.queryGraph = new Query(queryMap, null);
    this.data = data;
  }

}
