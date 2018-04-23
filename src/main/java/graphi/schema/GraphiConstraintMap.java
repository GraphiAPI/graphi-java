package graphi.schema;

import java.util.HashMap;

@SuppressWarnings("unchecked")
public class GraphiConstraintMap extends HashMap<String, Object> {

  public <T> T get(String name) {
    return (T)super.get(name);
  }

  public void addConstraint(String name, Object value) {
    put(name, value);
  }

}
