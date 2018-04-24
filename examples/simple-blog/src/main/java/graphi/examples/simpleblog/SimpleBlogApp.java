package graphi.examples.simpleblog;

import com.fasterxml.jackson.databind.ObjectMapper;
import graphi.Graphi;
import graphi.GraphiEndpointMap;
import graphi.GraphiRequest;
import graphi.GraphiSchema;
import graphi.examples.simpleblog.entity.Author;
import graphi.examples.simpleblog.entity.Category;
import graphi.examples.simpleblog.entity.Post;
import graphi.examples.simpleblog.entity.Tag;
import graphi.examples.simpleblog.repository.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
@WebServlet(urlPatterns = {"/graphql"}, loadOnStartup = 1)
public class SimpleBlogApp extends HttpServlet {

  private Graphi graphi;

  @Override
  public void init() throws ServletException {
    super.init();
    try {
      Datasource.init(new ObjectMapper().readValue(new File("database.json"), Map.class));
      buildGraphi();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void buildGraphi() {
    graphi = Graphi.init(
      GraphiSchema.use(Post.class, Author.class, Category.class, Tag.class),
      GraphiEndpointMap.use(PostRepository.class));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String rawPayload = req.getReader().lines().collect(Collectors.joining());
    ObjectMapper mapper = new ObjectMapper();
    Map payload = mapper.readValue(rawPayload, Map.class);

    //GraphqlServer graphqlServer = new GraphqlServer(GraphqlBootstrap.init());
    //GraphqlResult result = graphqlServer.execute((String)jsonPayload.get("query"));
    GraphiRequest graphiRequest = new GraphiRequest(payload);
    res.setContentType("application/json");
    res.getOutputStream().write(mapper.writeValueAsBytes(result));
  }
}