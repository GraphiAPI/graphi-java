package graphi;

import graphi.schema.Model;

import java.util.LinkedHashMap;
import java.util.Map;

public class GraphiSchema {

  private final Map<String, Model> modelMap;

  public GraphiSchema() {
    modelMap = new LinkedHashMap<>();
  }
}
