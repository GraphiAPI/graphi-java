package graphi.query;

import java.util.ArrayList;
import java.util.List;

public class QueryExecutionDependency {

  private boolean resolved = false;
  private List<Query> queriesToBeCompleted = new ArrayList<>();
  private List<Query> dependentQueries = new ArrayList<>();

}
