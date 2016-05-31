package com.kklv.mymaterial;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.kklv.mymaterial.adapter.MyListViewAdapter;
import com.kklv.mymaterial.adapter.MyRecycleViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mList;
    private MyRecycleViewAdapter mRecycleViewAdapter;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private int mode=0;
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

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        switch (mode){
            case 3:
                menu.findItem(R.id.menu_one_mode_auto).setChecked(true);
                break;
            case 2:
                menu.findItem(R.id.menu_one_mode_night).setChecked(true);
                break;
            case 6:
                menu.findItem(R.id.menu_one_mode_bad).setChecked(true);
                break;
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.menu_one_mode_auto:
                Toast.makeText(this,"自动模式",Toast.LENGTH_SHORT).show();
                mode=3;
                break;
            case R.id.menu_one_mode_bad:
                Toast.makeText(this,"bad模式",Toast.LENGTH_SHORT).show();
                mode=6;
                break;
            case R.id.menu_one_mode_night:
                Toast.makeText(this,"夜晚模式",Toast.LENGTH_SHORT).show();
                mode=2;
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions_menu,menu);
        return true;
    }

    private void bindId(){
        mRecyclerView= (RecyclerView) findViewById(R.id.rvToDoList);
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView= (NavigationView) findViewById(R.id.nav_view);
    }

    private void initView(){
        mList=new ArrayList<>();
        for (int i=0;i<23;i++){
            mList.add(i+"");
        }
        mRecycleViewAdapter=new MyRecycleViewAdapter(this,mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mRecycleViewAdapter);

        setupDrawerContent(mNavigationView);
    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
