package graphi.command;

import graphi.command.execution.CommandExecutor;
import graphi.schema.GraphiConstraintMap;
import graphi.schema.GraphiType;

import java.util.List;

public interface Command {

  String getName();

  GraphiConstraintMap getParams();

  GraphiType getReturnType();

  List<CommandExecutor> getExecutorList();

  default CommandExecutor getDefalutExecutor() {
    return getExecutorList().get(0);
  }

}
