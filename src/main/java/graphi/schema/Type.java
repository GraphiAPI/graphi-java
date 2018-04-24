package graphi.schema;

public interface Type<T> {

  String getName();

  String serialize();

  T deserialize(String json);

}
