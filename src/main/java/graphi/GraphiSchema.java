package graphi;

import graphi.schema.type.GraphiField;
import graphi.schema.type.GraphiObjectType;

import java.util.LinkedHashMap;
import java.util.Map;

public class GraphiSchema {

  private final Map<String, GraphiObjectType> typesMap;

  public GraphiSchema() {
    typesMap = new LinkedHashMap<>();
  }

  public void addType(String name, GraphiObjectType graphiObjectType) {
    if (typesMap.containsKey(name)) {
      throw new IllegalStateException(String.format("GraphiObjectType %s already defined.", name));
    }
    typesMap.put(name, graphiObjectType);
  }

  public static GraphiSchema use(Class... graphiTypeClasses) {
    for (Class typeClass : graphiTypeClasses) {
      graphi.annotation.GraphiType graphiTypeAnnot = (graphi.annotation.GraphiType)typeClass.getAnnotation(graphi.annotation.GraphiType.class);
      String typeName = graphiTypeAnnot.name().isEmpty() ? typeClass.getSimpleName() : graphiTypeAnnot.name();
      GraphiObjectType graphiObjectType = new GraphiObjectType(typeName);
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
