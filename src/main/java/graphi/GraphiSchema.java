package graphi;

import graphi.annotation.GraphiEndpoint;
import graphi.annotation.GraphiType;
import graphi.schema.GraphiJEndpoint;
import graphi.schema.type.GraphiObjectType;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class GraphiSchema {

  private static final Map<String, GraphiObjectType> typesMap = new HashMap<>();
  private static final Map<String, GraphiJEndpoint> endpointsMap = new HashMap<>();

  public void addType(String name, GraphiObjectType GraphiObjectType) {
    if (typesMap.containsKey(name)) {
      throw new IllegalStateException(String.format("GraphiObjectType %s already defined.", name));
    }
    typesMap.put(name, GraphiObjectType);
  }

  public static void registerObjectTypes(Class... graphiTypeClasses) {
    for (Class typeClass : graphiTypeClasses) {
      if (typeClass.isAnnotationPresent(GraphiType.class)) {
        GraphiObjectType graphiObjectType = new GraphiObjectType(typeClass);
        typesMap.put(graphiObjectType.getName(), graphiObjectType);
      }
    }
  }

  public static void registerEndpoints(Object... endpointResolvers) {
    for (Object endpointResolver : endpointResolvers) {
      for (Method method : endpointResolver.getClass().getMethods()) {
        if (method.isAnnotationPresent(GraphiEndpoint.class)) {
          GraphiJEndpoint endpoint = new GraphiJEndpoint(method);
          endpointsMap.put(endpoint.getName(), endpoint);
        }
      }
    }
  }

 /*
  todo
  public static GraphiSchema merge(GraphiSchema... graphiSchemas) {
    GraphiSchema merged = new GraphiSchema();
    for (GraphiSchema graphiSchema : graphiSchemas) {
      merged.typesMap.putAll(graphiSchema.typesMap);
    }
  }*/

}
