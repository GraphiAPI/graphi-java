package graphi.api;

import graphi.schema.GraphiConstraintMap;
import graphi.schema.GraphiType;

public interface Command {

  String getName();

  GraphiConstraintMap getParams();

  GraphiType getReturnType();

  class Builder {

    private Command command;

    private Builder() {
      command =
    }

    public static Builder newBuilder() {
      Builder builder = new Builder();

      return builder;
    }

    public Builder name(String name) {

    }

  }

}
