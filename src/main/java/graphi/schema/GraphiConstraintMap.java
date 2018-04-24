package graphi.schema;

import graphi.annotation.GraphiType;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public abstract class GraphiConstraintMap extends HashMap<String, Object> {

  public static final String
    TYPE = "type",
    NULLABLE = "nullable",
    ARRAY = "array";

  public GraphiConstraintMap(GraphiType type) {
    super();
    put(TYPE, type);
    put(NULLABLE, true);
    put(ARRAY, false);
  }

  public GraphiType getType() {
    return get(TYPE);
  }

  public boolean isNullable() {
    return get(NULLABLE);
  }

  public boolean isArray() {
    return get(ARRAY);
  }

  public <T> T get(String name) {
    return (T)super.get(name);
  }

  public void addConstraint(String name, Object value) {
    put(name, value);
  }

}
