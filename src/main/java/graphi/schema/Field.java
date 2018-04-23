package graphi.schema;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Field {

  private final String name;

  private final Map<String, Object> fieldDef;

  public Field(String name, Map<String, Object> fieldDef) {
    this.name = name;
    this.fieldDef = fieldDef;
  }

  public Field(String name) {
    this(name, new LinkedHashMap<>());
  }

  public String getName() {
    return name;
  }

  public void addFieldDef(String defKey, Object value) {
    fieldDef.put(defKey, value);
  }

  public <V> V getFieldDefValue(String defKey) {
    return (V)fieldDef.get(defKey);
  }

}
