package graphi.schema.type;

import graphi.schema.field.GField;

import java.util.HashSet;
import java.util.Set;

public class GraphiObjectType {

  private final String name;
  private final Set<GField> gFields;
  private Class javaType;

  public GraphiObjectType(String name) {
    this.name = name;
    this.gFields = new HashSet<>();
  }

  public GraphiObjectType(Class javaType) {
    this(javaType.getSimpleName());
    this.javaType = javaType;
  }

  public void addField(GField gField) {
    gFields.add(gField);
  }

  public String getName() {
    return name;
  }

  public Set<GField> getgFields() {
    return gFields;
  }

  public Class getJavaType() {
    return javaType;
  }

  public void setJavaType(Class javaType) {
    this.javaType = javaType;
  }
}
