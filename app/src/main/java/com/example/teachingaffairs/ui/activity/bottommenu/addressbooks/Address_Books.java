package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.adapter.AddressBooksAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 闫星位 on 2018/1/5.
 */

public class Address_Books extends BaseActivity {
    private ListView listView;
    private ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_address_books);
        init();
    }
    private void init(){
        listView = (ListView) findViewById(R.id.listView);
        datalist = getdata();
        AddressBooksAdapter adapter = new AddressBooksAdapter(this,datalist);
        listView.setAdapter(adapter);
        Listener();
    }
    public ArrayList<HashMap<String,Object>> getdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String,Object> data;
        String name [] = {"文学院","理学院","工学院","医学院","艺术学院","经济与管理学院",
                "旅游与外语学院","政法学院","师范学院","财经学院","信息科学技术学院","教务处","学工处","招生就业处"};
        String number [] = {"(7)","(9)","(8)","(6)","(5)","(5)","(3)","(3)","(1)","(7)","(3)","(4)","(2)","(7)"};
        int college_logo [] ={R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,
                R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo,R.mipmap.logo};
        int college_go = R.mipmap.mine_more_arrow;

        for(int i = 0; i < name.length; i++){
            data = new HashMap<>();
            data.put("name",name[i]);
            data.put("number",number[i]);
            data.put("college_logo",college_logo[i]);
            data.put("college_go",college_go);
            datalist.add(data);
        }
        return datalist;
    }
    public void Listener(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView college_name;
                String name;
                college_name = (TextView) view.findViewById(R.id.college_name);
                name = college_name.getText().toString();
                Intent intent = new Intent(Address_Books.this,DepartmentPage.class);
                intent.putExtra("college_name",name);
                startActivity(intent);
            }
        });
    }
}
