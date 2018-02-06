package com.example.teachingaffairs.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.example.teachingaffairs.R;

/**
 * Created by 闫星位 on 2018/1/9.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private TextView goback;
    protected Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
    }
    public void GoBack(){
        goback = (TextView) findViewById(R.id.go_back);
        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    /**
     * 通用提示对话框
     */
    protected class TipDialog extends Dialog {
        public AlertDialog alertDialog;

        /**
         * 通用提示对话框
         *
         * @param width               对话框的宽度占整个屏幕宽度的百分比，例如，0.8，如果传-1，使用默认值0.8
         * @param height              对话框的高度占整个屏幕高度的百分比，例如，0.25，如果传-1，使用默认值0.25
         * @param msg                 对话框的内容，如果传null或空，使用默认值提示
         * @param leftText            左边按钮的文本，如果传null或空，默认值是确认
         * @param rightText           右边按钮的文本，如果传null或空，默认值是取消
         * @param leftOnClickListener 左边按钮的点击事件的监听
         */
        public TipDialog(Context context, double width, double height, String msg,
                         String leftText, String rightText, View.OnClickListener leftOnClickListener ,View.OnClickListener rightonClickListener) {
            super(context);
            alertDialog = new AlertDialog.Builder(context,R.style.dialog_bg_transparent).create();
            alertDialog.show();
            Window window = alertDialog.getWindow();
            window.setContentView(R.layout.common_tip_dialog);

            Display d = getWindowManager().getDefaultDisplay();
            int x = (int) (d.getWidth() * (width == -1 ? 0.8 : width));
            int y = (int) (d.getHeight() * (height == -1 ? 0.25 : height));
            alertDialog.getWindow().setLayout(x, y);

            TextView titleTv = (TextView) window.findViewById(R.id.common_tip_dialog_msg_tv);
            titleTv.setText(TextUtils.isEmpty(msg)? "提示" : msg);
            TextView leftTv = (TextView) window.findViewById(R.id.common_tip_dialog_left_tv);
            leftTv.setText(TextUtils.isEmpty(leftText)? "确定" : leftText);
            TextView rightTv = (TextView) window.findViewById(R.id.common_tip_dialog_right_tv);
            rightTv.setText(TextUtils.isEmpty(leftText)? "取消" : rightText);

            leftTv.setOnClickListener(leftOnClickListener);

            rightTv.setOnClickListener(rightonClickListener);
        }

        public Dialog getInstance() {
            return alertDialog;
        }
    }

}