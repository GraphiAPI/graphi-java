package graphi;

import graphi.query.Query;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Graphi {

  private final String label;
  private final GraphiSchema schema;

  private Graphi(String label, GraphiSchema graphiSchema) {
    this.label = label;
    this.schema = graphiSchema;
    LABEL_INSTANCE_MAP.put(label, this);
  }

  public GraphiSchema getSchema() {
    return schema;
  }

  public GraphiSchema addSchema(GraphiSchema graphiSchema) {
    return schema.merge(graphiSchema);
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

  public static Graphi graphi() {
    return graphi(ROOT_LABEL);
  }

  public static Graphi graphi(String label) {
    return LABEL_INSTANCE_MAP.get(label);
  }

  private static final Map<String, Graphi> LABEL_INSTANCE_MAP = new HashMap<>();

  private static final String ROOT_LABEL = UUID.randomUUID().toString();

  private static final Map<String, Query> QUERY_CACHE = new HashMap<>();

  private static final Map<Class, String> JAVA_GRAPHI_TYPES_MAP = new HashMap<Class, String>() {{
    put(Integer.class, "number");
    put(Float.class, "number");
    put(Long.class, "number");
    put(Double.class, "number");
    put(String.class, "string");
  }};

  static {
    new Graphi(ROOT_LABEL, GraphiSchema.emptySchema());
  }

}
