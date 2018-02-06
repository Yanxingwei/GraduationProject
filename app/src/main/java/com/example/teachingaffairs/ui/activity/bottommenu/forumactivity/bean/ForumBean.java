package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.bean;

/**
 * Created by 闫星位 on 2018/2/2.
 */

public class ForumBean {
    private int head_picture;
    private int content_picture;
    private String user_name;
    private String content_text;
    private String release_time;
    private String discuss_number;

    public ForumBean(int head_picture,int content_picture,String user_name,String content_text,String release_time,String discuss_number){
        this.head_picture = head_picture;
        this.content_picture = content_picture;
        this.user_name = user_name;
        this.content_text = content_text;
        this.release_time = release_time;
        this.discuss_number = discuss_number;
    }

    public int getHead_picture() {
        return head_picture;
    }

    public int getContent_picture() {
        return content_picture;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getContent_text() {
        return content_text;
    }

    public String getRelease_time() {
        return release_time;
    }

    public String getDiscuss_number() {
        return discuss_number;
    }

}
