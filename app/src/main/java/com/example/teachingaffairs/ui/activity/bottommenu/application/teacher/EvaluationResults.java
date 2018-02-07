package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.presenter.ApplicationTeacherPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.view.IApplicationTeacherView;
import com.example.teachingaffairs.ui.adapter.EvaluationResultsAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/2/6.
 * 评教结果页面
 */

public class EvaluationResults extends BaseActivity implements IApplicationTeacherView {
    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.listview)
    ListView listview;
    private ApplicationTeacherPresenter mApplicationTeacherPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_evaluation_results);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init(){
        commonPanelTitle.setText("评教结果");
        mApplicationTeacherPresenter = new ApplicationTeacherPresenter(this);
        mApplicationTeacherPresenter.getType("评教结果");
        mApplicationTeacherPresenter.bindmv();
    }
    @Override
    public void showdata(List<ApplicationTeacherBean> data) {
        listview.setAdapter(new EvaluationResultsAdapter(this,data));
    }
}
