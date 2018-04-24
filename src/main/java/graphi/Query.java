package graphi;

import graphi.query.executor.CommandExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * Combination of GraphiEndpoints in a graph manner
 */
public class Query {

  private String name;
  private Map<String, String> argumentsMap;
  private Map<String, Query> children;
  private CommandExecutor executor;
  private Boolean executeAsync = true;
  private Boolean isNamedCommand = false;

  public Query() {
    argumentsMap = new HashMap<>();
    children = new HashMap<>();
  }

  public Query(Map<String, Object> queryMap) {
    queryMap.forEach((name, obj) -> {
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

  public Map<String, String> getArgumentsMap() {
    return argumentsMap;
  }

  public void setArgumentsMap(Map<String, String> argumentsMap) {
    this.argumentsMap = argumentsMap;
  }

  public Map<String, Query> getChildren() {
    return children;
  }

  public void setChildren(Map<String, Query> children) {
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
