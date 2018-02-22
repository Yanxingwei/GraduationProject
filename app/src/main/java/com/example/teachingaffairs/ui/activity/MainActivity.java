package com.example.teachingaffairs.ui.activity;

import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.Address_Books;
import com.example.teachingaffairs.ui.activity.bottommenu.application.Application;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.Forum;
import com.example.teachingaffairs.ui.activity.bottommenu.forumactivity.ForumRelease;
import com.example.teachingaffairs.ui.activity.bottommenu.notice.Notice;
import com.example.teachingaffairs.ui.activity.bottommenu.release.Release;
import com.example.teachingaffairs.ui.activity.leftmenu.AboutUs;
import com.example.teachingaffairs.ui.activity.leftmenu.ChangePassword;
import com.example.teachingaffairs.ui.activity.leftmenu.MessageFeedBack;
import com.example.teachingaffairs.ui.activity.leftmenu.OnlineService;
import com.example.teachingaffairs.ui.activity.leftmenu.PersonalInformation;
import com.example.teachingaffairs.ui.components.SlidingMenu;
import com.example.teachingaffairs.ui.utils.ShareHelper;

import java.util.Map;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private RadioGroup radioGroup;
    private TabHost mTabHost;
    private RadioButton rb_notice,rb_forum,rb_application,
            rb_release,rb_address_books;
    private LocalActivityManager mlocalActivityManager;
    private SlidingMenu index_background;//侧滑菜单背景
    private ImageView sliding_menu;//顶部小头像
    /**
     * 侧滑菜单界面的一些常量定义
     */
    private LinearLayout Personal_Information;//个人信息
    private LinearLayout About_Us;//关于我们
    private LinearLayout Change_Password;//修改密码
    private LinearLayout Online_Service;//在线服务
    private LinearLayout Sign_Out;//退出登录
    private LinearLayout Message_Feed_Back;//信息反馈
    private TextView Sinature;//个人签名
    private AlertDialog alertDialog;
    private AlertDialog alertDialog1;

    private TextView add_icon;//新建
    private String value;

    private ShareHelper sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//去除标题栏
        setContentView(R.layout.index_activity);
        sh = new ShareHelper(this);
        mlocalActivityManager = new LocalActivityManager(this, true);
        mlocalActivityManager.dispatchCreate(savedInstanceState);
        init();
    }
    public void init(){
        tabhostinit();
        setSlidingMenuBg();
        releaseform();
    }
    public void tabhostinit() {
        rb_notice = (RadioButton) findViewById(R.id.rb_notice);
        rb_forum = (RadioButton) findViewById(R.id.rb_forum);
        rb_application = (RadioButton) findViewById(R.id.rb_application);
        rb_release = (RadioButton) findViewById(R.id.rb_release);
        rb_address_books = (RadioButton) findViewById(R.id.rb_address_books);
        intent();
        radioGroup = (RadioGroup) findViewById(R.id.rb_group);
        mTabHost = (TabHost) findViewById(R.id.tabHost);
        mTabHost.setup(mlocalActivityManager);
        TabHost.TabSpec tabSpec;
        tabSpec = mTabHost.newTabSpec("教务").setIndicator("教务").setContent(new Intent(this,Notice.class));
        mTabHost.addTab(tabSpec);
        tabSpec = mTabHost.newTabSpec("论坛").setIndicator("论坛").setContent(new Intent(this,Forum.class));
        mTabHost.addTab(tabSpec);
        Intent intent = new Intent(this,Application.class);
        intent.putExtra("power",value);
        tabSpec = mTabHost.newTabSpec("应用").setIndicator("应用").setContent(intent);
        mTabHost.addTab(tabSpec);
        tabSpec = mTabHost.newTabSpec("发布").setIndicator("发布").setContent(new Intent(this,Release.class));
        mTabHost.addTab(tabSpec);
        tabSpec = mTabHost.newTabSpec("通讯录").setIndicator("通讯录").setContent(new Intent(this,Address_Books.class));
        mTabHost.addTab(tabSpec);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_notice:
                        mTabHost.setCurrentTabByTag("教务");
                        add_icon.setVisibility(View.GONE);
                        break;
                    case R.id.rb_forum:
                        mTabHost.setCurrentTabByTag("论坛");
                        add_icon.setVisibility(View.VISIBLE);
                        break;
                    case R.id.rb_application:
                        mTabHost.setCurrentTabByTag("应用");
                        add_icon.setVisibility(View.GONE);
                        break;
                    case R.id.rb_release:
                        mTabHost.setCurrentTabByTag("发布");
                        add_icon.setVisibility(View.GONE);
                        break;
                    case R.id.rb_address_books:
                        mTabHost.setCurrentTabByTag("通讯录");
                        add_icon.setVisibility(View.GONE);
                        break;
                    default:
                        break;
                }
            }
        });
        setMenuListener();
    }

    //根据不同的权限初始化主页面底部菜单栏
    public void intent(){
        Intent intent_data = getIntent();
        if(intent_data !=null){
            value = intent_data.getStringExtra("power");
            if(value.equals("管理员")){
                rb_notice.setVisibility(View.VISIBLE);
                rb_address_books.setVisibility(View.VISIBLE);
                rb_release.setVisibility(View.VISIBLE);
                rb_forum.setVisibility(View.GONE);
                rb_application.setVisibility(View.GONE);
            }else if(value.equals("教师")){
                rb_notice.setVisibility(View.VISIBLE);
                rb_address_books.setVisibility(View.VISIBLE);
                rb_forum.setVisibility(View.VISIBLE);
                rb_application.setVisibility(View.VISIBLE);
                rb_release.setVisibility(View.GONE);
            }else if(value.equals("学生")){
                rb_notice.setVisibility(View.VISIBLE);
                rb_forum.setVisibility(View.VISIBLE);
                rb_application.setVisibility(View.VISIBLE);
                rb_address_books.setVisibility(View.VISIBLE);
                rb_release.setVisibility(View.GONE);
            }
        }
    }
    /**
     * 设置侧滑菜单的背景
     */
    public void setSlidingMenuBg(){
        index_background = (SlidingMenu) findViewById(R.id.index_background);
        index_background.setBackgroundResource(R.mipmap.left_night);
        slidingMenuState();
    }
    /**
     * 判断侧滑菜单打开或关闭的状态
     */
    public void slidingMenuState(){
        sliding_menu = (ImageView) findViewById(R.id.sliding_menu);
        sliding_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index_background != null){
                    index_background.toggle();
                }
            }
        });
    }

    /**
     * 注册菜单监听事件
     */
    public void setMenuListener(){
        Personal_Information = (LinearLayout) findViewById(R.id.per_message);
        About_Us = (LinearLayout) findViewById(R.id.about_us);
        Change_Password = (LinearLayout) findViewById(R.id.change_password);
        Online_Service = (LinearLayout) findViewById(R.id.online_service);
        Sign_Out = (LinearLayout) findViewById(R.id.sign_out);
        Message_Feed_Back = (LinearLayout) findViewById(R.id.message_feed_back);
        Sinature = (TextView) findViewById(R.id.signature);

        Personal_Information.setOnClickListener(this);
        About_Us.setOnClickListener(this);
        Change_Password.setOnClickListener(this);
        Online_Service.setOnClickListener(this);
        Sign_Out.setOnClickListener(this);
        Message_Feed_Back.setOnClickListener(this);
        Sinature.setOnClickListener(this);
//        Sinature.setText("hahaha");
        readdata();
    }

    public void readdata(){
        Map<String,String> naturedata = sh.read_sinature();
        String sinature = naturedata.put("naturedata","");
        if (!TextUtils.isEmpty(sinature)){
            Sinature.setText(sinature);
        }
    }

    /**
     * 菜单监听事件
     */
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signature:
                alertDialog1 = new AlertDialog.Builder(this,R.style.dialog_bg_transparent).create();
                Window window = alertDialog1.getWindow();
                alertDialog1.show();
                window.setContentView(R.layout.signature_alertdialog);
                Display d = getWindowManager().getDefaultDisplay();
                int x = (int) (d.getWidth() * 0.8);
                int y = (int) (d.getHeight() * 0.3);
                alertDialog1.getWindow().setLayout(x, y);
                TextView tv1,tv2;
                final EditText signature_data;
                tv1 = window.findViewById(R.id.tv1);
                tv2 = window.findViewById(R.id.tv2);
                signature_data = window.findViewById(R.id.signature_data);
                tv1.setOnClickListener(new View.OnClickListener() {
                     @Override
                    public void onClick(View v) {
                        alertDialog1.dismiss();
                        sh.save_sinature(signature_data.getText().toString());
                        Toast.makeText(MainActivity.this,"已保存",Toast.LENGTH_SHORT).show();
                         readdata();
                    }
                });
                tv2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog1.dismiss();
                    }
                });
                break;
            case R.id.per_message:
                startActivity(new Intent(this, PersonalInformation.class));
                break;
            case R.id.change_password:
                startActivity(new Intent(this, ChangePassword.class));
                break;
            case R.id.online_service:
                startActivity(new Intent(this, OnlineService.class));
                break;
            case R.id.message_feed_back:
                startActivity(new Intent(this, MessageFeedBack.class));
                break;
            case R.id.about_us:
                startActivity(new Intent(this, AboutUs.class));
                break;
            case R.id.sign_out:
                alertDialog = (AlertDialog) new TipDialog(MainActivity.this, 0.8, 0.15, "您确定要退出系统吗?",
                        null, null, quitListener,cancelListener).getInstance();
                break;
        }
    }
    /**
     * 是否退出系统，确定键的监听事件
     */
    private View.OnClickListener quitListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.exit(0);
        }
    };
    private View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alertDialog.dismiss();
        }
    };
    /**
     * 对硬件返回键的监听事件
     * @param event
     * @return
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0) {
            alertDialog = (AlertDialog) new TipDialog(MainActivity.this, 0.8, 0.15, "您确定要退出系统吗?",
                    null, null, quitListener,cancelListener).getInstance();
        }
        return super.dispatchKeyEvent(event);
    }
    /**
     * 新建帖子的功能
     */
    private void releaseform(){
        add_icon = (TextView) findViewById(R.id.add_icon);
        add_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForumRelease.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
            }
        });
    }
}