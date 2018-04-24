package graphi.schema.type;

public interface GraphiType<T> {

  String getName();

  String serialize();

  T deserialize(String json);

}
