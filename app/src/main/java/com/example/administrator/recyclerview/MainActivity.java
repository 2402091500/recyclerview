package com.example.administrator.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView Rv;
    private ArrayList<Integer> mlist=new ArrayList<>();
    private Toolbar tollbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();
        intitTollbar();
        recyclerviewAdapter adapter=new recyclerviewAdapter(mlist,this,false);
        Rv.setAdapter(adapter);
        Rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


    }

    private void intitTollbar() {
        tollbar=(Toolbar) findViewById(R.id.tb);
        tollbar.setTitle("Recyclerview");
        setSupportActionBar(tollbar);
        tollbar.setLogo(R.mipmap.ic_launcher);
        tollbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        tollbar.setTitleTextColor(getResources().getColor(R.color.white));
        tollbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_settings:
                        Rv.setLayoutManager(new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false));
                        break;
                    case R.id.action_search:
                        Rv.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL,false));
                        break;
                    case R.id.action_share:
                        recyclerviewAdapter adapter=new recyclerviewAdapter(mlist,MainActivity.this,true);
                        Rv.setAdapter(adapter);
                        Rv.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

                        break;
                }
                return false;
            }
        });
    }

    private void initdata() {
        for(int i=0;i<=100;i++){
            mlist.add(i);
        }
    }

    private void initview() {
        Rv=(RecyclerView)findViewById(R.id.rv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
