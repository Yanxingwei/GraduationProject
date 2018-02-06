package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.addressbooks.bean.BooksBean;

import java.util.List;

/**
 * Created by 闫星位 on 2018/1/18.
 */

public class DepertmentAdapter extends BaseAdapter{

    private List<BooksBean> data;
    private LayoutInflater inflater;
    public DepertmentAdapter(Context mContext, List<BooksBean> data){
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
        private TextView head,go_logo,name,number;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.app_address_books_item,null);
            holder.head = (TextView) convertView.findViewById(R.id.college_logo);
            holder.number = (TextView) convertView.findViewById(R.id.college_number);
            holder.go_logo = (TextView) convertView.findViewById(R.id.college_go);
            holder.name = (TextView) convertView.findViewById(R.id.college_name);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText(data.get(position).getDepertment());
        holder.number.setText(data.get(position).getNumber());
        holder.head.setBackgroundResource(data.get(position).getHead_logo());
        holder.go_logo.setBackgroundResource(data.get(position).getGo_logo());
        return convertView;
    }
}
