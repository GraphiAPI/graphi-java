package graphi;

import graphi.command.execution.CommandExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
public class GraphiQuery {

  private String name;
  private GraphiEndpointMap graphiEndpointMap;
  private Map<String, String> argumentsMap;
  private Map<String, GraphiQuery> children;
  private CommandExecutor executor;
  private Boolean executeAsync = true;
  private Boolean isNamedCommand = false;

  public GraphiQuery() {
    argumentsMap = new HashMap<>();
    children = new HashMap<>();
  }

  public GraphiQuery(Map<String, Object> commandGraphMap) {
    commandGraphMap.forEach((name, obj) -> {
      String[] namePlusCommandName = name.split(":");
      if (namePlusCommandName.length > 1) {
        this.name = namePlusCommandName[0];
        //this.command = findCommand()
      }
    });
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GraphiEndpointMap getGraphiEndpointMap() {
    return graphiEndpointMap;
  }

  public void setGraphiEndpointMap(GraphiEndpointMap graphiEndpointMap) {
    this.graphiEndpointMap = graphiEndpointMap;
  }

  public Map<String, String> getArgumentsMap() {
    return argumentsMap;
  }

  public void setArgumentsMap(Map<String, String> argumentsMap) {
    this.argumentsMap = argumentsMap;
  }

  public Map<String, GraphiQuery> getChildren() {
    return children;
  }

  public void setChildren(Map<String, GraphiQuery> children) {
    this.children = children;
  }

  public CommandExecutor getExecutor() {
    return executor;
  }

  public void setExecutor(CommandExecutor executor) {
    this.executor = executor;
  }

  public Boolean getExecuteAsync() {
    return executeAsync;
  }

  public void setExecuteAsync(Boolean executeAsync) {
    this.executeAsync = executeAsync;
  }

  public Boolean getNamedCommand() {
    return isNamedCommand;
  }

  public void setNamedCommand(Boolean namedCommand) {
    isNamedCommand = namedCommand;
  }
}
