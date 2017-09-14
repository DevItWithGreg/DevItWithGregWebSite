package com.devitwithgreg.website.domain.google.api.shred;

import com.devitwithgreg.website.domain.google.api.responce.YouTubeAPIResponse;

public class Item extends YouTubeAPIResponse {
    private Snippet snippet;
    private ContentDetails contentDetails;

    public Item() {
    }

    public Item(String kind, String etag, Snippet snippet) {
        super(kind, etag);
        this.snippet = snippet;
    }

    public Item(String kind, String etag, String id, Snippet snippet) {
        super(kind, etag, id);
        this.snippet = snippet;
    }

    public Item(Snippet snippet) {
        this.snippet = snippet;
    }

    public Item(String kind, String etag, ContentDetails contentDetails) {
        super(kind, etag);
        this.contentDetails = contentDetails;
    }

    public Item(String kind, String etag, String id, ContentDetails contentDetails) {
        super(kind, etag, id);
        this.contentDetails = contentDetails;
    }

    public Item(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    public Item(String kind, String etag, Snippet snippet, ContentDetails contentDetails) {
        super(kind, etag);
        this.snippet = snippet;
        this.contentDetails = contentDetails;
    }

    public Item(String kind, String etag, String id, Snippet snippet, ContentDetails contentDetails) {
        super(kind, etag, id);
        this.snippet = snippet;
        this.contentDetails = contentDetails;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }
}
