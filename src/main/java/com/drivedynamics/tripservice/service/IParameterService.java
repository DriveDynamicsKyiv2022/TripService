package com.drivedynamics.tripservice.service;

import java.util.List;

public interface IParameterService {
    String getParameter(String parameterName, boolean encrypted);

    List<String> getParameters(String parameterName);
}
