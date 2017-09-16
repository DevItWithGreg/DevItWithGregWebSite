package com.devitwithgreg.website.config.exetrnalService;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "external-service")
@Configurable
@Component
public class ExternalServiceProperties {

    private GoogleProperties google;
    private FacebookProperties facebook;
    private TweeterProperties tweeter;

    public GoogleProperties getGoogle() {
        return google;
    }

    public void setGoogle(GoogleProperties google) {
        this.google = google;
    }

    public FacebookProperties getFacebook() {
        return facebook;
    }

    public void setFacebook(FacebookProperties facebook) {
        this.facebook = facebook;
    }

    public TweeterProperties getTweeter() {
        return tweeter;
    }

    public void setTweeter(TweeterProperties tweeter) {
        this.tweeter = tweeter;
    }

}
