package graphi;

import graphi.schema.type.GraphiValueType;

public class GraphiValueTypes {

  private GraphiValueTypes() {}

  public static class GraphiValueBoolean extends GraphiValueType<GraphiValueBoolean> {

    @Override
    public String getName() {
      return "boolean";
    }

    @Override
    public String serialize() {
      return null;
    }

    @Override
    public GraphiValueBoolean deserialize(String json) {
      return null;
    }
  }

  public static class GraphiValueNumber extends GraphiValueType<GraphiValueNumber> {

    @Override
    public String getName() {
      return "number";
    }

    @Override
    public String serialize() {
      return null;
    }

    @Override
    public GraphiValueNumber deserialize(String json) {
      return null;
    }
  }

  public static class GraphiValueString extends GraphiValueType<GraphiValueString> {

    @Override
    public String getName() {
      return "string";
    }

    @Override
    public String serialize() {
      return null;
    }

    @Override
    public GraphiValueString deserialize(String json) {
      return null;
    }
  }

}
