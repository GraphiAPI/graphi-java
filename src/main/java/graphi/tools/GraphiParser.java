package graphi.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.GraphiSchema;
import graphi.Query;
import graphi.schema.field.GField;
import graphi.schema.type.GraphiObjectType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiParser {

  private static final Map<String, Query> COMMAND_GRAPH_CACHE = new HashMap<>();

  private GraphiParser() {

  }

  public static Query parseCommandGraph(String json) throws IOException {
    if (COMMAND_GRAPH_CACHE.containsKey(json))
      return COMMAND_GRAPH_CACHE.get(json);

    Query query = new Query();
    Map commandGraphMap = new ObjectMapper().readValue(json, Map.class);

  }

  public static GraphiSchema parseSchema(String json) throws IOException {
    Map<String, Map<String, Object>> schema = new ObjectMapper().readValue(json, Map.class);
    GraphiSchema graphiSchema = new GraphiSchema();
    schema.forEach((String typeName, Map<String, Object> typeDef) -> {
      GraphiObjectType GraphiObjectType = new GraphiObjectType(typeName);
      typeDef.forEach((String fieldName, Object fieldDef) -> {
        if(fieldDef instanceof Map) {
          GraphiObjectType.addField(new GField(fieldName, (Map<String, Object>)fieldDef));
        }
      });
      graphiSchema.addType(typeName, GraphiObjectType);
    });
    return graphiSchema;
  }

}
