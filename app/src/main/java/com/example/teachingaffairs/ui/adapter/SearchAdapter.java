package com.example.teachingaffairs.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.teachingaffairs.R;
import com.example.teachingaffairs.ui.activity.bottommenu.application.teacher.bean.SearchData;

import java.util.List;

/**
 * Created by LZW on 2016/9/22.
 */

public class SearchAdapter extends MyBaseAdapter<SearchData> {
    private List<SearchData> data;
    public SearchAdapter(Context context, List<SearchData> data) {
        super(context, data);
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item, null);
            holderView = new HolderView();
            holderView.name = (TextView) convertView.findViewById(R.id.name);
            holderView.underline = (View) convertView.findViewById(R.id.underline);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }
        holderView.name.setText(mData.get(position).getName());
        if(position == data.size()-1){
            holderView.underline.setVisibility(View.GONE);
        }else{
            holderView.underline.setVisibility(View.VISIBLE);
        }
        return convertView;
    }

    private class HolderView {
        private TextView name;
        private View underline;
    }
}
