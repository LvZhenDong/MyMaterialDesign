package com.kklv.mymaterial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kklv.mymaterial.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/5/26.
 */
public class MyListViewAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mList;
    public MyListViewAdapter(Context context,ArrayList<String> list){
        this.mContext=context;
        mInflater= LayoutInflater.from(mContext);
        this.mList=list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            convertView=mInflater.inflate(R.layout.item_listview,parent,false);
            holder=new ViewHolder();
            holder.tv= (TextView) convertView.findViewById(R.id.tv_listview_item);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.tv.setText("this is item "+position);
        return convertView;
    }

    class ViewHolder{
        TextView tv;
    }
}
