package graphi;

import graphi.annotation.GraphiEndpoint;
import graphi.annotation.GraphiType;
import graphi.schema.GraphiJEndpoint;
import graphi.schema.type.GraphiObjectType;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphiSchema {

  private final Map<String, GraphiObjectType> typesMap = new HashMap<>();
  private final Map<String, GraphiJEndpoint> endpointsMap = new HashMap<>();

  public GraphiSchema(List<GraphiObjectType> objectTypes, List<GraphiJEndpoint> endpoints) {
    addObjectTypes(objectTypes);
    addEndpoints(endpoints);
  }

  public static GraphiSchema emptySchema() {
    return new GraphiSchema(Collections.emptyList(), Collections.emptyList());
  }

  public GraphiSchema merge(GraphiSchema graphiSchema) {
    updateObjectTypes(graphiSchema.getAllGraphiObjectTypes());
    updateEndpoints(graphiSchema.getAllGraphiEndpoints());
    return this;
  }

  public GraphiSchema addObjectTypes(List<GraphiObjectType> objectTypes) {
    for (GraphiObjectType objectType : objectTypes) {
      if (typesMap.containsKey(objectType.getName()))
        throw new IllegalArgumentException(String.format("%s already defined", objectType.getName()));
      typesMap.put(objectType.getName(), objectType);
    }
    return this;
  }

  public GraphiSchema addEndpoints(List<GraphiJEndpoint> endpoints) {
    for (GraphiJEndpoint endpoint : endpoints) {
      if (typesMap.containsKey(endpoint.getName()))
        throw new IllegalArgumentException(String.format("%s already defined", endpoint.getName()));
      endpointsMap.put(endpoint.getName(), endpoint);
    }
    return this;
  }

  public GraphiSchema updateObjectTypes(List<GraphiObjectType> objectTypes) {
    for (GraphiObjectType objectType : objectTypes) {
      typesMap.put(objectType.getName(), objectType);
    }
    return this;
  }

  public GraphiSchema updateEndpoints(List<GraphiJEndpoint> endpoints) {
    for (GraphiJEndpoint endpoint : endpoints) {
      endpointsMap.put(endpoint.getName(), endpoint);
    }
    return this;
  }

  public GraphiObjectType getGraphiObjectType(String name) {
    return typesMap.get(name);
  }

  public List<GraphiObjectType> getAllGraphiObjectTypes() {
    return (List<GraphiObjectType>)typesMap.values();
  }

  public GraphiJEndpoint getGraphiEndpoint(String name) {
    return endpointsMap.get(name);
  }

  public List<GraphiJEndpoint> getAllGraphiEndpoints() {
    return (List<GraphiJEndpoint>)endpointsMap.values();
  }

  public static List<GraphiObjectType> buildObjectTypes(Class... graphiTypeClasses) {
    List<GraphiObjectType> objectTypes = new LinkedList<>();
    for (Class typeClass : graphiTypeClasses) {
      if (typeClass.isAnnotationPresent(GraphiType.class)) {
        GraphiObjectType graphiObjectType = new GraphiObjectType(typeClass);
        objectTypes.add(graphiObjectType);
      }
    }
    return objectTypes;
  }

  public static List<GraphiJEndpoint> buildEndpoints(Object... endpointResolvers) {
    List<GraphiJEndpoint> endpoints = new LinkedList<>();
    for (Object endpointResolver : endpointResolvers) {
      for (Method method : endpointResolver.getClass().getMethods()) {
        if (method.isAnnotationPresent(GraphiEndpoint.class)) {
          endpoints.add(new GraphiJEndpoint(method));
        }
      }
    }
    return endpoints;
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
