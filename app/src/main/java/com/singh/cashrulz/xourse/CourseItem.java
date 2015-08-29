package com.singh.cashrulz.xourse;

/**
 * Created by cashrulz on 28/8/15.
 */
public class CourseItem {
    private String title;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public CourseItem(String title, String imageUrl){
        this.title = title;
        this.imageUrl = imageUrl;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
