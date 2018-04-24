package graphi;

import graphi.schema.type.GraphiValueType;

public class GraphiValueTypes {

  private GraphiValueTypes() {}

  public static class GBoolean extends GraphiValueType<GBoolean> {

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

  public static class GNumber extends GraphiValueType<GNumber> {

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

  public static class GString extends GraphiValueType<GString> {

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
