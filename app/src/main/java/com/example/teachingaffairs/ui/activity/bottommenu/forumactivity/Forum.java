package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.bean.ForumBean;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.presenter.ForumPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.view.IForumView;
import com.example.teachingaffairs.ui.adapter.ForumAdapter;

import java.io.ByteArrayOutputStream;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/1/5.
 */

public class Forum extends BaseActivity implements IForumView {

    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.no_data)
    TextView noData;
    @Bind(R.id.common_tip_nodata)
    LinearLayout commonTipNodata;
    private ForumPresenter mforumPresenter;
    private List<ForumBean> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_forum);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mforumPresenter = new ForumPresenter(this);
        mforumPresenter.setJudge_data("帖子列表");
        mforumPresenter.bindmv();
        Listener();
    }

    @Override
    public void showdata(List<ForumBean> data) {
        if (data.isEmpty()) {
            commonTipNodata.setVisibility(View.VISIBLE);
            listview.setVisibility(View.GONE);
            noData.setText("暂无数据");
        } else {
            commonTipNodata.setVisibility(View.GONE);
            listview.setVisibility(View.VISIBLE);
            listview.setAdapter(new ForumAdapter(this, data));
        }
        this.data = data;
    }

    private void Listener(){
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                byte buff0[] = new byte[125*250];
                byte buff1[] = new byte[125*250];
                Bitmap bitmap0,bitmap1;

                Intent intent = new Intent(Forum.this,ForumDetails.class);

                bitmap0 = BitmapFactory.decodeResource(getResources(), data.get(position).getHead_picture());
                bitmap1 = BitmapFactory.decodeResource(getResources(), data.get(position).getContent_picture());
                buff0 = BitmapBytes(bitmap0);
                buff1 = BitmapBytes(bitmap1);

                intent.putExtra("head_picture",buff0);
                intent.putExtra("content_picture",buff1);
                intent.putExtra("user_name",data.get(position).getUser_name());
                intent.putExtra("release_time",data.get(position).getRelease_time());
                intent.putExtra("content_text",data.get(position).getContent_text());
                startActivity(intent);
            }
        });
    }

    private byte[] BitmapBytes(Bitmap bm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        return baos.toByteArray();
    }
}
