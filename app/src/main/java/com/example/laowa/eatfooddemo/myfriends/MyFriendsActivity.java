package com.example.laowa.eatfooddemo.myfriends;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.chatrom.ChatRoom;
import com.example.laowa.eatfooddemo.mainpageone.MatchPeopleAdapter;
import com.example.laowa.eatfooddemo.mainpageone.MatchPeopleRecycerViewAdapter;

import java.util.ArrayList;

public class MyFriendsActivity extends AppCompatActivity {

    private ArrayList<MyFriendsAdapter> myfriendList = new ArrayList<>();
    Button btn_get_back;

    MyFriendsRecyclerViewAdapter adapter;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_friends_activity);
        btn_get_back = (Button) findViewById(R.id.get_back);
        btn_get_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    @Override
                    public void run() {
                        Instrumentation ins = new Instrumentation();
                        ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            }
        });
        recyclerView = (RecyclerView) findViewById(R.id.myfriends_recyclerview);
        initdata();
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyFriendsRecyclerViewAdapter(myfriendList);
        setLister();
        recyclerView.setAdapter(adapter);

    }

    private void initdata() {
        MyFriendsAdapter one = new MyFriendsAdapter(R.mipmap.icon_head3, "陈敏", (float)2.5);
        myfriendList.add(one);
        MyFriendsAdapter two = new MyFriendsAdapter(R.mipmap.icon_head4, "王飞", (float)3.5);
        myfriendList.add(two);
        MyFriendsAdapter three = new MyFriendsAdapter(R.mipmap.icon_head5, "王磊", 5);
        myfriendList.add(three);
    }

    private void setLister(){
        adapter.setOnItemClickListener(new MyFriendsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //    Toast.makeText(getContext(), "点击第" + (position + 1) + "条"+peopleList.get(position).getPeople_name(), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, ChatRoom.class);
//                intent.putExtra("name",peopleList.get(position).getPeople_name());
//                startActivity(intent);
            }
        });
    }
}
