package graphi;

import graphi.schema.type.GraphiObjectType;
import graphi.schema.type.GraphiValueType;

import java.util.HashMap;
import java.util.Map;

public class GraphiFactory {

  private static final Map<Class, GraphiValueType> GRAPHI_VALUE_TYPE_BY_JAVA_TYPE = new HashMap<>();
  private static final Map<Class, GraphiObjectType> GRAPHI_OBJECT_TYPE_BY_JAVA_TYPE = new HashMap<>();

  public static void registerGraphiValueType(Class jType) {
    GRAPHI_VALUE_TYPE_BY_JAVA_TYPE.put(jType, new GraphiValueType(jType));
  }

  public static GraphiValueType getGraphiValueTypeByJavaType(Class jType) {
    return GRAPHI_VALUE_TYPE_BY_JAVA_TYPE.get(jType);
  }

  public static void registerGraphiObjectType(Class jType) {
    GRAPHI_OBJECT_TYPE_BY_JAVA_TYPE.put(jType, new GraphiObjectType(jType));
  }

  public static GraphiObjectType getGraphiObjectTypeByJavaType(Class jType) {
    return GRAPHI_OBJECT_TYPE_BY_JAVA_TYPE.get(jType);
  }
}
