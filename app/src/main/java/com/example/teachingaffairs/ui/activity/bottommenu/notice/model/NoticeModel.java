package com.example.teachingaffairs.ui.activity.bottommenu.notice.model;

import com.example.teachingaffairs.ui.activity.bottommenu.notice.bean.NoticeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 闫星位 on 2018/1/23.
 */

public class NoticeModel implements INoticeModel{
    private List<NoticeBean> data = new ArrayList<>();
    @Override
    public void dataListener(loadListener listener) {
        data.add(new NoticeBean("2018-1-23","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适,测试公告功能，这条信息是假数据，主要测试布局合适不合适","教务处","测试标题1","公告"));
        data.add(new NoticeBean("2018-1-24","15:22","测试公告功能，这条信息是假数据","教务处","测试标题2","通知"));
        data.add(new NoticeBean("2018-1-25","15:21","测试公告功能，这条信息是假数据，主要测试布局合适不合适","工学院","测试标题3","公示"));
        data.add(new NoticeBean("2018-1-26","15:24","测试公告功能，这条信息是假数据，主要测试布局合适不合适","教务处","测试标题4","公告"));
        data.add(new NoticeBean("2018-1-27","15:26","测试公告功能，这条信息是假数据，主要测试布局合适不合适","教务处","测试标题5","公告"));
        data.add(new NoticeBean("2018-1-28","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适","理学院","测试标题6","公示"));
        data.add(new NoticeBean("2018-1-29","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适","教务处","关于寒假放假时间安排","通知"));
        data.add(new NoticeBean("2018-1-23","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适","教务处","测试标题","通知"));
        data.add(new NoticeBean("2018-1-23","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适","教务处","测试标题","通知"));
        data.add(new NoticeBean("2018-1-23","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适","学工处","测试标题","公告"));
        data.add(new NoticeBean("2018-1-23","15:20","测试公告功能，这条信息是假数据，主要测试布局合适不合适","艺术学院","测试标题","公示"));
        listener.load(data);
    }
}
