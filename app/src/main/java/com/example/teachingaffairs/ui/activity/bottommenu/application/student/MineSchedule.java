package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.presenter.ApplicationPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.MineScheduleAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/25.
 * 我的课表
 */

public class MineSchedule extends BaseActivity implements IApplicationView{
    private TextView panel_title;
    private ApplicationPresenter mApplicationPresenter;
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
        mApplicationPresenter = new ApplicationPresenter(this);
        mApplicationPresenter.getType("本周课表");
        mApplicationPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationBean> data) {
        gridView.setAdapter(new MineScheduleAdapter(this,data));
    }

    @Override
    public void showELVdata(List<ApplicationBean> datagroup, List<List<ApplicationBean>> datachild) {

    }
}
