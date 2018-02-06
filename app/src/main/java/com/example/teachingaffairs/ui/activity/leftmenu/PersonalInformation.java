package com.example.teachingaffairs.ui.activity.leftmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/1/9.
 */

public class PersonalInformation extends BaseActivity{
    private TextView title_text;
    private TextView add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_personal_information);
        init();
    }
    public void init(){
        add = (TextView)findViewById(R.id.add);
        add.setVisibility(View.VISIBLE);
        panel_title();
        GoBack();
        addListener();
    }
    /**
     * 初始化标题
     */
    public void panel_title(){
        title_text = (TextView)findViewById(R.id.common_panel_title);
        title_text.setText("个人简历");
    }

    /**
     * 给修改键添加监听事件
     */
    private void addListener(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PersonalInformation.this,ModifyPersonal.class);
                startActivity(intent);

            }
        });
    }
}
