package graphi;

public class Graphi {

  private static Graphi INSTANCE;

  private final GraphiSchema graphiSchema;
  private final GraphiEndpointMap graphiEndpointMap;

  private Graphi(GraphiSchema graphiSchema, GraphiEndpointMap graphiEndpointMap) {
    this.graphiSchema = graphiSchema;
    this.graphiEndpointMap = graphiEndpointMap;
  }

  public GraphiResponse execute(GraphiRequest request) {
    return GraphiResponse.empty();
  }

  public static Graphi init(GraphiSchema graphiSchema, GraphiEndpointMap graphiEndpointMap) {
    if (INSTANCE == null) {
      INSTANCE = new Graphi(graphiSchema, graphiEndpointMap);
    }
    return INSTANCE;
  }

  public static Graphi graphi() {
    if (INSTANCE == null) throw new IllegalStateException("Graphi is not initialized yet.");
    return INSTANCE;
  }

}
