package com.example.laowa.eatfooddemo.ordermeal.ordermealAdapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.ordermeal.bean.CategoryBag;
import com.example.laowa.eatfooddemo.ordermeal.bean.food;
import com.example.laowa.eatfooddemo.ordermeal.bean.FoodBag;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2016/3/18.
 */
public class FoodAndHeaderAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder> {
    private List<CategoryBag> categoryBags;
    private List<FoodBag> foodBags = new ArrayList<>();
    private Context mContext;
    double money;

    private TextView allFoodNumber;
    private TextView allFoodPrice;

    public FoodAndHeaderAdapter(Context context, List<CategoryBag> categoryBags, TextView allFoodNumber,TextView allFoodPrice) {
        mContext = context;
        this.allFoodNumber = allFoodNumber;
        this.allFoodPrice = allFoodPrice;
        setCategoryBags(categoryBags);
    }

    public void setCategoryBags(List<CategoryBag> categoryBags) {
        this.categoryBags = categoryBags;
        for (int i = 0; i < categoryBags.size(); i++) {
            List<food> foodList = categoryBags.get(i).getFoodList();
            for (int j = 0; j < foodList.size(); j++) {
                foodBags.add(new FoodBag(foodList.get(j)));
            }
        }
        notifyDataSetChanged();
    }

    public List<CategoryBag> getCategoryBags() {
        return categoryBags;
    }

    @Override
    public int getItemCount() {
        return foodBags.size();
    }

    @Override
    public long getHeaderId(int position) {
        int debug = getSortType(position);

        return debug;
    }

    //获取当前菜的种类的类型
    public int getSortType(int position) {
        int sort = -1;
        int sum = 0;
        for (int i = 0; i < categoryBags.size(); i++) {
            if (position >= sum) {
                sort++;
            } else {
                return sort;
            }
            sum += categoryBags.get(i).getFoodList().size();
        }
        return sort;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewGroup) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.header_food_kind_list, viewGroup, false);

        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        TextView textView = (TextView) viewHolder.itemView;
        textView.setText(categoryBags.get(getSortType(position)).getSortName());
        textView.setBackgroundColor(getRandomColor());
    }


    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    private int getRandomColor() {
        SecureRandom rgen = new SecureRandom();
        return Color.HSVToColor(150, new float[]{
                rgen.nextInt(359), 1, 1
        });
    }


    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);


        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,final   int position) {

        final ContentViewHolder viewHolder = (ContentViewHolder) holder;
        final FoodBag foodBag = foodBags.get(position);
        viewHolder.special.setText(foodBag.getSpecial());
        viewHolder.textView.setText(foodBag.getName());
        viewHolder.foodPrice.setText(foodBag.getPrice()+"");
        viewHolder.imageViewFood.setImageResource(foodBag.getImagePath());
//        viewHolder.setIsRecyclable(false);
        viewHolder.foodAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                foodBag.clickAdd();
                int sum = getValue(allFoodNumber.getText().toString());
                ++sum;
                allFoodNumber.setText("共"+String.valueOf(sum)+"件商品");
                String text = String.valueOf(foodBag.getWillSellNumber());
                viewHolder.foodNumber.setText(text);
                money = Double.valueOf(allFoodPrice.getText().toString()).doubleValue();
                money += Double.valueOf(viewHolder.foodPrice.getText().toString()).doubleValue();
                allFoodPrice.setText(""+money);

//                if (foodBag.getWillSellNumber() == 1){
//                    viewHolder.foodSub.setVisibility(VISIBLE);
//                    viewHolder.foodNumber.setVisibility(VISIBLE);
//
//                }
                viewHolder.foodNumber.setTag(position);
            }

        });
        viewHolder.foodSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (foodBag.getWillSellNumber()>0) {
                    foodBag.clickSub();
                    int sum = getValue(allFoodNumber.getText().toString());
                    --sum;
                    allFoodNumber.setText("共"+String.valueOf(sum)+"件商品");
                    String text = String.valueOf(foodBag.getWillSellNumber());
                    viewHolder.foodNumber.setText(text);

                    double money = Double.valueOf(allFoodPrice.getText().toString()).doubleValue();
                    money -= Double.valueOf(viewHolder.foodPrice.getText().toString()).doubleValue();
                    allFoodPrice.setText(""+money);
//                    if (foodBag.getWillSellNumber()==0){
//                        viewHolder.foodSub.setVisibility(INVISIBLE);
//                        viewHolder.foodNumber.setVisibility(INVISIBLE);
//                        notifyDataSetChanged();
//                    }

                }
            }
        });

    }

    private class ContentViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageViewFood;
        ImageView foodAdd;
        ImageView foodSub;
        TextView foodNumber;
        TextView foodPrice;
        TextView special;
        View foodView;
        public ContentViewHolder(View itemView) {
            super(itemView);
            foodView = itemView;
            textView = (TextView) itemView.findViewById(R.id.textview_foodname);
            imageViewFood = (ImageView) itemView.findViewById(R.id.imageview_food);
            foodAdd = (ImageView) itemView.findViewById(R.id.imageview_add_goods);
            foodNumber = (TextView) itemView.findViewById(R.id.textview_number);
            foodSub = (ImageView) itemView.findViewById(R.id.imageview_sub);
            foodPrice = (TextView) itemView.findViewById(R.id.tvGoodsPrice);
            special = (TextView) itemView.findViewById(R.id.tvGoodsDescription);

        }
    }



    private int getValue(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                sum += c - '0';
                sum *= 10;
            }
        }
        sum /= 10;
        return sum;
    }



}
