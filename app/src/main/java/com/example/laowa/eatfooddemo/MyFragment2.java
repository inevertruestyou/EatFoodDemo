package com.example.laowa.eatfooddemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.activity.PersonShowActivity;
import com.example.laowa.eatfooddemo.chatrom.ChatRoom;
import com.example.laowa.eatfooddemo.mainpageone.MatchPeopleAdapter;
import com.example.laowa.eatfooddemo.mainpageone.MatchPeopleRecycerViewAdapter;
import com.example.laowa.eatfooddemo.matchPeoplegoto.MatchPeoplegoto;

import java.util.ArrayList;

/**
 *
 * 第二个页面
 */
public class MyFragment2 extends Fragment {

    private ArrayList<MatchPeopleAdapter> peopleList = new ArrayList<>();

    MatchPeopleRecycerViewAdapter adapter;

    private ImageView match_people_pic;
    private ImageView edit_match_people_talk;   //修改约饭宣言
    private Button btn_match_people;    //开始约饭按钮
    private RecyclerView match_people_recyclerview;
    private LinearLayout layout_match_people;
    private TextView match_talk;    //约饭宣言

    public MyFragment2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.match_food_people, container, false);

        layout_match_people = (LinearLayout) view.findViewById(R.id.match_people_layout);
        layout_match_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent  = new Intent(getContext(), PersonShowActivity.class);
               startActivity(intent);
            }
        });


        edit_match_people_talk = (ImageView) view.findViewById(R.id.edit_match_people);
        match_talk = (TextView) view.findViewById(R.id.match_talk);
        //修改约饭宣言
        edit_match_people_talk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(getContext());
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("约饭宣言").setView(editText);
                builder.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (!editText.getText().toString().equals(""))     //判断是否输入
                                    match_talk.setText(editText.getText().toString());
                            }
                        });
                builder.setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create().show();

            }
        });
        //开始约饭
        btn_match_people = (Button) view.findViewById(R.id.match_people_start);
        btn_match_people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MatchPeoplegoto.class);
                startActivity(intent);
            }
        });

        match_people_pic = (ImageView) view.findViewById(R.id.match_people_pic);

        //recyclerview显示聊天
        match_people_recyclerview = (RecyclerView) view.findViewById(R.id.match_people_recyclerview);
        initFood();
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        match_people_recyclerview.setLayoutManager(layoutManager);
        adapter = new MatchPeopleRecycerViewAdapter(peopleList);
        setLister();
        match_people_recyclerview.setAdapter(adapter);
        return view;
    }

    private void initFood() {

        MatchPeopleAdapter one = new MatchPeopleAdapter("陈敏", "一起吃饭吗", "2017-10-31", R.mipmap.icon_head3);
        peopleList.add(one);
        MatchPeopleAdapter two = new MatchPeopleAdapter("王飞", "一起吃饭吗", "2017-10-31", R.mipmap.icon_head4);
        peopleList.add(two);
        MatchPeopleAdapter three = new MatchPeopleAdapter("王磊", "吃饭了吗", "2017-10-31", R.mipmap.icon_head5);
        peopleList.add(three);
        MatchPeopleAdapter four = new MatchPeopleAdapter("韩梅梅", "一起吃饭吧", "2017-10-31", R.mipmap.icon_head6);
        peopleList.add(four);
        MatchPeopleAdapter five = new MatchPeopleAdapter("李华", "一起吃饭吧", "2017-10-31", R.mipmap.icon_head10);
        peopleList.add(five);
        MatchPeopleAdapter six = new MatchPeopleAdapter("王小明", "一起吃饭吧", "2017-10-31", R.mipmap.icon_head11);
        peopleList.add(six);
        MatchPeopleAdapter seven = new MatchPeopleAdapter("马德华", "一起吃饭吧", "2017-10-31", R.mipmap.icon_head12);
        peopleList.add(seven);
        MatchPeopleAdapter eight = new MatchPeopleAdapter("爽得跳", "一起吃饭吧", "2017-10-31", R.mipmap.icon_head13);
        peopleList.add(eight);
        MatchPeopleAdapter nine = new MatchPeopleAdapter("果子哥哥", "一起吃饭吧", "2017-10-31", R.mipmap.icon_head14);
        peopleList.add(nine);




    }

    private void setLister(){
        adapter.setOnItemClickListener(new MatchPeopleRecycerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //    Toast.makeText(getContext(), "点击第" + (position + 1) + "条"+peopleList.get(position).getPeople_name(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), ChatRoom.class);
                intent.putExtra("name",peopleList.get(position).getPeople_name());
                intent.putExtra("imageLeft",peopleList.get(position).getPeople_pic());
                intent.putExtra("imageRight",R.mipmap.tab_better_normal);
                startActivity(intent);
            }
        });
    }
}
