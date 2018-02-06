package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/2/6.
 * 监考安排页面
 */

public class InvigilationArrangement extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_invigilation_arrangement);
        GoBack();
    }
}
