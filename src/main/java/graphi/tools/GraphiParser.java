package graphi.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.GraphiQuery;
import graphi.GraphiSchema;
import graphi.schema.type.GraphiField;
import graphi.schema.type.GraphiObjectType;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiParser {

  private static final Map<String, GraphiQuery> COMMAND_GRAPH_CACHE = new HashMap<>();

  private GraphiParser() {

  }

  public static GraphiQuery parseCommandGraph(String json) throws IOException {
    if (COMMAND_GRAPH_CACHE.containsKey(json))
      return COMMAND_GRAPH_CACHE.get(json);

    GraphiQuery graphiQuery = new GraphiQuery();
    Map commandGraphMap = new ObjectMapper().readValue(json, Map.class);

  }

  public static GraphiSchema parseSchema(String json) throws IOException {
    Map<String, Map<String, Object>> schema = new ObjectMapper().readValue(json, Map.class);
    GraphiSchema graphiSchema = new GraphiSchema();
    schema.forEach((String typeName, Map<String, Object> typeDef) -> {
      GraphiObjectType graphiObjectType = new GraphiObjectType(typeName);
      typeDef.forEach((String fieldName, Object fieldDef) -> {
        if(fieldDef instanceof Map) {
          graphiObjectType.addField(new GraphiField(fieldName, (Map<String, Object>)fieldDef));
        }
      });
      graphiSchema.addType(typeName, graphiObjectType);
    });
    return graphiSchema;
  }

}
