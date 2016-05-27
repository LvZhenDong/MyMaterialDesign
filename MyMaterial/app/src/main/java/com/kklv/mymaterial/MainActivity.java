package com.kklv.mymaterial;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.kklv.mymaterial.adapter.MyListViewAdapter;
import com.kklv.mymaterial.adapter.MyRecycleViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mList;
    private MyRecycleViewAdapter mRecycleViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab=getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        bindId();
        initView();
    }

    private void bindId(){
        mRecyclerView= (RecyclerView) findViewById(R.id.rvToDoList);
    }

    private void initView(){
        mList=new ArrayList<>();
        for (int i=0;i<23;i++){
            mList.add(i+"");
        }
        mRecycleViewAdapter=new MyRecycleViewAdapter(this,mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecycleViewAdapter);
    }
}
