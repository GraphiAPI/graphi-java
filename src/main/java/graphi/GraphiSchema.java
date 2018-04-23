package graphi;

import graphi.schema.Type;

import java.util.LinkedHashMap;
import java.util.Map;

public class GraphiSchema {

  private final Map<String, Type> typesMap;

  public GraphiSchema() {
    typesMap = new LinkedHashMap<>();
  }

  public void addType(String name, Type type) {
    if (typesMap.containsKey(name)) {
      throw new IllegalStateException(String.format("Type %s already defined.", name));
    }
    typesMap.put(name, type);
  }

}
