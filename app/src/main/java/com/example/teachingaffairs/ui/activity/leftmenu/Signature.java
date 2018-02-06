package com.example.teachingaffairs.ui.activity.leftmenu;

import android.os.Bundle;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/1/9.
 */

public class Signature extends BaseActivity {
    private TextView title_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_signature);
        init();
    }
    public void init(){
        panel_title();
        GoBack();
    }
    /**
     * 初始化标题
     */
    public void panel_title(){
        title_text = (TextView)findViewById(R.id.common_panel_title);
        title_text.setText("个人签名");
    }
}
