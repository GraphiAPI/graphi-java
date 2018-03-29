package graphi.execution;

public interface CommandExecutor {

  /* eg. query/mutate/subscribe */
  String getCommandName();

  ExecutorStrategy getExecutionStrategy();

}
