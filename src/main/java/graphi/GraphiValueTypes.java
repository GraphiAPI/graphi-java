package graphi;

import graphi.schema.type.ValueType;

public class GraphiValueTypes {

  private GraphiValueTypes() {}

  public static class GBoolean extends ValueType<GBoolean> {

    @Override
    public String getName() {
      return "boolean";
    }

    @Override
    public String serialize() {
      return null;
    }

    @Override
    public GBoolean deserialize(String json) {
      return null;
    }
  }

  public static class GNumber extends ValueType<GNumber> {

    @Override
    public String getName() {
      return "number";
    }

    @Override
    public String serialize() {
      return null;
    }

    @Override
    public GNumber deserialize(String json) {
      return null;
    }
  }

  public static class GString extends ValueType<GString> {

    @Override
    public String getName() {
      return "string";
    }

    @Override
    public String serialize() {
      return null;
    }

    @Override
    public GString deserialize(String json) {
      return null;
    }
  }

}
