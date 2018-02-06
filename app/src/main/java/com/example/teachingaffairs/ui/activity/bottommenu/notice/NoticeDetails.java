package com.example.teachingaffairs.ui.activity.bottommenu.notice;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/1/23.
 */

public class NoticeDetails extends BaseActivity{
    private TextView common_panel_title;
    private TextView notice_title,notice_content,notice_source,notice_time;
    private String type,title,source,time,content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_notice_details);
        notice_type();
        init();
        GoBack();
    }
    private void init(){
        common_panel_title = (TextView) findViewById(R.id.common_panel_title);
        common_panel_title.setText(type+"详情");
        notice_title = (TextView) findViewById(R.id.notice_title);
        notice_title.setText(title);
        notice_content = (TextView) findViewById(R.id.notice_content);
        notice_source = (TextView) findViewById(R.id.notice_source);
        notice_source.setText(source);
        notice_time = (TextView) findViewById(R.id.notice_time);
        notice_time.setText(time);
        notice_content = (TextView) findViewById(R.id.notice_content);
        notice_content.setText(content);
    }
    private void notice_type(){
        String notice_type,notice_title,notice_source,notice_time,notice_content;
        Intent intent_data = getIntent();
        notice_type = intent_data.getStringExtra("notice_type");
        type = notice_type;
        notice_title = intent_data.getStringExtra("notice_title");
        title = notice_title;
        notice_source = intent_data.getStringExtra("notice_source");
        source = notice_source;
        notice_time = intent_data.getStringExtra("notice_time");
        time = notice_time;
        notice_content = intent_data.getStringExtra("notice_content");
        content = notice_content;
    }
}
