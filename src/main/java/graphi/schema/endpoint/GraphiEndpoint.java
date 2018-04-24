package graphi.schema.endpoint;

import graphi.schema.type.GraphiType;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GraphiEndpoint {

  private String name;
  private List<EndpointParam> endpointParams = new ArrayList<>();
  private GraphiType returnType;
  private Object resolverObject;
  private Method resolverMethod;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<EndpointParam> getEndpointParams() {
    return endpointParams;
  }

  public void setEndpointParams(List<EndpointParam> endpointParams) {
    this.endpointParams = endpointParams;
  }

  public GraphiType getReturnType() {
    return returnType;
  }

  public void setReturnType(GraphiType returnType) {
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
