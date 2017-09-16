package com.devitwithgreg.website.config.serviceExecutor;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "service-executor")
@Configurable
@Component
public class ServiceExecutorProperties {
    private String serviceExecutorName;
    private int executionDelay;


    public String getServiceExecutorName() {
        return serviceExecutorName;
    }

    public void setServiceExecutorName(String serviceExecutorName) {
        this.serviceExecutorName = serviceExecutorName;
    }

    public int getExecutionDelay() {
        return executionDelay;
    }

    public void setExecutionDelay(int executionDelay) {
        this.executionDelay = executionDelay;
    }
}
