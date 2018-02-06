package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/1/25.
 * 转专业
 */

public class TurnProfessional extends BaseActivity{
    private TextView panel_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_turn_professional);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("转专业流程");
    }
}
