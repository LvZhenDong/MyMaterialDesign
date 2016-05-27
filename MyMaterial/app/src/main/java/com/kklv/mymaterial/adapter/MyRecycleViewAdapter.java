package com.kklv.mymaterial.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kklv.mymaterial.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/26.
 */
public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder>{
    private final LayoutInflater mLayoutInflater;
    private final Context mContext;
    private ArrayList<String> mList;

    public MyRecycleViewAdapter(Context context,ArrayList<String> list) {
        mContext=context;
        mLayoutInflater=LayoutInflater.from(mContext);
        mList=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.item_listview,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText("this is item"+position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        TextView mTextView;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextView= (TextView) itemView.findViewById(R.id.tv_listview_item);
        }
    }
}
