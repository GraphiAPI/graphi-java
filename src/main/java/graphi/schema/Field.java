package graphi.schema;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Field {

  private final Map<String, Object> fieldDef;

  public Field(Map<String, Object> fieldDef) {
    this.fieldDef = fieldDef;
  }

  public Field() {
    this(new LinkedHashMap<>());
  }

  public void addFieldDef(String defKey, Object value) {
    fieldDef.put(defKey, value);
  }

  public <V> V getFieldDefValue(String defKey) {
    return (V)fieldDef.get(defKey);
  }


}
