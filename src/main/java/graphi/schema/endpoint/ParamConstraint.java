package graphi.schema.endpoint;

import graphi.schema.Constraint;

public class ParamConstraint extends Constraint {

  public ParamConstraint(String type) {
    super(type);
    put(Constraint.NULLABLE, false);
  }

}
