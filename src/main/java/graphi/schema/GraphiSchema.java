package graphi.schema;

import java.util.HashMap;
import java.util.Map;

public class GraphiSchema {

  private final Map<String, Model> modelMap;
  private String version;

  public GraphiSchema() {
    modelMap = new HashMap<>();
  }
}
