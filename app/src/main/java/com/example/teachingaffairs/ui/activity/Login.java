package com.example.teachingaffairs.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.adapter.PowerAdapter;
import com.example.teachingaffairs.ui.utils.ShareHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 闫星位 on 2018/1/2.
 */

public class Login extends BaseActivity implements AdapterView.OnItemClickListener,View.OnClickListener{
    private TextView power;
    private Drawable drawable;
    private ListView listView;
    private List<Map<String,Object>> powerList;
    private PopupWindow popWin;
    private Boolean arrowhead_state = false;
    private CheckBox remember;
    private EditText user_name,user_password;
    private Button btn_login;
    private ShareHelper sh;
    private LinearLayout backg;
    private TextView username_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//去除标题栏
        setContentView(R.layout.login_activity);
        init();
        setPower();
    }
    public void init(){
        backg = (LinearLayout) findViewById(R.id.backg);
        power = (TextView) findViewById(R.id.power);
        user_name = (EditText) findViewById(R.id.user_name);
        user_password = (EditText) findViewById(R.id.user_password);
        username_title = (TextView) findViewById(R.id.username_title);
        remember = (CheckBox) findViewById(R.id.remember);

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);

        powerList = getData();
        inilistView();
        sh = new ShareHelper(this);
        readdata();
        usernameTitle();
    }
    public void setPower(){
        power.setOnClickListener(this);
        backg.setOnClickListener(this);
    }

    public List<Map<String,Object>> getData(){
        String numpower[] = {"教师","学生","管理员"};
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map;
        for(int i = 0; i<3;i++){
            map = new HashMap<>();
            map.put("power",numpower[i]);
            list.add(map);
        }
        return list;
    }

    private void inilistView(){
        listView = new ListView(this);
        //设置listView的背景
        listView.setBackgroundColor(Color.WHITE);
        //设置条目之间的分割线及滚动条不可见
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setVerticalScrollBarEnabled(false);
        listView.setFooterDividersEnabled(true);
        //设置适配器
        PowerAdapter powerAdapter = new PowerAdapter(this,powerList);
        listView.setAdapter(powerAdapter);
        listView.setOnItemClickListener(this);
    }

    //定义一个popupWindow
    private void  popuwindow(){
        popWin=new PopupWindow(Login.this);
        popWin.setWidth(power.getWidth()-40);//设置宽度 和编辑框的宽度相同
        popWin.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT); //设置高度;
        popWin.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_shape_power));
        popWin.setAnimationStyle(R.style.popupAnimation);
        //为popWin填充内容
        popWin.setContentView(listView);
        /**
         * 设置弹出窗口显示的位置
         * 参数一:相对于参数的位置进行显示 即在编辑框的下面显示
         * 参数二 三:x y轴的偏移量
         */
        popWin.showAsDropDown(power, 0 , 15);
    }

    /**
     * 权限框下拉popuwindow里面的ListView点击事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = (String) ((TextView)view.findViewById(R.id.power)).getText();
        power.setText(text);
        popWin.dismiss();
        drawable = getResources().getDrawable(R.mipmap.down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        power.setCompoundDrawables(null,null,drawable,null);
        arrowhead_state = false;
        usernameTitle();
    }

    /**
     * 权限框箭头向下
     */
    public void down(){
        drawable = getResources().getDrawable(R.mipmap.down);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        power.setCompoundDrawables(null,null,drawable,null);
        arrowhead_state = false;
        popWin.dismiss();
    }
    /**
     * 权限框箭头向上
     */
    public void up(){
        drawable = getResources().getDrawable(R.mipmap.up);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        power.setCompoundDrawables(null,null,drawable,null);
        arrowhead_state = true;
        popuwindow();
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.btn_login:
                if(remember.isChecked()){
                    sh.save(user_name.getText().toString(),user_password.getText().toString());
                }else{
                    sh.save_name(user_name.getText().toString());
                }
                sh.save_power(power.getText().toString());
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("power",power.getText().toString());
                startActivity(intent);
                finish();
                break;
            case R.id.power:
                if(arrowhead_state == false) {
                    up();
                }else{
                    down();
                }
                break;
            case R.id.backg:
                if(arrowhead_state == true){
                    down();
                }
                break;
            default:
                break;
        }
    }
    public void readdata(){
        Map<String,String> data = sh.read();
        String pasw = data.put("password","");
        String name = data.put("username","");
        String powerdata = data.put("power","");
        if(!pasw.equals("")){
            user_name.setText(name);
            user_password.setText(pasw);
            remember.setChecked(true);
        }else{
            user_name.setText(name);
            remember.setChecked(false);
        }
        if(!powerdata.equals("")){
            power.setText(powerdata);
        }
    }

    public void usernameTitle(){
        String power_text = power.getText().toString().trim();
        if(power_text.equals("教师")){
            username_title.setText("工号");
            user_name.setHint("请输入工号");
        }else if(power_text.equals("学生")){
            username_title.setText("学号");
            user_name.setHint("请输入学号");
        }else{
            username_title.setText("账号");
            user_name.setHint("请输入账号");
        }
    }

}
