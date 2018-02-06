package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.components.MyRoundImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/1/15.
 */

public class ForumDetails extends BaseActivity {
    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.head_picture)
    MyRoundImageView headPicture;
    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.time)
    TextView time;
    @Bind(R.id.content_text)
    TextView contentText;
    @Bind(R.id.content_picture)
    ImageView contentPicture;
    @Bind(R.id.linearlayout)
    LinearLayout linearlayout;
    private String user_name , release_time , content_text;
    private Bitmap bitmap0,bitmap1;
    private byte buff0[],buff1[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_forum_details);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init() {
        intent();
        commonPanelTitle.setText("帖子详情");
        name.setText(user_name);
        time.setText(release_time);
        contentText.setText(content_text);

        bitmap0 = BitmapFactory.decodeByteArray(buff0, 0, buff0.length);
        bitmap1 = BitmapFactory.decodeByteArray(buff1, 0, buff1.length);
        BitmapDrawable mBitmapDrawable0 = new BitmapDrawable(bitmap0);
        BitmapDrawable mBitmapDrawable1 = new BitmapDrawable(bitmap1);
        headPicture.setBackgroundDrawable(mBitmapDrawable0);
        contentPicture.setBackgroundDrawable(mBitmapDrawable1);
    }

    public void intent() {
        Intent intent_data = getIntent();
        if (intent_data != null) {
            user_name = intent_data.getStringExtra("user_name");
            release_time = intent_data.getStringExtra("release_time");
            content_text = intent_data.getStringExtra("content_text");
            buff0 = intent_data.getByteArrayExtra("head_picture");
            buff1 = intent_data.getByteArrayExtra("content_picture");

        }
    }
}
