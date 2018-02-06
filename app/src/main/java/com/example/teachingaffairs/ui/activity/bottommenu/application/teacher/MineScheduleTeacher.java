package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.ApplicationTeacherBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.view.IApplicationTeacherView;

import java.util.List;

/**
 * Created by 闫星位 on 2018/2/6.
 * 我的课表（教师）页面
 */

public class MineScheduleTeacher extends BaseActivity implements IApplicationTeacherView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_mine_schedule);
        GoBack();
    }

    @Override
    public void showdata(List<ApplicationTeacherBean> data) {

    }
}
