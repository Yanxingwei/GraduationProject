package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.view.IApplicationTeacherView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/2/6.
 * 成绩录入页面
 */

public class ScoreRegistration extends BaseActivity implements IApplicationTeacherView {

    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.the_class)
    EditText theClass;
    @Bind(R.id.course_name)
    EditText courseName;
    @Bind(R.id.experimental_results)
    EditText experimentalResults;
    @Bind(R.id.grades)
    EditText grades;
    @Bind(R.id.midterm_grades)
    EditText midtermGrades;
    @Bind(R.id.final_result)
    EditText finalResult;
    @Bind(R.id.btn_next)
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_score_registration);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init() {
        commonPanelTitle.setText("成绩录入");
        ListenerNext();
    }

    private void ListenerNext() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1,number2,number3,number4;
                    number1 = Integer.parseInt(experimentalResults.getText().toString());
                    number2 = Integer.parseInt(grades.getText().toString());
                    number3 = Integer.parseInt(midtermGrades.getText().toString());
                    number4 = Integer.parseInt(finalResult.getText().toString());
                if(number1+number2+number3+number4== 100){
                    Toast.makeText(ScoreRegistration.this,"hahaha",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ScoreRegistration.this,"比例设置不合适",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void showdata(List<ApplicationTeacherBean> data) {

    }
}
