package graphi;


import graphi.annotation.GraphiEndpoint;
import graphi.annotation.GraphiParam;
import graphi.schema.Endpoint;
import graphi.schema.endpoint.Param;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;

public class EndpointsMap extends HashMap<String, Object> {

  public static EndpointsMap use(Class... apiClasses) {

  }

  public static EndpointsMap use(Object... endpointResolvers) {
    for (Object endpointResolver : endpointResolvers) {
      for (Method method : endpointResolver.getClass().getMethods()) {
        if (method.isAnnotationPresent(GraphiEndpoint.class)) {
          GraphiEndpoint endpointAt = method.getAnnotation(GraphiEndpoint.class);
          Endpoint endpoint = new Endpoint() {{
            setName(endpointAt.name().isEmpty() ? method.getName() : endpointAt.name());
            for (Parameter jParam : method.getParameters()) {
              String paramName = jParam.getName();
              String paramType = Graphi.resolveGraphiType(jParam.getType());
              GraphiParam paramAt = jParam.getAnnotation(GraphiParam.class);
              if (paramAt != null && !paramAt.name().isEmpty()) {
                paramName = paramAt.name();
              }
              Param param = new Param(paramName, paramType);
              addParam(new Param(param.getName(), ));
            }
          }};

        }
      }
    }
  }

}
