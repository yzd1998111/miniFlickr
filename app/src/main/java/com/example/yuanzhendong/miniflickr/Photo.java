package com.example.yuanzhendong.miniflickr;

import java.io.Serializable;

public class Photo implements Serializable{

    private String mTitle;
    private String mAuthor;
    private String mAuthorId;
    private String mImage;
    private String mLink;
    private String mTags;
    private static final long serialVersionUID = 1L;


    public Photo(String mTitle, String mAuthor, String mAuthorId, String mImage, String mLink, String mTags) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
        this.mAuthorId = mAuthorId;
        this.mImage = mImage;
        this.mLink = mLink;
        this.mTags = mTags;
    }



    String getTitle() {
        return mTitle;
    }

    String getAuthor() {
        return mAuthor;
    }

    String getAuthorId() {
        return mAuthorId;
    }

    String getImage() {
        return mImage;
    }

    String getLink() {
        return mLink;
    }

    String getTags() {
        return mTags;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "mTitle='" + mTitle + '\'' +
                ", mAuthor='" + mAuthor + '\'' +
                ", mAuthorId='" + mAuthorId + '\'' +
                ", mImage='" + mImage + '\'' +
                ", mLink='" + mLink + '\'' +
                ", mTags='" + mTags + '\'' +
                '}';
    }
}
