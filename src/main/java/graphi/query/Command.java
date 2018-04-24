package graphi.query;

import graphi.query.executor.CommandExecutor;
import graphi.schema.Constraint;
import graphi.schema.Type;

import java.util.List;

public interface Command {

  String getName();

  Constraint getParams();

  Type getReturnType();

  List<CommandExecutor> getExecutorList();

  default CommandExecutor getDefalutExecutor() {
    return getExecutorList().get(0);
  }

}
