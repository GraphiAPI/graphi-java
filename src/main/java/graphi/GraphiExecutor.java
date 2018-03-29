package graphi;

import graphi.schema.Command;

public interface GraphiExecutor<T> {

  T execute(Command cmd);

}
