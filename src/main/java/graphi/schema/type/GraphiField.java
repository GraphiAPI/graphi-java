package graphi.schema.type;

import graphi.schema.GraphiConstraintMap;

import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiField {

  private final String name;
  private final GraphiConstraintMap constraintMap;

  public GraphiField(String name, Map<String, Object> constraintMap) {
    this.name = name;
    this.constraintMap = new GraphiConstraintMap();
    this.constraintMap.putAll(constraintMap);
  }

  public GraphiField(String name) {
    this(name, new GraphiConstraintMap());
  }

  public String getName() {
    return name;
  }

  public void addConstraint(String name, Object value) {
    constraintMap.put(name, value);
  }

  public <V> V getConstraintValue(String name) {
    return (V)constraintMap.get(name);
  }

}
