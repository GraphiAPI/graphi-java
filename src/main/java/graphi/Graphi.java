package graphi;

import java.util.HashMap;
import java.util.Map;

public class Graphi {

  private static GraphiSchema GRAPHI_SCHEMA;
  private static Graphi INSTANCE;

  private Graphi(GraphiSchema graphiSchema) {
    GRAPHI_SCHEMA = graphiSchema;
  }

  public GraphiResponse execute(GraphiRequest request) {
    return GraphiResponse.empty();
  }

  public static String resolveGraphiType(Class jType) {
    return JAVA_GRAPHI_TYPES_MAP.get(jType);
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

  private static final Map<Class, String> JAVA_GRAPHI_TYPES_MAP = new HashMap<Class, String>() {{
    put(Integer.class, "number");
    put(Float.class, "number");
    put(Long.class, "number");
    put(Double.class, "number");
    put(String.class, "string");
  }};

}
