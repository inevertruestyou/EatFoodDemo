package com.example.laowa.eatfooddemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

/**
 *
 * Created by Administrator on 2017/11/2.
 */

public class RecyclerViewFollowAdapter extends RecyclerView.Adapter<RecyclerViewFollowAdapter.FollowViewAdapter> {
    private Context mContext;
    public RecyclerViewFollowAdapter(Context context){
        this.mContext = context;
    }
    @Override
    public FollowViewAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.follows_fans_item,parent,false);
        return new FollowViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(FollowViewAdapter holder, int position) {
        final View view = holder.mView;
        ImageView RecyclerViewHeadImage = (ImageView) view.findViewById(R.id.follow_fans_head_image);
        TextView RecyclerViewName = (TextView) view.findViewById(R.id.follow_fans_name);
        ImageView RecyclerViewSix = (ImageView) view.findViewById(R.id.follow_fans_six);
        TextView RecyclerViewSchool = (TextView) view.findViewById(R.id.follow_fans_school);
        final TextView RecyclerViewMutualConcern = (TextView) view.findViewById(R.id.follw_fans_mutual_concern);//互相关注
        RelativeLayout RecyclerViewRelativeLayout = (RelativeLayout) view.findViewById(R.id.follow_fans_relativelayout);

        RecyclerViewRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "跳转", Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerViewMutualConcern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RecyclerViewMutualConcern.getText().toString().equals("相互关注")) {
                    RecyclerViewMutualConcern.setText("取消关注");
                }else {
                    RecyclerViewMutualConcern.setText("相互关注");
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public static class FollowViewAdapter extends RecyclerView.ViewHolder{
        public final View mView;
        public FollowViewAdapter(View itemView) {
            super(itemView);
            mView = itemView;
        }
    }
}
