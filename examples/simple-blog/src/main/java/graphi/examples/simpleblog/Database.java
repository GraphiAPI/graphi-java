package graphi.examples.simpleblog;

import java.util.HashMap;
import java.util.Map;

public class Database {

  private static final Map<String, Map<String, Object>> data = new HashMap<>();

  public static void init(Map<String, Map<String, Object>> initialData) {
    data.putAll(initialData);
  }

}
