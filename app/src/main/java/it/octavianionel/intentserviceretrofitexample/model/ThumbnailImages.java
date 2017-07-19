package it.octavianionel.intentserviceretrofitexample.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by octavian on 7/19/17.
 */

public class ThumbnailImages {

    @SerializedName("full")
    @Expose
    private Full_ full;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail_ thumbnail;
    @SerializedName("medium")
    @Expose
    private Medium_ medium;
    @SerializedName("medium_large")
    @Expose
    private MediumLarge_ mediumLarge;
    @SerializedName("xlarge")
    @Expose
    private Xlarge_ xlarge;
    @SerializedName("featured")
    @Expose
    private Featured_ featured;
    @SerializedName("feed")
    @Expose
    private Feed_ feed;
    @SerializedName("small")
    @Expose
    private Small_ small;

    public Full_ getFull() {
        return full;
    }

    public void setFull(Full_ full) {
        this.full = full;
    }

    public Thumbnail_ getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail_ thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Medium_ getMedium() {
        return medium;
    }

    public void setMedium(Medium_ medium) {
        this.medium = medium;
    }

    public MediumLarge_ getMediumLarge() {
        return mediumLarge;
    }

    public void setMediumLarge(MediumLarge_ mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    public Xlarge_ getXlarge() {
        return xlarge;
    }

    public void setXlarge(Xlarge_ xlarge) {
        this.xlarge = xlarge;
    }

    public Featured_ getFeatured() {
        return featured;
    }

    public void setFeatured(Featured_ featured) {
        this.featured = featured;
    }

    public Feed_ getFeed() {
        return feed;
    }

    public void setFeed(Feed_ feed) {
        this.feed = feed;
    }

    public Small_ getSmall() {
        return small;
    }

    public void setSmall(Small_ small) {
        this.small = small;
    }

}
