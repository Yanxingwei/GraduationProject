package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.presenter.ApplicationPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.EvaluationTeachingStartAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/30.
 */

public class EvaluationTeachingStart extends BaseActivity implements IApplicationView{
    private TextView panel_title;
    private ExpandableListView elv_evaluation_teacher;
    private ApplicationPresenter mApplicationPresenter;
    private EvaluationTeachingStartAdapter adapter;
    private TextView name;
    private TextView btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_evaluation_teaching_start);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("线上评教");
        name = (TextView) findViewById(R.id.name);
        btn_submit = (TextView) findViewById(R.id.btn_submit);
        name.setText("请对"+name()+"老师进行评教：");
        elv_evaluation_teacher = (ExpandableListView) findViewById(R.id.elv_evaluation_teacher);
        mApplicationPresenter = new ApplicationPresenter(this);
        mApplicationPresenter.getType("网上评教");
        mApplicationPresenter.bindmv();
//        submitListener();
    }

    private String name(){
        String name;
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        return name;
    }
    @Override
    public void showdata(List<ApplicationBean> data) {}

    @Override
    public void showELVdata(List<ApplicationBean> datagroup, List<List<ApplicationBean>> datachild) {
        adapter = new EvaluationTeachingStartAdapter(this,datagroup,datachild);
        elv_evaluation_teacher.setAdapter(adapter);
        int groupcount = elv_evaluation_teacher.getCount();
        for(int i = 0 ; i < groupcount ; i++){
            elv_evaluation_teacher.expandGroup(i);
        }
        groupListener();
    }
    private void groupListener(){
        elv_evaluation_teacher.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
    }
    /**
     * 评教提交数据具体实现方法
     */
//    private void submitListener(){
//        btn_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//    }
}
