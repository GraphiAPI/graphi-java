package graphi.schema.type;

import java.util.HashSet;
import java.util.Set;

public class ObjectType {

  private final String name;
  private final Set<GraphiField> graphiFields;
  private Class javaType;

  public ObjectType(String name) {
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
