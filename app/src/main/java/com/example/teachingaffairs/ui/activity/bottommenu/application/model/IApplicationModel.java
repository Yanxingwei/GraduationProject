package com.example.teachingaffairs.ui.activity.bottommenu.application.model;

import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public interface IApplicationModel {
    void loadLisntern(mineSchedule mineschedule);
    interface mineSchedule{
        void loadminSchedule(List<ApplicationBean> data);
        void showELVdata(List<ApplicationBean> datagroup,List<List<ApplicationBean>> datachild);
    }
    void setType(String type);
}
