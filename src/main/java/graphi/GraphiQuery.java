package graphi;

import graphi.query.executor.CommandExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
public class GraphiQuery {

  private String name;
  private EndpointsMap endpointsMap;
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
        //this.query = findCommand()
      }
    });
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EndpointsMap getEndpointsMap() {
    return endpointsMap;
  }

  public void setEndpointsMap(EndpointsMap endpointsMap) {
    this.endpointsMap = endpointsMap;
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
