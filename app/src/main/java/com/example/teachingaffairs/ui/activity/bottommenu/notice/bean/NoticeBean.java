package com.example.teachingaffairs.ui.activity.bottommenu.notice.bean;

/**
 * Created by 闫星位 on 2018/1/23.
 */

public class NoticeBean {
    private String oldertime,notice_time,notice_content,notice_source,notice_title,type;
    public NoticeBean(String oldertime,String notice_time,String notice_content,String notice_source,String notice_title,String type){
        this.oldertime = oldertime;
        this.notice_content = notice_content;
        this.notice_source = notice_source;
        this.notice_time = notice_time;
        this.notice_title = notice_title;
        this.type = type;
    }
    public String getOldertime(){
        return oldertime;
    }
    public String getNotice_time(){
        return notice_time;
    }
    public String getNotice_content(){
        return notice_content;
    }
    public String getNotice_source(){
        return notice_source;
    }
    public String getNotice_title(){
        return notice_title;
    }
    public String getType(){
        return type;
    }
}
