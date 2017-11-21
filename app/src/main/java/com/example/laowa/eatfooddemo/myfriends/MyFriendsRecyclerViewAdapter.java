package com.example.laowa.eatfooddemo.myfriends;

import android.content.DialogInterface;
import android.media.Rating;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.R;

import java.util.List;

/*
 *
 * Created by Administrator on 2017-10-30.
 */


public class MyFriendsRecyclerViewAdapter extends RecyclerView.Adapter<MyFriendsRecyclerViewAdapter.ViewHolder> {

    private List<MyFriendsAdapter> myfriendsList;
    private OnItemClickListener mOnItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View peopleView;
        ImageView people_image;
        RatingBar friends_star;
        TextView friends_name;

        ViewHolder(View view) {
            super(view);
            peopleView = view;
            people_image = (ImageView) view.findViewById(R.id.my_friends_pic);
           // System.out.println("my_friends_pic=========" + people_image);
            friends_star = (RatingBar) view.findViewById(R.id.my_friends_numstar);
            friends_name = (TextView) view.findViewById(R.id.my_friends_name);
        }
    }

    public MyFriendsRecyclerViewAdapter(List<MyFriendsAdapter> myfriendsList) {
        this.myfriendsList = myfriendsList;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_friends_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                MyFriendsAdapter myfriends = myfriendsList.get(position);
                //            Toast.makeText(v.getContext(), "you clicked view " + people.getPeople_name(), Toast.LENGTH_SHORT).show();
                mOnItemClickListener.onItemClick(holder.itemView, position);
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("你确认删除吗？");
                builder.setNegativeButton("取消", null);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int pos = holder.getLayoutPosition();
                        removeData(pos);
                    }
                }).show();
                return false;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyFriendsAdapter myfriends = myfriendsList.get(position);
        holder.people_image.setImageResource(myfriends.getFriends_pic());
        holder.friends_name.setText(myfriends.getFriends_name());
        holder.friends_star.setRating(myfriends.getFriends_star());
    }

    @Override
    public int getItemCount() {
        return myfriendsList.size();
    }

    //  删除数据
    private void removeData(int position) {
        myfriendsList.remove(position);
        notifyItemRemoved(position);
    }
}
