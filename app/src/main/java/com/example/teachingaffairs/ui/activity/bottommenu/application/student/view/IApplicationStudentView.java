package com.example.teachingaffairs.ui.activity.bottommenu.application.student.view;

import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public interface IApplicationStudentView {
    void showdata(List<ApplicationStudentBean> data);
    void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild);
}
