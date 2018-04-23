package graphi.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.GraphiSchema;
import graphi.schema.GraphiField;
import graphi.schema.GraphiObjectType;

import java.io.IOException;
import java.util.Map;

@SuppressWarnings("unchecked")
public class GraphiParser {

  private GraphiParser() {

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
