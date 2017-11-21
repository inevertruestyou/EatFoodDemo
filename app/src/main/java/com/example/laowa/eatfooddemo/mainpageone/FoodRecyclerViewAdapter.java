package com.example.laowa.eatfooddemo.mainpageone;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.R;

import java.util.List;

public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodRecyclerViewAdapter.ViewHolder> {

    private List<FoodAdapter> mFoodList;
    private OnItemClickListener mOnItemClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View foodView;
        ImageView foodImage;
        TextView foodName;
        TextView food_grades;
        RatingBar food_star;
        TextView food_burdening;

        ViewHolder(View view) {
            super(view);
            foodView = view;
            foodImage = (ImageView) view.findViewById(R.id.greens_image);
            foodName = (TextView) view.findViewById(R.id.greens_name);
            food_grades = (TextView) view.findViewById(R.id.greens_grades_num);
            food_star = (RatingBar) view.findViewById(R.id.greens_grades_ratingbar);
            food_burdening = (TextView) view.findViewById(R.id.greens_burdening);
        }
    }

    public FoodRecyclerViewAdapter(List<FoodAdapter> fruitList) {
        mFoodList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recyclerview, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
//                FoodAdapter food = mFoodList.get(position);
//                Toast.makeText(v.getContext(), "you clicked view " + food.getFood_name(), Toast.LENGTH_SHORT).show();
                System.out.println("===============" + position);
                mOnItemClickListener.onItemClick(holder.itemView, position);
            }
        });

//        view.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                int pos = holder.getLayoutPosition();
//                mOnItemLongClickListener.onItemLongClick(holder.itemView, pos);
//
//            }
//        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FoodAdapter food = mFoodList.get(position);
        holder.foodImage.setImageResource(food.getFood_imageId());
        holder.foodName.setText(food.getFood_name());
        holder.food_grades.setText("" + food.getFood_num());
        holder.food_star.setRating(food.getFood_num());
        holder.food_burdening.setText(food.getFood_all());


    }

    @Override
    public int getItemCount() {
        return mFoodList.size();
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }



}

