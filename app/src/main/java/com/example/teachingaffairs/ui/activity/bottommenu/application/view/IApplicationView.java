package com.example.teachingaffairs.ui.activity.bottommenu.application.view;

import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public interface IApplicationView {
    void showdata(List<ApplicationBean> data);
    void showELVdata(List<ApplicationBean> datagroup,List<List<ApplicationBean>> datachild);
}
