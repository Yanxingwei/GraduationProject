package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter.ApplicationStudentPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.ExamArrangementAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/1/25.
 * 考试安排
 */

public class ExamArrangement extends BaseActivity implements IApplicationView{
    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.listview)
    ListView listview;
    private ApplicationStudentPresenter mApplicationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_exam_arrangement);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init() {
        commonPanelTitle.setText("考试安排");
        mApplicationPresenter = new ApplicationStudentPresenter(this);
        mApplicationPresenter.getType("考试安排");
        mApplicationPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationStudentBean> data) {
        listview.setAdapter(new ExamArrangementAdapter(this,data));
    }
    @Override
    public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {}
}
