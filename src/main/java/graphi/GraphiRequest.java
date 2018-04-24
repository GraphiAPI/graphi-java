package graphi;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiRequest {

  private Query query;
  private Object data;

  public GraphiRequest(final Map<String, Object> payload) {
    if (payload == null || payload.isEmpty()) {
      throw new IllegalArgumentException("Payload is null or empty.");
    }
    Map<String, Object> query = (Map<String, Object>)payload.get("query");
    Object data = new HashMap<>();
    if (query == null) {
      /* if `query` param is missing, then whole payload is query, and data is empty */
      query = new HashMap<>(payload);
    } else {
      data = payload.get("data");
    }

    this.data = data;
  }
}
