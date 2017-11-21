package com.example.laowa.eatfooddemo.ordermeal.ordermealAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.ordermeal.bean.Category;
import com.example.laowa.eatfooddemo.ordermeal.bean.CategoryBag;

import java.util.List;

/**
 *
 * Created by Administrator on 2016/3/17.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>{
    private List<CategoryBag> categoryBags;
    private Context context;

    public CategoryAdapter(Context context, List<CategoryBag> categoryBags) {
        this.context = context;
        this.categoryBags = categoryBags;
    }

    public void setCategoryBags(List<CategoryBag> categoryBags) {
        this.categoryBags = categoryBags;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category,null));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        CategoryBag categoryBag = categoryBags.get(position);
        holder.textView.setText(categoryBag.getSortName());
        holder.textView.setSelected(categoryBag.isSelected());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryBags ==null?0: categoryBags.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview_categoryname);
        }
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
