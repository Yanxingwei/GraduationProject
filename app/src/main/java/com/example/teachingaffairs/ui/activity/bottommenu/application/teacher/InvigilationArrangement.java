package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.presenter.ApplicationTeacherPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.view.IApplicationTeacherView;
import com.example.teachingaffairs.ui.adapter.InvigilationArrangementAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/2/6.
 * 监考安排页面
 */

public class InvigilationArrangement extends BaseActivity implements IApplicationTeacherView{

    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.listview)
    ListView listview;
    private ApplicationTeacherPresenter mApplicationTeacherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_invigilation_arrangement);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init() {
        commonPanelTitle.setText("监考安排");
        mApplicationTeacherPresenter = new ApplicationTeacherPresenter(this);
        mApplicationTeacherPresenter.getType("监考安排");
        mApplicationTeacherPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationTeacherBean> data) {
        listview.setAdapter(new InvigilationArrangementAdapter(this,data));
    }
}
