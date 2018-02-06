package com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.model;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean.BooksBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫星位 on 2018/1/19.
 */

public class BooksModel implements IBooksModel{
    private List<BooksBean> datalist = new ArrayList<BooksBean>();
    private String collegename;
    private String panel_title;
    @Override
    public void setCollege(String college) {
        collegename = college;
    }
    @Override
    public void onLoadBooksBean(loadlistener listener) {
        switch(collegename){
            case "文学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史系", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文系", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献系", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事系", "(24)"));
                panel_title = "文学院";
                break;
            case "理学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "物理系", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "数学系", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "化学系", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "生物系", "(30)"));
                panel_title = "理学院";
                break;
            case "工学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "电信系", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "建筑系", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "交通系", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "资勘系", "(24)"));
                panel_title = "工学院";
                break;
            case "医学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "临床医学", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "护理专业", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "兽医专业", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏医专业", "(24)"));
                panel_title = "医学院";
                break;
            case "艺术学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "跳舞的", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "唱歌的", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "画画的", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "服装设计", "(24)"));
                panel_title = "艺术学院";
                break;
            case "经济与管理学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "公共事业管理", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "不知道", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "还有啥", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "不要笑", "(24)"));
                panel_title = "经管院";
                break;
            case "旅游与外语学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "旅游", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "英语", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏语", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "汉语言文学", "(24)"));
                panel_title = "旅外院";
                break;
            case "政法学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "政治", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "地理", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "法律", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "还有啥？", "(24)"));
                panel_title = "政法学院";
                break;
            case "师范学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "语文", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "数学", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "幼儿", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "教书的", "(24)"));
                panel_title = "师范学院";
                break;
            case "财经学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "会计", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "出纳", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "经济", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "财猜猜", "(24)"));
                panel_title = "财经学院";
                break;
            case "信息科学技术学院":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "计算机", "(30)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "java", "(20)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "汇编", "(10)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "数据库", "(24)"));
                panel_title = "信科院";
                break;
            case "教务处":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "李勇峰", "12345678901"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "周艳霞", "(2345678901)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "边巴旺堆", "(4567890123)"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "卓嘎", "(3456789)"));
                panel_title = "教务处";
                break;
            case "学工处":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "学工处1", "21324234"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "学工处2", "23534645"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "学工处3", "3425454564"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "学工处4", "675654564657"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "学工处5", "3425354474"));
                panel_title = "学工处";
                break;
            case "招生就业处":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "招就处1", "1212121212"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "招就处2", "232323232"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "招就处3", "34343434343"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "招就处4", "4545454545"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "招就处5", "5656565656"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "招就处6", "6767676767"));
                panel_title = "招就处";
                break;

            case "历史系":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史1", "15393527030"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史2", "18993531229"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史3", "34343434343"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史4", "4545454545"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史5", "5656565656"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "历史6", "6767676767"));
                panel_title = "历史系通讯录";
                break;

            case "藏文系":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文1", "1212121212"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文2", "232323232"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文3", "34343434343"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文4", "4545454545"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文5", "5656565656"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "藏文6", "6767676767"));
                panel_title = "藏文系通讯录";
                break;

            case "文献系":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献1", "1212121212"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献2", "232323232"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献3", "34343434343"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献4", "4545454545"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献5", "5656565656"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "文献6", "6767676767"));
                panel_title = "文献系通讯录";
                break;

            case "故事系":
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事1", "1212121212"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事2", "232323232"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事3", "34343434343"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事4", "4545454545"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事5", "5656565656"));
                datalist.add(new BooksBean(R.mipmap.mine_more_arrow, R.mipmap.logo, "故事6", "6767676767"));
                panel_title = "故事系通讯录";
                break;
            default:
                break;
        }
        listener.load(datalist);
        listener.loadtitle(panel_title);
    }

}
