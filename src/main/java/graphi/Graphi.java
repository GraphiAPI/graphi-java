package graphi;

public class Graphi {

  private static Graphi INSTANCE;

  private final GraphiSchema graphiSchema;
  private final GraphiEndpoint graphiEndpoint;

  private Graphi(GraphiSchema graphiSchema, GraphiEndpoint graphiEndpoint) {
    this.graphiSchema = graphiSchema;
    this.graphiEndpoint = graphiEndpoint;
  }

  public GraphiResponse execute(GraphiRequest request) {
    return GraphiResponse.empty();
  }

  public static Graphi init(GraphiSchema graphiSchema, GraphiEndpoint graphiEndpoint) {
    if (INSTANCE == null) {
      INSTANCE = new Graphi(graphiSchema, graphiEndpoint);
    }
    return INSTANCE;
  }

  public static Graphi graphi() {
    if (INSTANCE == null) throw new IllegalStateException("Graphi is not initialized yet.");
    return INSTANCE;
  }

}
