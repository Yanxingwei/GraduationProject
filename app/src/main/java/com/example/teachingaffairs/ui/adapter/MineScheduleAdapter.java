package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.bean.ApplicationBean;
import com.example.teachingaffairs.ui.utils.StringHelper;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/26.
 */

public class MineScheduleAdapter extends BaseAdapter {
    private List<ApplicationBean> data;
    private LayoutInflater inflater;
    public MineScheduleAdapter(Context mContext,List<ApplicationBean> data){
        this.data = data;
        this.inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder{
        private TextView Cname;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_mine_schedule_item,null);
            holder.Cname = (TextView) convertView.findViewById(R.id.Cname);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        if(StringHelper.isBlank(data.get(position).getMineSchedule())){
            holder.Cname.setVisibility(View.INVISIBLE);
        }else{
            if(data.get(position).getMineSchedule().indexOf("A")!=-1){
                holder.Cname.setBackgroundResource(R.drawable.mine_schedule_item_shape_a);
            }else if(data.get(position).getMineSchedule().indexOf("B")!=-1){
                holder.Cname.setBackgroundResource(R.drawable.mine_schedule_item_shape_b);
            }
            holder.Cname.setText(data.get(position).getMineSchedule().substring(0,data.get(position).getMineSchedule().length()-1));
        }
        return convertView;
    }
}
