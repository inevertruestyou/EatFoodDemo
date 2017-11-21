package com.example.laowa.eatfooddemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.Adapter.RecyclerViewFollowAdapter;
import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by Administrator on 2017/11/2.
 */

public class FansActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fans_activity);
        TextView activityName = (TextView) findViewById(R.id.follow_fans_name);
        activityName.setText("粉丝");
        Button backUp = (Button) findViewById(R.id.follow_fans_back);
        backUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fanBackPersonalShow = new Intent(FansActivity.this,PersonShowActivity.class);
                startActivity(fanBackPersonalShow);
                finish();
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_fans);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerViewFollowAdapter recyclerViewFollowAdapter = new RecyclerViewFollowAdapter(this);
        recyclerView.setAdapter(recyclerViewFollowAdapter);
    }


}
