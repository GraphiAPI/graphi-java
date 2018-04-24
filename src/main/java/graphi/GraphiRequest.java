package graphi;

import graphi.command.Command;

import java.util.HashMap;
import java.util.Map;

import static graphi.GraphiBuilders.*;

@SuppressWarnings("unchecked")
public class GraphiRequest {

  private Command command;
  private Object data;

  public GraphiRequest(final Map<String, Object> payload) {
    if (payload == null || payload.isEmpty()) {
      throw new IllegalArgumentException("Payload is null or empty.");
    }
    Map<String, Object> cmd = (Map<String, Object>)payload.get("cmd");
    Object data = new HashMap<>();
    if (cmd == null) {
      /*
       * if `cmd` param is missing, then whole payload is command, and data is empty
       */
      cmd = new HashMap<>(payload);
    } else {
      data = payload.get("data");
    }
    this.command = buildCommand(builder -> {
      cmd.forEach((name, ));
    });
    this.data = data;
  }
}
