package graphi.schema.endpoint;

import graphi.annotation.GraphiType;
import graphi.schema.GraphiConstraintMap;

public class ParamConstraintMap extends GraphiConstraintMap {

  public ParamConstraintMap(GraphiType type) {
    super(type);
    put(GraphiConstraintMap.NULLABLE, false);
  }

}
