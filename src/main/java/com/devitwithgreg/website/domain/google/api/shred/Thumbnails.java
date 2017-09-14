package com.devitwithgreg.website.domain.google.api.shred;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thumbnails {
    @JsonProperty("default")
    private Thumbnail defaults;
    @JsonProperty("medium")
    private Thumbnail medium;
    @JsonProperty("high")
    private Thumbnail high;
    @JsonProperty("standard")
    private Thumbnail standard;
    @JsonProperty("maxres")
    private Thumbnail maxres;

    public Thumbnails(Thumbnail defaults, Thumbnail medium, Thumbnail high, Thumbnail standard, Thumbnail maxres) {
        this.defaults = defaults;
        this.medium = medium;
        this.high = high;
        this.standard = standard;
        this.maxres = maxres;
    }

    public Thumbnails() {
    }

    public Thumbnail getDefaults() {
        return defaults;
    }

    public void setDefaults(Thumbnail defaults) {
        this.defaults = defaults;
    }

    public Thumbnail getMedium() {
        return medium;
    }

    public void setMedium(Thumbnail medium) {
        this.medium = medium;
    }

    public Thumbnail getHigh() {
        return high;
    }

    public void setHigh(Thumbnail high) {
        this.high = high;
    }

    public Thumbnail getStandard() {
        return standard;
    }

    public void setStandard(Thumbnail standard) {
        this.standard = standard;
    }

    public Thumbnail getMaxres() {
        return maxres;
    }

    public void setMaxres(Thumbnail maxres) {
        this.maxres = maxres;
    }
}
