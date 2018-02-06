package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.model;

import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.bean.ForumBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/2/2.
 */

public interface IForumModel {
    //传递数据的方法
    void loadForumdata(forumdataListener listener);
    //传递数据接口
    interface forumdataListener{
        void load(List<ForumBean> data);
    }
    void getJudge_data(String judge_data);
}
