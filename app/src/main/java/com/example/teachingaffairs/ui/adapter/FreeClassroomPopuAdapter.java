package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by 闫星位 on 2018/1/25.
 */

public class FreeClassroomPopuAdapter extends BaseAdapter{

    private ArrayList<HashMap<String,Object>> datalist;
    private LayoutInflater inflater;
    public FreeClassroomPopuAdapter(Context mContext,ArrayList<HashMap<String,Object>> datalist){
        this.datalist = datalist;
        this.inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return datalist.size();
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
        private TextView campus;
        private View divider;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_free_popu_list_item,null);
            holder.campus = (TextView) convertView.findViewById(R.id.campus);
            holder.divider = (View) convertView.findViewById(R.id.divider);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.campus.setText((String)datalist.get(position).get("campus"));
        if(datalist.size()-1 == position){
            holder.divider.setVisibility(View.GONE);
        }else{
            holder.divider.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}
