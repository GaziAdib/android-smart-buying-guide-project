
package com.example.anabi.finalyearproject1try.BloggerApiPosts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Posts {

    @SerializedName("totalItems")
    @Expose
    private Integer totalItems;
    @SerializedName("selfLink")
    @Expose
    private String selfLink;

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

}
