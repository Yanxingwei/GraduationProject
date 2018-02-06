package com.example.teachingaffairs.ui.activity.bottommenu.application;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.presenter.ApplicationPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.CourseSelection;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.EvaluationTeaching;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.ExamArrangement;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.FreeClassroom;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.MineSchedule;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.ResultsQuery;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.TrainingScheme;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.TurnProfessional;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.EvaluationResults;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.InvigilationArrangement;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.MineScheduleTeacher;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.ScoreRegistration;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.TeachingTask;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.ApplicationAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 闫星位 on 2018/1/5.
 * 应用页
 */

public class Application extends BaseActivity implements IApplicationView{
    private GridView gridView;
    private ArrayList<HashMap<String,Object>> datalist;
    private Intent intent;
    private LinearLayout exam_arrangement,results_query;
    private ApplicationPresenter mApplicationPresenter;
    private List<ApplicationBean> data;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        judgePower();
    }

    /**
     * 判断权限显示对应的应用界面
     */
    private void judgePower(){
        if(power().equals("学生")){
            //学生应用界面
            setContentView(R.layout.app_application_student);
            initstudent();
        }else{
            //教师应用界面
            setContentView(R.layout.app_application_teacher);
            initteacher();
        }
    }

    //拿到传进来的权限值
    private String power(){
        Intent intent_data = getIntent();
        String power = intent_data.getStringExtra("power");
        return power;
    }

    //=======================================================================================================
    /**
     * 学生应用界面
     */
    private void initstudent(){
        mApplicationPresenter = new ApplicationPresenter(this);
        exam_arrangement = (LinearLayout) findViewById(R.id.exam_arrangement);
        results_query = (LinearLayout) findViewById(R.id.results_query);
        gridView = (GridView) findViewById(R.id.gridview);
        datalist = getStudentdata();
        ApplicationAdapter adapter = new ApplicationAdapter(this,datalist);
        gridView.setAdapter(adapter);
        Listener();
    }

    public ArrayList<HashMap<String,Object>> getStudentdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String ,Object> data;
        String name [] = {"网上选课","培养方案","网上评教","我的课表","空闲教室","转专业"};
        int logo [] = {R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,};

        for(int i = 0; i < name.length; i++){
            data = new HashMap<>();
            data.put("name",name[i]);
            data.put("logo",logo[i]);
            datalist.add(data);
        }
        return datalist;
    }

    @Override
    public void showdata(List<ApplicationBean> data) {
        this.data = data;
    }

    public void Listener(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    //网上选课
                    case 0:
                        intent = new Intent(Application.this,CourseSelection.class);
                        startActivity(intent);
                        break;
                    //培养方案
                    case 1:
                        intent = new Intent(Application.this,TrainingScheme.class);
                        startActivity(intent);
                        break;
                    //网上评教
                    case 2:
                        intent = new Intent(Application.this,EvaluationTeaching.class);
                        startActivity(intent);
                        break;
                    //我的课表
                    case 3:
                        intent = new Intent(Application.this,MineSchedule.class);
                        startActivity(intent);
                        break;
                    //空闲教室
                    case 4:
                        intent = new Intent(Application.this,FreeClassroom.class);
                        startActivity(intent);
                        break;
                    //转专业
                    case 5:
                        intent = new Intent(Application.this,TurnProfessional.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        //考试安排
        exam_arrangement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApplicationPresenter.getType("考试安排");
                mApplicationPresenter.bindmv();
                if(data.isEmpty()){
                    alertDialog = (AlertDialog) new TipDialog(Application.this, 0.8, 0.15, "暂无考试安排",
                            "进去", "不进了", quitListener,cancelListener).getInstance();
                }else{
                    intent = new Intent(Application.this,ExamArrangement.class);
                    startActivity(intent);
                }
            }
        });

        //成绩查询
        results_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Application.this,ResultsQuery.class);
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener quitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            intent = new Intent(Application.this,ExamArrangement.class);
            startActivity(intent);
            alertDialog.dismiss();
        }
    };
    private View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alertDialog.dismiss();
        }
    };

    @Override
    public void showELVdata(List<ApplicationBean> datagroup, List<List<ApplicationBean>> datachild) {

    }


    /**
     * 教师应用界面
     */
    //=====================================================================================================================

    private void initteacher(){
        gridView = (GridView) findViewById(R.id.gridview);
        datalist = getTeacherdata();
        ApplicationAdapter adapter = new ApplicationAdapter(this,datalist);
        gridView.setAdapter(adapter);
        teacherListener();
    }
    private ArrayList<HashMap<String,Object>> getTeacherdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String,Object> data;
        String name [] = {"教学任务","我的课表","监考安排","成绩录入","评教结果"};
        int logo [] = {R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo};
        for(int i = 0 ; i < name.length ; i++){
            data = new HashMap<>();
            data.put("name",name[i]);
            data.put("logo",logo[i]);
            datalist.add(data);
        }
        return datalist;
    }

    private void teacherListener(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(Application.this, TeachingTask.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Application.this, MineScheduleTeacher.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Application.this, InvigilationArrangement.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Application.this, ScoreRegistration.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(Application.this, EvaluationResults.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    //=====================================================================================================================
}
