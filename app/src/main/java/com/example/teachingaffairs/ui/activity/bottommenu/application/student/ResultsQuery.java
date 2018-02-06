package com.example.teachingaffairs.ui.activity.bottommenu.application.student;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.bean.ApplicationStudentBean;
import com.example.teachingaffairs.ui.activity.bottommenu.application.student.presenter.ApplicationStudentPresenter;
import com.example.teachingaffairs.ui.activity.bottommenu.application.view.IApplicationView;
import com.example.teachingaffairs.ui.adapter.ResultsQueryAdapter;
import com.example.teachingaffairs.ui.adapter.ResultsQueryPopupAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 闫星位 on 2018/1/25.
 * 成绩查询
 */

public class ResultsQuery extends BaseActivity implements View.OnClickListener,IApplicationView {

    @Bind(R.id.common_panel_title)
    TextView commonPanelTitle;
    @Bind(R.id.time_year)
    TextView timeYear;
    @Bind(R.id.time_season)
    TextView timeSeason;
    @Bind(R.id.btn_select)
    TextView btnSelect;
    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.no_data)
    TextView noData;
    @Bind(R.id.listview)
    ListView listview;
    @Bind(R.id.linearlayout_bg)
    LinearLayout linearlayoutBg;
    //声明两个popupwindow用于显示年份和季节
    private PopupWindow popuptimeYear, popuptimeSeason;
    //声明两个Boolean值，用于表示popupwindow打开或者关闭的状态
    private Boolean popuptYstate = false, popuptSstate = false;
    private LayoutInflater inflater;
    private View view;
    private ListView popuplistview;
    private ApplicationStudentPresenter mApplicationPresenter;
    //获取的成绩信息
    private List<ApplicationStudentBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_app_results_query);
        ButterKnife.bind(this);
        GoBack();
        init();
    }

    private void init() {
        commonPanelTitle.setText("成绩查询");
        timeYear.setOnClickListener(this);
        inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.app_app_results_query_popup,null);
        popuplistview = (ListView) view.findViewById(R.id.listview);
        mApplicationPresenter = new ApplicationStudentPresenter(this);
    }

    @Override
    @OnClick({R.id.time_year, R.id.time_season, R.id.btn_select})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.time_year:
                judgePWyear();
                break;
            case R.id.time_season:
                judgePWseason();
                break;
            case R.id.btn_select:
                changeTitle();
                mApplicationPresenter.getType("成绩查询");
                mApplicationPresenter.bindmv();
                if(data.isEmpty()){
                    No_data();
                }
                else{
                    listview.setVisibility(View.VISIBLE);
                    noData.setVisibility(View.GONE);
                    listview.setAdapter(new ResultsQueryAdapter(this,data));
                }
                break;
        }
    }

    /**
     * 判断选择年份的popupwindow是否打开
     */
    private void judgePWyear(){
        if(popuptYstate == false){
            popuptimeYear();
            popuptYstate = true;
        }else{
            popuptimeYear.dismiss();
            popuptYstate = false;
        }
    }
    /**
     * 选择年份的popupwindow
     */
    private void popuptimeYear() {
        popuptimeYear = new PopupWindow();
        popuptimeYear.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popuptimeYear.setWidth(timeYear.getWidth());
        popuptimeYear.setBackgroundDrawable(new BitmapDrawable());
        popuptimeYear.setOutsideTouchable(false);
        popuptimeYear.setContentView(view);
        popuptimeYear.setAnimationStyle(R.style.popupAnimation);
        popuptimeYear.showAsDropDown(timeYear,0,0);
        closePWTYOutside();
        setTYlistView();
    }

    /**
     * 判断选择季节的popupwindow是否打开
     */
    private void judgePWseason(){
        if(popuptSstate == false){
            popuptimeSeason();
            popuptSstate = true;
        }else{
            popuptimeSeason.dismiss();
            popuptSstate = false;
        }
    }
    /**
     * 选择季节的popupwindow
     */
    private void popuptimeSeason() {
        popuptimeSeason = new PopupWindow();
        popuptimeSeason.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        popuptimeSeason.setWidth(timeYear.getWidth());
        popuptimeSeason.setBackgroundDrawable(new BitmapDrawable());
        popuptimeSeason.setOutsideTouchable(false);
        popuptimeSeason.setContentView(view);
        popuptimeSeason.setAnimationStyle(R.style.popupAnimation);
        popuptimeSeason.showAsDropDown(timeSeason,0,0);
        closePWTSOutside();
        setTSlistView();
    }
    /**
     * 写一个方法，用于在外部点击关闭popupwindow
     */
    private void closePWTYOutside(){
        linearlayoutBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popuptYstate == true){
                    popuptimeYear.dismiss();
                    popuptYstate = false;
                }
            }
        });
    }
    private void closePWTSOutside(){
        linearlayoutBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(popuptSstate == true){
                    popuptimeSeason.dismiss();
                    popuptSstate = false;
                }
            }
        });
    }

    /**
     * ListView里面需要的数据
     */
    private ArrayList<HashMap<String,Object>> getTYdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String,Object> data;
        String date[] = {"全部","2014","2015","2016","2017","2018"};
        for(int i = 0 ; i < date.length ; i ++){
            data = new HashMap<>();
            data.put("date",date[i]);
            datalist.add(data);
        }
        return datalist;
    }
    private ArrayList<HashMap<String,Object>> getTSdata(){
        ArrayList<HashMap<String,Object>> datalist = new ArrayList<>();
        HashMap<String,Object> data;
        String date[] = {"夏季","冬季"};
        for(int i = 0 ; i < date.length ; i ++){
            data = new HashMap<>();
            data.put("date",date[i]);
            datalist.add(data);
        }
        return datalist;
    }

    /**
     * 初始化ListView
     */
    private void setTYlistView(){
        ArrayList<HashMap<String,Object>> datalist = getTYdata();
        popuplistview.setAdapter(new ResultsQueryPopupAdapter(this,datalist));
        ListenerTY();
    }
    private void setTSlistView(){
        ArrayList<HashMap<String,Object>> datalist = getTSdata();
        popuplistview.setAdapter(new ResultsQueryPopupAdapter(this,datalist));
        ListenerTS();
    }

    /**
     * ListView Item 监听事件
     */
    private void ListenerTY(){
        popuplistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_data;
                tv_data = (TextView) view.findViewById(R.id.tv_data);
                String data;
                data = tv_data.getText().toString();
                timeYear.setText(data);
                popuptimeYear.dismiss();
                popuptYstate = false;
            }
        });
    }
    private void ListenerTS(){
        popuplistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv_data;
                tv_data = (TextView) view.findViewById(R.id.tv_data);
                String data;
                data = tv_data.getText().toString();
                timeSeason.setText(data);
                popuptimeSeason.dismiss();
                popuptSstate = false;
            }
        });
    }
    /**
     * 下面提示具体时间的TextView在选定后改变里面的内容
     */
    private void changeTitle(){
        String time_year,time_season;
        time_year = timeYear.getText().toString();
        time_season = timeSeason.getText().toString();
        if(time_year.equals("全部")){
            title.setText(time_year+"课程成绩");
        }else{
            title.setText(time_year+time_season+"课程成绩");
        }
    }

    @Override
    public void showdata(List<ApplicationStudentBean> data) {
        this.data = data;
    }

    @Override
    public void showELVdata(List<ApplicationStudentBean> datagroup, List<List<ApplicationStudentBean>> datachild) {}

    //成绩无数据时显示的页面
    private void No_data(){
        noData.setVisibility(View.VISIBLE);
        listview.setVisibility(View.GONE);
        noData.setText("无数据");
    }
}
