package graphi;

import graphi.schema.type.GraphiField;
import graphi.schema.type.ObjectType;

import java.util.LinkedHashMap;
import java.util.Map;

public class GraphiSchema {

  private final Map<String, ObjectType> typesMap;
  private final EndpointsMap endpointsMap;

  public GraphiSchema() {
    typesMap = new LinkedHashMap<>();
    this.endpointsMap = new EndpointsMap();
  }

  public void addType(String name, ObjectType objectType) {
    if (typesMap.containsKey(name)) {
      throw new IllegalStateException(String.format("ObjectType %s already defined.", name));
    }
    typesMap.put(name, objectType);
  }

  public static GraphiSchema scan(Class... graphiTypeClasses) {
    for (Class typeClass : graphiTypeClasses) {
      graphi.annotation.GraphiType graphiTypeAnnot = (graphi.annotation.GraphiType)typeClass.getAnnotation(graphi.annotation.GraphiType.class);
      String typeName = graphiTypeAnnot.name().isEmpty() ? typeClass.getSimpleName() : graphiTypeAnnot.name();
      ObjectType objectType = new ObjectType(typeName);
      for (java.lang.reflect.Field jField : typeClass.getFields()) {
        GraphiField graphiField = new GraphiField(jField.getName());
      }

    }
  }

  public static GraphiSchema merge(GraphiSchema... graphiSchemas) {
    GraphiSchema merged = new GraphiSchema();
    for (GraphiSchema graphiSchema : graphiSchemas) {
      merged.typesMap.putAll(graphiSchema.typesMap);
    }
  }

}
