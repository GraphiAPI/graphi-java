package graphi;

import graphi.query.Query;

import java.util.HashMap;
import java.util.Map;

public class Graphi {

  private static Graphi INSTANCE;

  private final GraphiSchema schema;

  private Graphi(GraphiSchema graphiSchema) {
    schema = graphiSchema;
  }

  public GraphiSchema getSchema() {
    return schema;
  }

  public GraphiResponse execute(GraphiRequest request) {
    return GraphiResponse.empty();
  }

  public static String resolveGraphiType(Class jType) {
    return JAVA_GRAPHI_TYPES_MAP.get(jType);
  }

  public static Query resolveQuery(String rawQuery) {
    if (QUERY_CACHE.containsKey(rawQuery)) return QUERY_CACHE.get(rawQuery);
    return
  }

  public static Graphi init(GraphiSchema graphiSchema) {
    if (INSTANCE == null) {
      INSTANCE = new Graphi(graphiSchema);
    }
    return INSTANCE;
  }

  public static Graphi graphi() {
    if (INSTANCE == null)
      throw new IllegalStateException("Graphi is not initialized yet.");
    return INSTANCE;
  }

  private static final Map<String, Query> QUERY_CACHE = new HashMap<>();

  private static final Map<Class, String> JAVA_GRAPHI_TYPES_MAP = new HashMap<Class, String>() {{
    put(Integer.class, "number");
    put(Float.class, "number");
    put(Long.class, "number");
    put(Double.class, "number");
    put(String.class, "string");
  }};

}
