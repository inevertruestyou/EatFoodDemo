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

import com.example.laowa.eatfooddemo.Adapter.RecyclerViewFollowAdapter;
import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by Administrator on 2017/11/2.
 */

public class FollowActivity extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.follow_activity);
        Button backUp = (Button) findViewById(R.id.follow_back);
        backUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent followBackPersonalShow = new Intent(FollowActivity.this,PersonShowActivity.class);
                startActivity(followBackPersonalShow);
                finish();
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_follows);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        RecyclerViewFollowAdapter recyclerViewFollowAdapter = new RecyclerViewFollowAdapter(this);
        recyclerView.setAdapter(recyclerViewFollowAdapter);
    }

}
