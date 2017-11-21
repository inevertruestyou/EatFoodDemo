package com.example.laowa.eatfooddemo.mainpageone;

/*
 *
 * Created by Administrator on 2017-10-30.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.activity.PersonShowActivity;

import java.util.List;

public class MatchPeopleRecycerViewAdapter extends RecyclerView.Adapter<MatchPeopleRecycerViewAdapter.ViewHolder> {

    private List<MatchPeopleAdapter> mPeopleList;
    private OnItemClickListener mOnItemClickListener;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        View peopleView;
        ImageView people_image;
        TextView people_name;
        TextView people_last_message_data;
        TextView people_last_message;

        ViewHolder(View view) {
            super(view);
            peopleView = view;
            people_image = (ImageView) view.findViewById(R.id.people_pic);
            people_name = (TextView) view.findViewById(R.id.people_name);
            people_last_message = (TextView) view.findViewById(R.id.people_last_message);
            people_last_message_data = (TextView) view.findViewById(R.id.people_last_message_data);
        }
    }

    public MatchPeopleRecycerViewAdapter(List<MatchPeopleAdapter> peopleList) {
        mPeopleList = peopleList;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_people_message_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                MatchPeopleAdapter people = mPeopleList.get(position);
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
        MatchPeopleAdapter people = mPeopleList.get(position);
        holder.people_image.setImageResource(people.getPeople_pic());
        holder.people_name.setText(people.getPeople_name());
        holder.people_last_message.setText(people.getPeople_last_message());
        holder.people_last_message_data.setText(people.getPeople_numstar());
    }

    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }

    //  删除数据
    private void removeData(int position) {
        mPeopleList.remove(position);
        notifyItemRemoved(position);
    }
}
