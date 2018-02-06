package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/2/6.
 * 监考安排页面
 */

public class InvigilationArrangement extends BaseActivity {

    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.listview)
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_invigilation_arrangement);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init() {
        commonPanelTitle.setText("监考安排");
    }

}
