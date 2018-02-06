package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.presenter.ApplicationPresenter;
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
    private ApplicationPresenter mApplicationPresenter;

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
        mApplicationPresenter = new ApplicationPresenter(this);
        mApplicationPresenter.getType("考试安排");
        mApplicationPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationBean> data) {
        listview.setAdapter(new ExamArrangementAdapter(this,data));
    }
    @Override
    public void showELVdata(List<ApplicationBean> datagroup, List<List<ApplicationBean>> datachild) {}
}
