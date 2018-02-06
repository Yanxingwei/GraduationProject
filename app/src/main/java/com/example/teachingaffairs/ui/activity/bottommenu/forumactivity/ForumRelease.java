package com.example.teachingaffairs.ui.activity.bottommenu.forumactivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.BaseActivity;
import com.example.teachingaffairs.ui.utils.ShareHelper;
import com.example.teachingaffairs.ui.utils.StringHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 闫星位 on 2018/1/15.
 */

public class ForumRelease extends BaseActivity implements View.OnClickListener{
    private TextView panel_title,add_icon;
    private ImageView sliding_menu,most;
    private EditText post_title,post_content;
    private TextView release_post,post_save,post_cancel;
    private ShareHelper sh;
    private String entertitle,entercontent;
    private AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_forum_release);
        init();
    }
    private void init(){
        sh = new ShareHelper(this);
        panel_title = (TextView) findViewById(R.id.index_panel_titla);
        add_icon = (TextView) findViewById(R.id.add_icon);
        sliding_menu = (ImageView) findViewById(R.id.sliding_menu);
        most = (ImageView) findViewById(R.id.most);

        post_title = (EditText) findViewById(R.id.post_title);
        post_content = (EditText) findViewById(R.id.post_content);
        release_post = (TextView) findViewById(R.id.release_post);
        post_save = (TextView) findViewById(R.id.post_save);
        post_cancel = (TextView) findViewById(R.id.post_cancel);

        panel_title.setText("新建帖子");
        add_icon.setVisibility(View.GONE);
        sliding_menu.setVisibility(View.GONE);
        most.setVisibility(View.GONE);

        read_oldpost();

        entertitle = post_title.getText().toString();
        entercontent = post_content.getText().toString();
        post_cancel.setOnClickListener(this);
        release_post.setOnClickListener(this);
        post_save.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.post_cancel:
                cencel();
                break;
            case R.id.release_post:
                releasepsot();
                break;
            case R.id.post_save:
                save_newpost();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK){
            finish();
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        }
        return super.onKeyDown(keyCode, event);
    }
    private void read_oldpost(){
        Map<String,String> data = new HashMap<String,String>();
        data = sh.read_releasepost();
        String oldtitle = data.put("title","");
        String oldcontent = data.put("content","");
        post_title.setText(oldtitle);
        post_content.setText(oldcontent);
    }
    private void releasepsot(){
        String currenttitle;
        String currentcontent;
        currenttitle = post_title.getText().toString();
        currentcontent = post_content.getText().toString();
        if(StringHelper.isBlank(currenttitle)){
            Toast.makeText(ForumRelease.this, "标题不能为空", Toast.LENGTH_SHORT).show();
        }else if(StringHelper.isBlank(currentcontent)){
            Toast.makeText(ForumRelease.this, "内容不能为空", Toast.LENGTH_SHORT).show();
        } else {
            String newtitle = "";
            String newcontent = "";
            sh.save_releasepost(newtitle, newcontent);
            Toast.makeText(ForumRelease.this, "已发布", Toast.LENGTH_SHORT).show();
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
    private void save_newpost(){
        String newtitle = post_title.getText().toString();
        String newcontent = post_content.getText().toString();
        sh.save_releasepost(newtitle,newcontent);
        Toast.makeText(ForumRelease.this,"已保存",Toast.LENGTH_SHORT).show();
        finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
    private void cencel(){
        String currenttitle = post_title.getText().toString();
        String currentcentent = post_content.getText().toString();
        if(!entertitle.equals(currenttitle) || !entercontent.equals(currentcentent)){
            alertDialog = (AlertDialog) new TipDialog(ForumRelease.this,-1,0.2,
                    "当前文本未保存，是否保存？","保存","不，谢谢",leftListener,reightListener).getInstance();
        }else {
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }
    private View.OnClickListener leftListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            save_newpost();
            alertDialog.dismiss();
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };
    private View.OnClickListener reightListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            alertDialog.dismiss();
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };
}
