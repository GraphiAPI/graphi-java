package graphi.schema;

public interface GraphiType<T> {

  String getName();

  String serialize();

  T deserialize(String json);

}
