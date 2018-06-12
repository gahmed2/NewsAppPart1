package com.example.gehad.news1;

import java.net.URL;
import java.util.Date;

public class News {

    private URL mImageURL;
    private String mTitle;
    private String mAuthor;
    private Date mDate;
    private String mContent;
    private String mCategory;
    private String mUrl;

    public News(URL imageURL, String title, String author, Date pDate, String content,
                String category, String url){
        mImageURL = imageURL;
        mTitle = title;
        mAuthor = author;
        mDate = pDate;
        mContent = content;
        mCategory = category;
        mUrl = url;
    }

    public URL getImageURL() {
        return mImageURL;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public Date getDate() {
        return mDate;
    }

    public String getContent() {
        return mContent;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getUrl() {
        return mUrl;
    }
}
