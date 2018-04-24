package graphi.schema.type;

import graphi.schema.Type;

import java.util.Map;

import static graphi.schema.Constraint.*;

@SuppressWarnings("unchecked")
public class GraphiField {

  private final String name;
  private final FieldConstraint constraintMap;

  public GraphiField(String name, Map<String, Object> constraintMap) {
    this.name = name;
    this.constraintMap = new FieldConstraint((Type)constraintMap.get(TYPE));
    this.constraintMap.putAll(constraintMap);
  }

  public String getName() {
    return name;
  }

  public void addConstraint(String name, Object value) {
    constraintMap.addConstraint(name, value);
  }

  public <V> V getConstraintValue(String name) {
    return (V)constraintMap.get(name);
  }

}
