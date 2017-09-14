package com.devitwithgreg.website.domain.google.api.responce;

public class YouTubeAPIResponse {
    protected String kind;
    protected String etag;
    protected String id;

    public YouTubeAPIResponse(String kind, String etag) {
        this.kind = kind;
        this.etag = etag;
        this.id = "";
    }

    public YouTubeAPIResponse(String kind, String etag, String id) {
        this.kind = kind;
        this.etag = etag;
        this.id = id;
    }

    public YouTubeAPIResponse() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
