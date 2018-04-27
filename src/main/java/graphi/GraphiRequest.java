package graphi;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.query.Query;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiRequest {

  private final GraphiResponse response;
  private final GraphiRequestPayload payload;
  private final Query query;
  private final Object data;

  public GraphiRequest(String rawPayload) throws IOException {
    this.response = new GraphiResponse(this);
    ObjectMapper mapper = new ObjectMapper();
    this.payload = mapper.readValue(rawPayload, GraphiRequestPayload.class);
    Map payloadMap = mapper.readValue(rawPayload, Map.class);

    if (payloadMap == null || payloadMap.isEmpty()) {
      throw new IllegalArgumentException("Payload is null or empty.");
    }
    Map<String, Map<String, Object>> queryMap = (Map<String, Map<String, Object>>)payloadMap.get("query");
    Object data = new HashMap<>();
    if (queryMap == null) {
      /* if `query` param is missing, then whole payload is query, and data is empty */
      queryMap = new HashMap<>(payloadMap);
    } else {
      data = payloadMap.get("data");
    }

    this.query = Graphi.graphi().resolveQuery(payload.getRawQuery());
    this.data = data;
  }

}
