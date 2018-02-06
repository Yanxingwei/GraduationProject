package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter.ApplicationStudentPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.view.IApplicationStudentView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/29.
 * 课程详情
 */

public class CourseDetails extends BaseActivity implements IApplicationStudentView {
    private TextView panel_title;
    private TextView textbook_name,teacher_name,time,address,Coursede_details;
    private String textbook_name_text,teacher_name_text,time_text,address_text,Coursede_details_text;
    private TextView btn_Select;
    private ApplicationStudentPresenter mApplicationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_course_details);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("课程详情");

        textbook_name = (TextView) findViewById(R.id.textbook_name);
        teacher_name = (TextView) findViewById(R.id.teacher_name);
        time = (TextView) findViewById(R.id.time);
        address = (TextView) findViewById(R.id.address);
        Coursede_details = (TextView) findViewById(R.id.Coursede_details);
        btn_Select = (TextView) findViewById(R.id.btn_Select);

        intent_data();

        textbook_name.setText(textbook_name_text);
        teacher_name.setText(teacher_name_text);
        time.setText(time_text);
        address.setText(address_text);

        mApplicationPresenter = new ApplicationStudentPresenter(this);
        mApplicationPresenter.getType(textbook_name_text);
        mApplicationPresenter.bindmv();
        Select();
    }
    private void intent_data(){
        Intent intent_data = getIntent();
        String textbook_name_intent = intent_data.getStringExtra("textbook_name");
        String teacher_name_intent = intent_data.getStringExtra("teacher_name");
        String time_intent = intent_data.getStringExtra("time");
        String address_intent = intent_data.getStringExtra("address");

        textbook_name_text = textbook_name_intent;
        teacher_name_text = teacher_name_intent;
        time_text = time_intent;
        address_text = address_intent;
    }

    private void Select(){
        btn_Select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选课的逻辑
            }
        });
    }

    @Override
    public void showdata(List<ApplicationStudentBean> data) {
        Coursede_details.setText(data.get(0).getMineSchedule());
    }

    @Override
    public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {

    }
}
