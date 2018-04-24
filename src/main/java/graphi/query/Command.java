package graphi.query;

import graphi.query.executor.CommandExecutor;
import graphi.schema.GraphiConstraint;
import graphi.schema.GraphiTypeInterface;

import java.util.List;

public interface Command {

  String getName();

  GraphiConstraint getParams();

  GraphiTypeInterface getReturnType();

  List<CommandExecutor> getExecutorList();

  default CommandExecutor getDefalutExecutor() {
    return getExecutorList().get(0);
  }

}
