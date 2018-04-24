package graphi.schema.endpoint;

import java.util.Collections;
import java.util.Map;

public class Param {

  private final String name;
  private final String type;
  private final Object value;
  private final ParamConstraint paramConstraintMap;

  public Param(String name, String type) {
    super();
    this.name = name;
    this.type = type;
    this.paramConstraintMap = new ParamConstraint(type);
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public Map<String, Object> getParamConstraintMap() {
    return Collections.unmodifiableMap(paramConstraintMap);
  }

  public void addConstraint(String name, Object value) {
    paramConstraintMap.addConstraint(name, value);
  }
}
