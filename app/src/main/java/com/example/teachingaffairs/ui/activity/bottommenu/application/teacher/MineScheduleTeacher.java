package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.presenter.ApplicationTeacherPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.view.IApplicationTeacherView;
import com.example.teachingaffairs.ui.adapter.MineScheduleTeacherAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/2/6.
 * 我的课表（教师）页面
 */

public class MineScheduleTeacher extends BaseActivity implements IApplicationTeacherView {
    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.gridview)
    GridView gridview;
    private ApplicationTeacherPresenter mApplicationTeacherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_mine_schedule);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init(){
        commonPanelTitle.setText("我的课表");
        mApplicationTeacherPresenter = new ApplicationTeacherPresenter(this);
        mApplicationTeacherPresenter.getType("我的课表");
        mApplicationTeacherPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationTeacherBean> data) {
        gridview.setAdapter(new MineScheduleTeacherAdapter(this,data));
    }
}
