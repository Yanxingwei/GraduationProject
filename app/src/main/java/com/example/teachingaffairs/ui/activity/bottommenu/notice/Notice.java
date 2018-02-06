package com.example.teachingaffairs.ui.activity.bottommenu.notice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.bean.NoticeBean;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.presenter.NoticePresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.view.INoticeView;
import com.example.teachingaffairs.ui.adapter.NoticeAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/15.
 */

public class Notice extends BaseActivity implements INoticeView{
    private ListView listView;
    private NoticePresenter mNoticePresenter;
    private List<NoticeBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_notice);
        init();
    }

    private void init(){
        listView = (ListView) findViewById(R.id.listview);
        mNoticePresenter = new NoticePresenter(this);
        mNoticePresenter.bindmv();
        Listener();
    }
    @Override
    public void showdata(List<NoticeBean> data) {
        listView.setAdapter(new NoticeAdapter(this,data));
        this.data = data;
    }
    private void Listener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Notice.this,NoticeDetails.class);
                String type = data.get(position).getType();
                String notice_title = data.get(position).getNotice_title();
                String notice_source = data.get(position).getNotice_source();
                String notice_time = data.get(position).getOldertime();
                String notice_content = data.get(position).getNotice_content();
                intent.putExtra("notice_type",type);
                intent.putExtra("notice_title",notice_title);
                intent.putExtra("notice_source",notice_source);
                intent.putExtra("notice_time",notice_time);
                intent.putExtra("notice_content",notice_content);
                startActivity(intent);
            }
        });
    }
}
