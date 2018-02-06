package com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter;

import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.model.ApplicationStudentModel;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.model.IApplicationStudentModel;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public class ApplicationStudentPresenter {
    private IApplicationStudentModel mApplicationModel;
    private IApplicationView mApplicationView;
    public ApplicationStudentPresenter(IApplicationView mApplicationView){
        this.mApplicationView = mApplicationView;
        this.mApplicationModel = new ApplicationStudentModel();
    }
    public void getType(String type){
        mApplicationModel.setType(type);
    }
    public void bindmv(){
        mApplicationModel.loadLisntern(new IApplicationStudentModel.mineSchedule() {
            @Override
            public void loadminSchedule(List<ApplicationStudentBean> data) {
                mApplicationView.showdata(data);
            }

            @Override
            public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {
                mApplicationView.showELVdata(datagroup,datachild);
            }
        });
    }
}
