/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Author: Gehad Ahmed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
