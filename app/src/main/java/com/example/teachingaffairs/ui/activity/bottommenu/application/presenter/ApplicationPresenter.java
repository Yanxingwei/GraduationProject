package com.example.teachingaffairs.ui.activity.bottommenu.application.presenter;

import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.model.ApplicationModel;
import com.example.teachingaffairs.ui.activity.bottommenu.application.model.IApplicationModel;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public class ApplicationPresenter {
    private IApplicationModel mApplicationModel;
    private IApplicationView mApplicationView;
    public ApplicationPresenter(IApplicationView mApplicationView){
        this.mApplicationView = mApplicationView;
        this.mApplicationModel = new ApplicationModel();
    }
    public void getType(String type){
        mApplicationModel.setType(type);
    }
    public void bindmv(){
        mApplicationModel.loadLisntern(new IApplicationModel.mineSchedule() {
            @Override
            public void loadminSchedule(List<ApplicationBean> data) {
                mApplicationView.showdata(data);
            }

            @Override
            public void showELVdata(List<ApplicationBean> datagroup, List<List<ApplicationBean>> datachild) {
                mApplicationView.showELVdata(datagroup,datachild);
            }
        });
    }
}
