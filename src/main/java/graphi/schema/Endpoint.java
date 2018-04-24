package graphi.schema;

import graphi.schema.endpoint.Param;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Endpoint {

  private String name;
  private List<Param> params;
  private Type returnType;
  private Object resolverObject;
  private Method resolverMethod;

  public Endpoint() {
    this.params = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Param> getParams() {
    return params;
  }

  public void addParam(Param param) {
    this.params.add(param);
  }

  public Type getReturnType() {
    return returnType;
  }

  public void setReturnType(Type returnType) {
    this.returnType = returnType;
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
