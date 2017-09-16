package com.devitwithgreg.website.config.exetrnalService;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Configurable
@ConfigurationProperties(prefix = "external-service.facebook")
public class FacebookProperties {

    private String key;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
