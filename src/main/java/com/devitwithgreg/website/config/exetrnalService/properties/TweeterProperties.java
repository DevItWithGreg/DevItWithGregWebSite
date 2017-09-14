package com.devitwithgreg.website.config.exetrnalService.properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Configurable
@ConfigurationProperties(prefix = "external-service.tweeter")
public class TweeterProperties {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
