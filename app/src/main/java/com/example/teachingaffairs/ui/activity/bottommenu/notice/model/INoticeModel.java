package com.example.teachingaffairs.ui.activity.bottommenu.notice.model;

import com.example.teachingaffairs.ui.activity.bottommenu.notice.bean.NoticeBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/23.
 */

public interface INoticeModel {
    void dataListener(loadListener listener);
    interface loadListener{
        void load(List<NoticeBean> data);
    }
}
