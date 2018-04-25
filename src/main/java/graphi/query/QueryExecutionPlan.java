package graphi.query;

import java.util.LinkedList;
import java.util.List;

public class QueryExecutionPlan {

  private final List<QueryExecutionTask> taskList;

  public QueryExecutionPlan() {
    taskList = new LinkedList<>();
  }
}
