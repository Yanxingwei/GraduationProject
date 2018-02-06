package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.presenter;

import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.model.ApplicationTeacherModel;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.model.IApplicationTeacherModel;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.view.IApplicationTeacherView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/2/6.
 */

public class ApplicationTeacherPresenter {
    private IApplicationTeacherView mIApplicationTeacherView;
    private IApplicationTeacherModel mIApplicationModel;
    public ApplicationTeacherPresenter(IApplicationTeacherView mIApplicationTeacherView){
        this.mIApplicationTeacherView = mIApplicationTeacherView;
        this.mIApplicationModel = new ApplicationTeacherModel();
    }
    public void getType(String type){
        mIApplicationModel.setType(type);
    }
    public void bindmv(){
        mIApplicationModel.loaddata(new IApplicationTeacherModel.loadListener() {
            @Override
            public void load(List<ApplicationTeacherBean> data) {
                mIApplicationTeacherView.showdata(data);
            }
        });
    }
}
