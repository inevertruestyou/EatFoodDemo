package com.example.laowa.eatfooddemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.mainpageone.SearchActivity;


/**
 *
 * Created by Jay on 2015/8/28 0028.
 */

public class MyFragment1 extends Fragment {

    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private TextView mSearch;
    private GridView gridView;

    public MyFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content, container, false);
        Spinner spinner = (Spinner) view.findViewById(R.id.main_spinner);
        //为下拉列表定义一个适配器。
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, Constant.list_schoollocal);
        //为适配器设置下拉列表下拉时的菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将适配器添加到下拉列表上
        spinner.setAdapter(adapter);
        //设置各种事件的响应
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Toast.makeText(getContext(), "你选择了" + adapter.getItem(arg2), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        mSearch = (TextView) view.findViewById(R.id.tv_search_bg);
        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                int location[] = new int[2];
                mSearch.getLocationOnScreen(location);
                intent.putExtra("x",location[0]);
                intent.putExtra("y",location[1]);
                startActivity(intent);
//                overridePendingTransition(0,0);
            }
        });
        return view;
    }
}
