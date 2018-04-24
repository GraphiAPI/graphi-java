package graphi.schema;

public interface GraphiTypeInterface<T> {

  String getName();

  String serialize();

  T deserialize(String json);

}
