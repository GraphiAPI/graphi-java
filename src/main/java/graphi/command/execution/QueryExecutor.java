package graphi.command.execution;

public class QueryExecutor implements CommandExecutor {

  public static final String COMMAND_NAME = "query";

  @Override
  public String getCommandName() {
    return COMMAND_NAME;
  }

  @Override
  public ExecutorStrategy getExecutionStrategy() {
    return null;
  }
}
