package graphi;

import graphi.api.Command;

public interface GraphiExecutor<T> {

  T execute(Command cmd);

}
