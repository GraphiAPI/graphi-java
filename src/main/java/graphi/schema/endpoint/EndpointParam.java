package graphi.schema.endpoint;

import graphi.annotation.GraphiType;

import java.util.Collections;
import java.util.Map;

public class EndpointParam {

  private final String name;
  private final GraphiType type;
  private final ParamConstraintMap paramConstraintMap;

  public EndpointParam(String name, GraphiType type) {
    this.name = name;
    this.type = type;
    this.paramConstraintMap = new ParamConstraintMap(type);
  }

  public String getName() {
    return name;
  }

  public GraphiType getType() {
    return type;
  }

  public Map<String, Object> getParamConstraintMap() {
    return Collections.unmodifiableMap(paramConstraintMap);
  }

  public void addConstraint(String name, Object value) {
    paramConstraintMap.addConstraint(name, value);
  }
}
