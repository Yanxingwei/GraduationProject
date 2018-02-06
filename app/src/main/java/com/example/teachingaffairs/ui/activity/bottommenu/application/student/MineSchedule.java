package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter.ApplicationStudentPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.view.IApplicationStudentView;
import com.example.teachingaffairs.ui.adapter.MineScheduleAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/25.
 * 我的课表
 */

public class MineSchedule extends BaseActivity implements IApplicationStudentView {
    private TextView panel_title;
    private ApplicationStudentPresenter mApplicationPresenter;
    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_mine_schedule);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("本周课表");
        gridView = (GridView) findViewById(R.id.gridview);
        mApplicationPresenter = new ApplicationStudentPresenter(this);
        mApplicationPresenter.getType("本周课表");
        mApplicationPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationStudentBean> data) {
        gridView.setAdapter(new MineScheduleAdapter(this,data));
    }

    @Override
    public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {

    }
}
