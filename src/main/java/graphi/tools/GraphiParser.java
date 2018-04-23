package graphi.tools;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.GraphiSchema;
import graphi.schema.Field;
import graphi.schema.Type;

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
      Type type = new Type(typeName);
      typeDef.forEach((String fieldName, Object fieldDef) -> {
        if(fieldDef instanceof Map) {
          type.addField(new Field(fieldName, (Map<String, Object>)fieldDef));
        }
      });
      graphiSchema.addType(typeName, type);
    });
    return graphiSchema;
  }

}
