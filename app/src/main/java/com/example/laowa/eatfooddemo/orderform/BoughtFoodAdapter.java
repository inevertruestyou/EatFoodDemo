package com.example.laowa.eatfooddemo.orderform;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

import java.util.List;

/**
 *
 * Created by Lenovo Users on 2017/11/14.
 */

public class BoughtFoodAdapter  extends RecyclerView.Adapter<BoughtFoodAdapter.ViewHolder>{
    private List<BoughtFood> mBoughtFood;
    private OnItemClickListener mOnItemClickListener;
    private Context mContext;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_form,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    public BoughtFoodAdapter(Context context,List<BoughtFood> boughtFoods){
        mContext = context;
        mBoughtFood = boughtFoods;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        BoughtFood boughtFood = mBoughtFood.get(position);
        holder.boughtFood.setImageResource(boughtFood.getBoughtFoodImagePath());
        holder.boughtFoodName.setText(boughtFood.getBoughtFoodName());
        holder.boughtFoodDining.setText(boughtFood.getBoughtFoodDining());
        holder.boughtFoodNumber.setText(boughtFood.getBoughtFoodNumber()+"");
        holder.boughtFoodAllPrice.setText(boughtFood.getBoughtFoodAllPrice()+"");
        holder.boughtFoodEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Toast.makeText(view.getContext(),"评价",Toast.LENGTH_SHORT).show();

            }
        });
        seeOnItemClickListener( holder);



    }

    private void seeOnItemClickListener(final ViewHolder holder) {
        if (mOnItemClickListener != null){

            holder.boughtFoodEvaluate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.boughtFoodEvaluate,pos);
                    holder.boughtFoodEvaluate1.setText("已评价");
                    holder.boughtFoodEvaluate.setVisibility(View.GONE);
                }
            });
            holder.boughtFoodEvaluate.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view){
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.boughtFoodEvaluate,pos);
                    holder.boughtFoodEvaluate1.setText("已评价");
                    holder.boughtFoodEvaluate.setVisibility(View.GONE);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mBoughtFood.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView boughtFood;
        ImageView boughtFoodEvaluate;
        TextView boughtFoodName;
        TextView boughtFoodDining;
        TextView boughtFoodNumber;
        TextView boughtFoodAllPrice;
        TextView boughtFoodEvaluate1;

        public ViewHolder(View itemView) {
            super(itemView);
            boughtFood = (ImageView) itemView.findViewById(R.id.bought_food_image);
            boughtFoodName = (TextView) itemView.findViewById(R.id.bought_food_name);
            boughtFoodDining = (TextView) itemView.findViewById(R.id.bought_food_dining);
            boughtFoodNumber = (TextView) itemView.findViewById(R.id.bought_food_number);
            boughtFoodAllPrice = (TextView) itemView.findViewById(R.id.bought_food_all_price);
            boughtFoodEvaluate = (ImageView) itemView.findViewById(R.id.bought_food_evaluate);
            boughtFoodEvaluate1 = (TextView) itemView.findViewById(R.id.bought_food_status);


        }


    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
