package com.drivedynamics.tripservice.service.impl;

import com.amazonaws.services.simplesystemsmanagement.AWSSimpleSystemsManagement;
import com.amazonaws.services.simplesystemsmanagement.model.GetParameterRequest;
import com.drivedynamics.tripservice.service.IParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SsmParameterService implements IParameterService {
    private final AWSSimpleSystemsManagement awsSimpleSystemsManagement;

    @Autowired
    public SsmParameterService(AWSSimpleSystemsManagement awsSimpleSystemsManagement) {
        this.awsSimpleSystemsManagement = awsSimpleSystemsManagement;
    }

    @Override
    public String getParameter(String parameterName, boolean encrypted) {
        GetParameterRequest parameterRequest = new GetParameterRequest()
                .withName(parameterName)
                .withWithDecryption(encrypted);
        return awsSimpleSystemsManagement.getParameter(parameterRequest).getParameter().getValue();
    }


    @Override
    public List<String> getParameters(String parameterName) {
        String parameter = getParameter(parameterName, false);
        return Arrays.stream(parameter.split(",")).collect(Collectors.toList());
    }
}
