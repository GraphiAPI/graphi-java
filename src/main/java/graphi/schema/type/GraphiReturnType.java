package graphi.schema.type;

import graphi.GraphiFactory;

import java.lang.reflect.Method;

public class GraphiReturnType {

  private GraphiObjectType graphiObjectType;
  private GraphiValueType graphiValueType;

  public GraphiReturnType(Method method) {
    if (method.getReturnType().isAssignableFrom(GraphiObjectType.class)) {
      graphiObjectType = GraphiFactory.getGraphiObjectTypeByJavaType(method.getReturnType().getClass());
    } else if (method.getReturnType().isAssignableFrom(GraphiValueType.class)) {
      graphiValueType = GraphiFactory.getGraphiValueTypeByJavaType(method.getReturnType().getClass());
    }
  }

}
