package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter.ApplicationStudentPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.EvaluationTeachingAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/25.
 * 网上评教
 */

public class EvaluationTeaching extends BaseActivity implements IApplicationView{
    private TextView panel_title;
    private ListView listview;
    private ApplicationStudentPresenter mApplicationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_evaluation_teaching);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("本学期课程");
        listview = (ListView) findViewById(R.id.listview);
        mApplicationPresenter = new ApplicationStudentPresenter(this);
        mApplicationPresenter.getType("本学期课程");
        mApplicationPresenter.bindmv();
    }

    @Override
    public void showdata(List<ApplicationStudentBean> data) {
        listview.setAdapter(new EvaluationTeachingAdapter(this,data));
        Listener();
    }

    @Override
    public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {

    }
    private void Listener(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name;
                TextView teacher_name;
                teacher_name = (TextView) view.findViewById(R.id.teacher_name);
                name = teacher_name.getText().toString();
                Intent intent = new Intent(EvaluationTeaching.this, EvaluationTeachingStart.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
