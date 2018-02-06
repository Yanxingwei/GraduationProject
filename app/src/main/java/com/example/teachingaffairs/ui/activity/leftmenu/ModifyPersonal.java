package com.example.teachingaffairs.ui.activity.leftmenu;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/2/6.
 */

public class ModifyPersonal extends BaseActivity {
    private TextView panel_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_personal_information_modify);
        GoBack();
        init();
    }
    private void init(){
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("修改");
    }

}
