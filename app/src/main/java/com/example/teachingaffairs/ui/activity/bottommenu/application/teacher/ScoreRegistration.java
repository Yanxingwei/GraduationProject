package com.example.teachingaffairs.ui.activity.bottommenu.application.teacher;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.SearchData;
import com.example.teachingaffairs.ui.adapter.SearchAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 闫星位 on 2018/2/6.
 * 成绩录入页面
 */

public class ScoreRegistration extends BaseActivity {

    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.the_class)
    EditText theClass;
    @Bind(R.id.course_name)
    EditText courseName;
    @Bind(R.id.experimental_results)
    EditText experimentalResults;
    @Bind(R.id.grades)
    EditText grades;
    @Bind(R.id.midterm_grades)
    EditText midtermGrades;
    @Bind(R.id.final_result)
    EditText finalResult;
    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.linearlayout_bg)
    LinearLayout linearLayout_bg;
    private PopupWindow popupWindows;
    private LayoutInflater inflater;
    private View view;
    private Boolean popupState = false;
    private ListView popupListView;

    private String[] mItemsClass = {"2014级信息工程班", "2014级通信工程班", "2014级资源勘查班","2014级交通运输班","2014级土木工程班","2014级公共事业管理班"};

    private String[] mItemsName = {"大学语文", "高等数学", "大学英语","大学物理","体育","模拟电路"};

    private List<SearchData> mDataClass;//模糊查找的时候返回的数据
    private List<SearchData> mDataName;//模糊查找的时候返回的数据
    private SearchAdapter mSearchAdapter;//ListView的适配

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_score_registration);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        commonPanelTitle.setText("成绩录入");
        ListenerNext();
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.app_app_free_popu_list,null);
        popupListView = view.findViewById(R.id.populist);
        theClassListener();
        courseNameLisenter();
    }

    private void theClassListener(){
        //给EditText添加搜索栏控件文本变化监听器
        theClass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                searchClass();//文本输入发生变化时开始进行模糊查找
            }
        });
        createSearchClass();
    }

    private void courseNameLisenter(){
        courseName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                searchName();//文本输入发生变化时开始进行模糊查找
            }
        });
        createSearchName();

    }

    //创建数据库,并给数据库添加数据
    private void createSearchClass() {
        //打开或创建search.db数据库
        SQLiteDatabase db = openOrCreateDatabase("searchclass.db", Context.MODE_PRIVATE, null);
        //在数据库中创建mydata表，如果该表存在，则先删除后再创建,该表有两个字段，一个是id，一个是姓名（name）
        db.execSQL("DROP TABLE IF EXISTS mydata");
        db.execSQL("CREATE TABLE mydata (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");
        //给数据库插入数据
        int len = mItemsClass.length;
        for (int i = 0; i < len; i++) {
            ContentValues cv = new ContentValues();
            cv.put("name", mItemsClass[i]);
            db.insert("mydata", null, cv);
        }
    }

    //创建数据库,并给数据库添加数据
    private void createSearchName() {
        //打开或创建search.db数据库
        SQLiteDatabase db = openOrCreateDatabase("searchname.db", Context.MODE_PRIVATE, null);
        //在数据库中创建mydata表，如果该表存在，则先删除后再创建,该表有两个字段，一个是id，一个是姓名（name）
        db.execSQL("DROP TABLE IF EXISTS mydata");
        db.execSQL("CREATE TABLE mydata (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR)");
        //给数据库插入数据
        int len = mItemsName.length;
        for (int i = 0; i < len; i++) {
            ContentValues cv = new ContentValues();
            cv.put("name", mItemsName[i]);
            db.insert("mydata", null, cv);
        }
    }

    //theClass搜索栏文本变化时开始进行模糊查找
    private void searchClass() {
        String temp = theClass.getText().toString().trim();
        mDataClass = new ArrayList<>();
        if (!temp.equals("")) {
            SQLiteDatabase db_search = openOrCreateDatabase("searchclass.db", Context.MODE_PRIVATE, null);
            Cursor csearch = db_search.rawQuery("SELECT * FROM mydata WHERE name LIKE '%" + temp + "%'", null);
            while (csearch.moveToNext()) {
                String name = csearch.getString(csearch.getColumnIndex("name"));
                SearchData data = new SearchData();
                data.setName(name);
                mDataClass.add(data);
            }
            db_search.close();
            csearch.close();
        }
        if(popupState == false){
            popupwindows();
            mSearchAdapter = new SearchAdapter(this, mDataClass);
            popupListView.setAdapter(mSearchAdapter);
            popupWindows.showAsDropDown(theClass,0,0);
            popupState = true;

            popupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView theclass;
                    theclass = (TextView) view.findViewById(R.id.name);
                    String class_text;
                    class_text = theclass.getText().toString().trim();
                    theClass.setText(class_text);
                    popupWindows.dismiss();
                    popupState = true;
                }
            });

        } else {
            mSearchAdapter.refreshData(mDataClass);
            if(mDataClass.size() == 0 && popupState == true){
                popupWindows.dismiss();
                popupState = false;
            }
        }
    }

    //courseName搜索栏文本变化时开始进行模糊查找
    private void searchName() {
        String temp = courseName.getText().toString().trim();
        mDataName = new ArrayList<>();
        if (!temp.equals("")) {
            SQLiteDatabase db_search = openOrCreateDatabase("searchname.db", Context.MODE_PRIVATE, null);
            Cursor csearch = db_search.rawQuery("SELECT * FROM mydata WHERE name LIKE '%" + temp + "%'", null);
            while (csearch.moveToNext()) {
                String name = csearch.getString(csearch.getColumnIndex("name"));
                SearchData data = new SearchData();
                data.setName(name);
                mDataName.add(data);
            }
            db_search.close();
            csearch.close();
        }
        if(popupState == false){
            popupwindows();
            mSearchAdapter = new SearchAdapter(this, mDataName);
            popupListView.setAdapter(mSearchAdapter);
            popupWindows.showAsDropDown(courseName,0,0);
            popupState = true;

            popupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView name;
                    name = (TextView) view.findViewById(R.id.name);
                    String name_text;
                    name_text = name.getText().toString().trim();
                    courseName.setText(name_text);
                    popupWindows.dismiss();
                    popupState = true;
                }
            });

        }else {
            mSearchAdapter.refreshData(mDataName);
            if(mDataName.size() == 0 && popupState == true){
                popupWindows.dismiss();
                popupState = false;
            }
        }
    }

    /**
     * popupwindow弹窗，用于显示检索到的数据
     */
    private void popupwindows(){
        popupWindows = new PopupWindow();
        popupWindows.setOutsideTouchable(false);
        popupWindows.setAnimationStyle(R.style.popupAnimation);
        popupWindows.setBackgroundDrawable(new BitmapDrawable());
        popupWindows.setWidth(theClass.getWidth());
        popupWindows.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindows.setContentView(view);
        closePopupOutside();
    }

    /**
     * 写一个可在外部点击关闭popupwindow的方法
     */
    private void closePopupOutside(){
        linearLayout_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindows.dismiss();
                popupState = false;
            }
        });
    }

    /**
     * 下一步监听事件
     */
    private void ListenerNext() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1,number2,number3,number4;
                number1 = Integer.parseInt(experimentalResults.getText().toString());
                number2 = Integer.parseInt(grades.getText().toString());
                number3 = Integer.parseInt(midtermGrades.getText().toString());
                number4 = Integer.parseInt(finalResult.getText().toString());
                if(number1+number2+number3+number4 == 100){
                    Toast.makeText(ScoreRegistration.this,"hahaha",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ScoreRegistration.this,"比例设置不合适",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
