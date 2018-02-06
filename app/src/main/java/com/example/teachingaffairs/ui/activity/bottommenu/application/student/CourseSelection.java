package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.presenter.ApplicationPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.CourseSelectionAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/25.
 * 网上选课
 */

public class CourseSelection extends BaseActivity implements IApplicationView{
    private TextView panel_title;
    private ListView listView;
    private ApplicationPresenter mApplicationPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_course_selection);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("选课中心");
        listView = (ListView) findViewById(R.id.listview);
        mApplicationPresenter = new ApplicationPresenter(this);
        mApplicationPresenter.getType("选课中心");
        mApplicationPresenter.bindmv();
        courseDetails();
    }

    @Override
    public void showdata(List<ApplicationBean> data) {
        listView.setAdapter(new CourseSelectionAdapter(this,data));
    }

    @Override
    public void showELVdata(List<ApplicationBean> datagroup, List<List<ApplicationBean>> datachild) {

    }

    private void courseDetails(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textbook_name,teacher_name,time,address;
                String textbook_name_text,teacher_name_text,time_text,address_text;

                textbook_name = (TextView) view.findViewById(R.id.textbook_name);
                teacher_name = (TextView) view.findViewById(R.id.teacher_name);
                time = (TextView) view.findViewById(R.id.time);
                address = (TextView) view.findViewById(R.id.address);

                textbook_name_text = textbook_name.getText().toString();
                teacher_name_text = teacher_name.getText().toString();
                time_text = time.getText().toString();
                address_text = address.getText().toString();

                Intent intent = new Intent(CourseSelection.this,CourseDetails.class);
                intent.putExtra("textbook_name",textbook_name_text);
                intent.putExtra("teacher_name",teacher_name_text);
                intent.putExtra("time",time_text);
                intent.putExtra("address",address_text);
                startActivity(intent);
            }
        });
    }

}
