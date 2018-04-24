package graphi.schema.type;

import graphi.schema.GraphiTypeInterface;

public class GraphiValueType<T> implements GraphiTypeInterface<T> {

  public GraphiValueType(Class javaType) {

  }

  @Override
  public String getName() {
    return null;
  }

  @Override
  public String serialize() {
    return null;
  }

  @Override
  public T deserialize(String json) {
    return null;
  }
}
