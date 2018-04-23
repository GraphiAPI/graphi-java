package graphi;

public class Graphi {

  private static Graphi INSTANCE;

  private final GraphiSchema graphiSchema;
  private final GraphiApi graphiApi;

  private Graphi(GraphiSchema graphiSchema, GraphiApi graphiApi) {
    this.graphiSchema = graphiSchema;
    this.graphiApi = graphiApi;
  }

  public GraphiResponse execute(GraphiRequest request) {
    return GraphiResponse.empty();
  }

  public static Graphi init(GraphiSchema graphiSchema, GraphiApi graphiApi) {
    if (INSTANCE == null) {
      INSTANCE = new Graphi(graphiSchema, graphiApi);
    }
    return INSTANCE;
  }

  public static Graphi graphi() {
    if (INSTANCE == null) throw new IllegalStateException("Graphi is not initialized yet.");
    return INSTANCE;
  }

}
