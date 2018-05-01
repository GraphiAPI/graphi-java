package graphi.schema;

import graphi.query.QueryArguments;
import graphi.schema.field.GParam;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class GraphiEndpoint {

  private String name;
  private List<GParam> GParams;
  private Object resolverObject;
  private Method resolverMethod;

  public GraphiEndpoint(Method method) {
    this.GParams = new ArrayList<>();

    setName(method.getName());
    GraphiEndpoint endpointAt = method.getAnnotation(GraphiEndpoint.class);
    if (endpointAt != null) {
      if (!endpointAt.name().isEmpty()) {
        setName(endpointAt.name());
      }
    }
    for (Parameter jParam : method.getParameters()) {
      addParam(new GParam(jParam));
    }
  }

  public <T> T invoke(QueryArguments args) throws InvocationTargetException, IllegalAccessException {
    Object[] args = new Object[resolverMethod.getParameterCount()];
    return (T)resolverMethod.invoke(resolverObject, args);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<GParam> getGParams() {
    return GParams;
  }

  public void addParam(GParam GParam) {
    this.GParams.add(GParam);
  }

  public Object getResolverObject() {
    return resolverObject;
  }

  public void setResolverObject(Object resolverObject) {
    this.resolverObject = resolverObject;
  }

  public Method getResolverMethod() {
    return resolverMethod;
  }

  public void setResolverMethod(Method resolverMethod) {
    this.resolverMethod = resolverMethod;
  }
}
