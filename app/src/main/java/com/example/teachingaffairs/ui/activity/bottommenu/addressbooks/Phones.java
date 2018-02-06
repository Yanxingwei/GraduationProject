package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean.BooksBean;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.presenter.BooksPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.view.IBooksView;
import com.example.teachingaffairs.ui.adapter.DepertmentAdapter;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/19.
 */

public class Phones extends BaseActivity implements IBooksView {
    private TextView panel_title;
    private ListView listView;
    private BooksPresenter mBooksP;
    private TextView college_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_deparentment_page);
        GoBack();
        init();
    }

    private void init() {
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        listView = (ListView) findViewById(R.id.listView);
        mBooksP = new BooksPresenter(this);
        mBooksP.getcollege(collegedata());
        mBooksP.bindmv();
        Listener();

    }

    private String collegedata() {
        String college;
        Intent intent_data = getIntent();
        college = intent_data.getStringExtra("name");
        return college;
    }

    @Override
    public void showdata(List<BooksBean> data) {
        listView.setAdapter(new DepertmentAdapter(this, data));
    }

    @Override
    public void showtitle(String title) {
        panel_title.setText(title);
    }

    public void Listener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                college_number = (TextView) view.findViewById(R.id.college_number);
                Intent intent = new Intent(Intent.ACTION_CALL);
                String tell = college_number.getText().toString();
                Uri data = Uri.parse("tel:" + tell);
                intent.setData(data);
                if (ActivityCompat.checkSelfPermission(Phones.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }
}
