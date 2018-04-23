package graphi.schema;

import java.util.HashSet;
import java.util.Set;

public class Type {

  private final String name;
  private final Set<Field> fields;

  public Type(String name) {
    this.name = name;
    this.fields = new HashSet<>();
  }

  public void addField(Field field) {
    fields.add(field);
  }

  public String getName() {
    return name;
  }

  public Set<Field> getFields() {
    return fields;
  }
}
