package com.devitwithgreg.website.domain.google.api.responce;

import com.devitwithgreg.website.domain.google.api.shred.Item;
import com.devitwithgreg.website.domain.google.api.shred.PageInfo;

import java.util.List;

public class YouTubeItemResponse extends YouTubeAPIResponse {
    private String nextPageToken;
    private PageInfo pageInfo;
    private List<Item> items;


    public YouTubeItemResponse() {
    }

    public YouTubeItemResponse(String kind, String etag, String nextPageToken, PageInfo pageInfo, List<Item> items) {
        super(kind, etag);
        this.nextPageToken = nextPageToken;
        this.pageInfo = pageInfo;
        this.items = items;
    }

    public YouTubeItemResponse(String kind, String etag, String id, String nextPageToken, PageInfo pageInfo, List<Item> items) {
        super(kind, etag, id);
        this.nextPageToken = nextPageToken;
        this.pageInfo = pageInfo;
        this.items = items;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
