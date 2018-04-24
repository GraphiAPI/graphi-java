package graphi.schema.field;

import graphi.Graphi;

import java.lang.reflect.Parameter;

public class GParam extends GField {

  public GParam(String name, String type) {
    super(name, type);
    put(NULLABLE, false); /* by default param is not nullable */
  }

  public GParam(Parameter parameter) {
    super(parameter.getName(), Graphi.resolveGraphiType(parameter.getType()));
  }

}
