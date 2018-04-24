package graphi.schema;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public abstract class GraphiConstraint extends HashMap<String, Object> {

  public static final String nonNullMsg = "`%` cannot be null or empty";
  public static final String
    NAME = "name",
    TYPE = "type",
    DEFAULT_VALUE = "defaultValue",
    NULLABLE = "nullable",
    ARRAY = "array";

  public GraphiConstraint(String name, String type) {
    super();

    if (name == null || name.isEmpty())
      throw new IllegalArgumentException(String.format(nonNullMsg, "name"));
    if (type == null || type.isEmpty())
      throw new IllegalArgumentException(String.format(nonNullMsg, "type"));

    put(NAME, name);
    put(TYPE, type);
    put(NULLABLE, true);
    put(ARRAY, false);
  }

  public String getName() {
    return get(NAME);
  }

  public String getType() {
    return get(TYPE);
  }

  public <T> T getDefaultValue() {
    return get(DEFAULT_VALUE);
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
