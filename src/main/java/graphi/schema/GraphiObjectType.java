package graphi.schema;

import java.util.HashSet;
import java.util.Set;

public class GraphiObjectType {

  private final String name;
  private final Set<GraphiField> graphiFields;
  private Class javaType;

  public GraphiObjectType(String name) {
    this.name = name;
    this.graphiFields = new HashSet<>();
  }

  public void addField(GraphiField graphiField) {
    graphiFields.add(graphiField);
  }

  public String getName() {
    return name;
  }

  public Set<GraphiField> getGraphiFields() {
    return graphiFields;
  }

  public Class getJavaType() {
    return javaType;
  }

  public void setJavaType(Class javaType) {
    this.javaType = javaType;
  }
}
