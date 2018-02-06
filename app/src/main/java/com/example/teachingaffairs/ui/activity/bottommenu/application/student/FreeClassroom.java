package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter.ApplicationStudentPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.view.IApplicationStudentView;
import com.example.teachingaffairs.ui.adapter.FreeClassroomAdapter;
import com.example.teachingaffairs.ui.adapter.FreeClassroomPopuAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by 闫星位 on 2018/1/26.
 * 空闲教室
 */

public class FreeClassroom extends BaseActivity implements View.OnClickListener,IApplicationStudentView {
    //整个布局（除了顶部标题），用于popupwindow外部点击可关闭功能的实现
    private LinearLayout linearLayout_bg;
    //顶部标题栏
    private TextView panel_title;
    /**
     * select_campus 选校区
     * current_time 当前时间
     * select_what 学节次
     * select_btn 查询按钮
     */
    private TextView select_campus,current_time,select_what,select_btn;
    // 声明没有教室信息或者是刚进去显示的页面
    private TextView list_null;
    //声明查询到空教室信息后用于显示的容器
    private GridView gridView;
    //popupwindow,用于显示校区
    private PopupWindow popupWindows;
    //声明popupwindow布局里面的ListView
    private ListView popupListView;
    //popupwindow打开或关闭的状态(初始值为关闭)
    private Boolean popupState = false;
    //AlertDialog，用于显示节次
    private AlertDialog alertDialog;
    //声明AlertDialog布局里面的listView
    private ListView DialogListView;
    //AlertDialog打开或关闭的状态(初始值为关闭)
    private Boolean alertdState = false;

    private LayoutInflater inflater;
    private View view;
    private Window window;

    private ApplicationStudentPresenter mApplicationPresenter;
    private List<ApplicationStudentBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_free_classroom);
        GoBack();
        init();
    }
    //初始化各个控件、组件
    private void init(){
        linearLayout_bg = (LinearLayout) findViewById(R.id.linearlayout_bg);
        panel_title = (TextView) findViewById(R.id.common_panel_title);
        panel_title.setText("空闲教室");
        select_campus = (TextView) findViewById(R.id.select_campus);
        current_time = (TextView) findViewById(R.id.current_time);
        current_time.setText(getTime());
        select_what = (TextView) findViewById(R.id.select_what);
        select_btn = (TextView) findViewById(R.id.select_btn);
        list_null = (TextView) findViewById(R.id.list_null);
        gridView = (GridView) findViewById(R.id.gridView);

        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.app_app_free_popu_list,null);

        //注册监听事件
        select_campus.setOnClickListener(this);
        select_what.setOnClickListener(this);
        select_btn.setOnClickListener(this);

        mApplicationPresenter = new ApplicationStudentPresenter(this);
    }



    /**
     * 点击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.select_campus:
                setPopupState();
                break;
            case R.id.select_what:
                setAlertdState();
                break;
            case R.id.select_btn:
                mApplicationPresenter.getType("空闲教室");
                mApplicationPresenter.bindmv();
                if(data.isEmpty()){
                    list_null.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.GONE);
                    list_null.setText("当前没有空闲教室");
                }else{
                    list_null.setVisibility(View.GONE);
                    gridView.setVisibility(View.VISIBLE);
                    gridView.setAdapter(new FreeClassroomAdapter(this,data));
                }
                break;
        }
    }
    @Override
    public void showdata(List<ApplicationStudentBean> data) {
        this.data = data;
    }
    /**
     * 判断popupwindow打开或者关闭
     */
    private void setPopupState(){
        if(popupState == false){
            setPopupWindows();
            popupState = true;
        }else{
            popupWindows.dismiss();
            popupState = false;
        }
    }

    /**
     * 创建一个popupwindow用于显示校区
     */
    private void setPopupWindows(){
        popupWindows = new PopupWindow();
        popupWindows.setOutsideTouchable(false);
        popupWindows.setWidth(select_campus.getWidth());
        popupWindows.setHeight(250);
        popupWindows.setContentView(view);
        popupWindows.setAnimationStyle(R.style.popupAnimation);
        popupWindows.showAsDropDown(select_campus,0,-10);
        closepopupOutside();
        setPopupListView();
    }
    /**
     * popupwindow在外部可关闭
     */
    private void closepopupOutside(){
        linearLayout_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindows.dismiss();
                popupState = false;
            }
        });
    }
    /**
     * popupwindows里面显示的数据
     */
    private ArrayList<HashMap<String,Object>> getpopupdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String,Object> data;
        String campus[] = {"老校区","新校区","财经校区","医学校区"};
        for(int i = 0 ; i < campus.length ; i++){
            data = new HashMap<>();
            data.put("campus",campus[i]);
            datalist.add(data);
        }
        return datalist;
    }
    private void setPopupListView(){
        popupListView = (ListView) view.findViewById(R.id.populist);
        popupListView.setAdapter(new FreeClassroomPopuAdapter(this,getpopupdata()));
        //popupListView点击事件
        popupListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView campus = (TextView) view.findViewById(R.id.campus);
                String campustxt;
                campustxt = campus.getText().toString();
                select_campus.setText(campustxt);
                popupWindows.dismiss();
                popupState = false;
            }
        });
    }
    /**
     * 判断AlertDialo打开或者关闭
     */
    private void setAlertdState(){
        if(alertdState == false){
            setAlertDialog();
            alertdState = true;
        }else{
            alertDialog.dismiss();
            alertdState = false;
        }
    }
    /**
     * 创建一个AlertDialog用于显示节次
     */
    private void setAlertDialog(){
        alertDialog = new AlertDialog.Builder(this,R.style.dialog_bg_transparent).create();
        alertDialog.show();
        window = alertDialog.getWindow();
        window.setContentView(R.layout.app_app_free_popu_list);
        Display d = getWindowManager().getDefaultDisplay();
        int x = (int) (d.getWidth() * (0.6));
        int y = (int) (250);
        alertDialog.getWindow().setLayout(x, y);
        alertDialog.setCanceledOnTouchOutside(false);
        setAlertDListView();
    }

    /**
     * AlertDialog里面显示的数据
     */
    private ArrayList<HashMap<String,Object>> getalertDdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String,Object> data;
        String what[] = {"1-2","3-4","5-7","8-9"};
        for(int i = 0 ; i < what.length ; i++){
            data = new HashMap<>();
            data.put("campus",what[i]);
            datalist.add(data);
        }
        return datalist;
    }
    private void setAlertDListView(){
        DialogListView = (ListView) window.findViewById(R.id.populist);
        DialogListView.setAdapter(new FreeClassroomPopuAdapter(this,getalertDdata()));
        //popupListView点击事件
        DialogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView what = (TextView) view.findViewById(R.id.campus);
                String whattxt;
                whattxt = what.getText().toString();
                select_what.setText(whattxt);
                alertDialog.dismiss();
                alertdState = false;
            }
        });
    }
    //获得当前年月日星期
    public String getTime(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if("1".equals(mWay)){
            mWay ="天";
        }else if("2".equals(mWay)){
            mWay ="一";
        }else if("3".equals(mWay)){
            mWay ="二";
        }else if("4".equals(mWay)){
            mWay ="三";
        }else if("5".equals(mWay)){
            mWay ="四";
        }else if("6".equals(mWay)){
            mWay ="五";
        }else if("7".equals(mWay)){
            mWay ="六";
        }
        return mYear + "-" + mMonth + "-" + mDay+" "+"星期"+mWay;
    }

    @Override
    public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {}
}
