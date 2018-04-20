package graphi;

public class Graphi {

  private static final Graphi INSTANCE = new Graphi();

  private final GraphiSchema graphiSchema;
  private final GraphiApi graphiApi;

  private Graphi() {
    this.graphiSchema = new GraphiSchema();
    this.graphiApi = new GraphiApi();
  }



  public static Graphi graphi() {
    return INSTANCE;
  }

}
