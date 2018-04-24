package graphi.schema;

import graphi.Graphi;
import graphi.annotation.GraphiEndpoint;
import graphi.annotation.GraphiParam;
import graphi.schema.field.GParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class GraphiJEndpoint {

  private String name;
  private List<GParam> GParams;
  private Object resolverObject;
  private Method resolverMethod;

  public GraphiJEndpoint(Method method) {
    this.GParams = new ArrayList<>();

    setName(method.getName());
    GraphiEndpoint endpointAt = method.getAnnotation(GraphiEndpoint.class);
    setName(endpointAt.name().isEmpty() ? method.getName() : endpointAt.name());
    for (Parameter jParam : method.getParameters()) {
      String paramName = jParam.getName();
      String paramType = Graphi.resolveGraphiType(jParam.getType());
      GraphiParam paramAt = jParam.getAnnotation(GraphiParam.class);
      if (paramAt != null && !paramAt.name().isEmpty()) {
        paramName = paramAt.name();
      }
      GParam GParam = new GParam(paramName, paramType);
      addParam(new GParam(GParam.getName(), ));
    }
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
