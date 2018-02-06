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
 * Created by 闫星位 on 2018/2/2.
 */

public class ResultsQueryPopupAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<HashMap<String,Object>> datalist;
    public ResultsQueryPopupAdapter(Context mContext, ArrayList<HashMap<String,Object>> datalist){
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
        private TextView tv_data;
        private View underline;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_app_results_query_popup_item,null);
            holder.tv_data = (TextView) convertView.findViewById(R.id.tv_data);
            holder.underline = (View) convertView.findViewById(R.id.underline);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_data.setText((String)datalist.get(position).get("date"));
        if(position == datalist.size()-1){
            holder.underline.setVisibility(View.GONE);
        }else{
            holder.underline.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}
