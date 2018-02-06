package com.example.teachingaffairs.ui.activity.leftmenu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;

/**
 * Created by 闫星位 on 2018/1/9.
 */

public class OnlineService extends BaseActivity{
    private TextView title_text;
    private TextView phone_icon;
    private TextView phone_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_online_service);
        panel_title();
        init();
    }
    public void init(){
        panel_title();
        GoBack();
        call();
    }
    /**
     * 初始化标题
     */
    public void panel_title(){
        title_text = (TextView)findViewById(R.id.common_panel_title);
        title_text.setText("在线服务");
    }
    /**
     * 点击电话图标拨打电话
     */
    private void call(){
        phone_number = (TextView) findViewById(R.id.phone_number);
        phone_icon = (TextView) findViewById(R.id.phone_icon);
        phone_icon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                String tell = phone_number.getText().toString();
                Uri data = Uri.parse("tel:" + tell);
                intent.setData(data);
                if (ActivityCompat.checkSelfPermission(OnlineService.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
