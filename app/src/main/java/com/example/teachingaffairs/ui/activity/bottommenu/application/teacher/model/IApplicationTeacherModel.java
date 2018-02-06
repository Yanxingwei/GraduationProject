package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.model;

import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/2/6.
 */

public interface IApplicationTeacherModel {
    void setType(String type);
    void loaddata(loadListener listener);
    interface loadListener{
        void load(List<ApplicationTeacherBean> data);
    }
}
