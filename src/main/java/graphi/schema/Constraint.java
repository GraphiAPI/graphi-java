package graphi.schema;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public abstract class Constraint extends HashMap<String, Object> {

  public static final String
    TYPE = "type",
    NULLABLE = "nullable",
    ARRAY = "array";

  public Constraint(String type) {
    super();
    put(TYPE, type);
    put(NULLABLE, true);
    put(ARRAY, false);
  }

  public Type getType() {
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
