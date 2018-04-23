package graphi;

import graphi.schema.GraphiScalarType;

public class GraphiScalarTypes {

  private GraphiScalarTypes() {}

  public static class GBoolean extends GraphiScalarType<GBoolean> {

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

  public static class GNumber extends GraphiScalarType<GNumber> {

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

  public static class GString extends GraphiScalarType<GString> {

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
