package com.example.laowa.eatfooddemo.ordermeal;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laowa.eatfooddemo.Constant;
import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.ordermeal.bean.Category;
import com.example.laowa.eatfooddemo.ordermeal.bean.CategoryBag;
import com.example.laowa.eatfooddemo.ordermeal.bean.food;
import com.example.laowa.eatfooddemo.ordermeal.ordermealAdapter.CategoryAdapter;
import com.example.laowa.eatfooddemo.ordermeal.ordermealAdapter.FoodAndHeaderAdapter;
import com.example.laowa.eatfooddemo.payment.Payment_meal;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.List;

public class OrderMealActivity extends AppCompatActivity implements CategoryAdapter.OnItemClickListener {

    RecyclerView recyclerviewCategory;
    RecyclerView recyclerviewFood;

    private List<CategoryBag> categoryBags;
    private CategoryAdapter categoryAdapter;
    private FoodAndHeaderAdapter foodAndHeaderAdapter;
    private int oldSelectedPosition = 0;

    TextView allFoodNumber;
    TextView allFoodPrice;
    Button btn_back;
    TextView order_meal_title;
    TextView btn_getsumit;    //结算按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_meal_activity_main);
        categoryBags = new ArrayList<>(10);
        recyclerviewCategory = (RecyclerView) findViewById(R.id.recyclerview_category);
        recyclerviewFood = (RecyclerView) findViewById(R.id.recyclerview_food);
        allFoodNumber = (TextView) findViewById(R.id.tv_shopcart_totalnum);
        allFoodPrice = (TextView) findViewById(R.id.tv_shopcart_totalprice);
        btn_back = (Button) findViewById(R.id.oreder_meal_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run() {
                        Instrumentation ins = new Instrumentation();
                        ins.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    }
                }.start();
            }
        });
        order_meal_title = (TextView) findViewById(R.id.oreder_meal_title);
        //得到传输过来的值
        Intent intent = getIntent();
        String nameString = intent.getStringExtra("name1");
        System.out.println("name1 = ============" + nameString);
//        System.out.println("nameString==============" + nameString);
//        int i = Integer.parseInt(nameString);
//        System.out.print("i  =======================" + i);
//        nameString = Constant.sichuan_normal_university[i];
        order_meal_title.setText(""+nameString);
        btn_getsumit = (TextView) findViewById(R.id.tv_shopcart_submit);
        btn_getsumit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String prices = allFoodPrice.getText().toString();
                String foodnums = allFoodNumber.getText().toString();
                if (foodnums.equals("共0件商品")) {
                    Toast.makeText(OrderMealActivity.this, "你什么都没有购买呢！", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent4 = new Intent(getBaseContext(), Payment_meal.class);
                    intent4.putExtra("prices" , prices);
                    intent4.putExtra("foodnum", foodnums);
                    startActivity(intent4);
                }
            }
        });
        initData();
        giveBag();
        initViews();

    }


    private void giveBag() {

    }

    private LinearLayoutManager mTeamsLayoutManager;
    private LinearLayoutManager mCategoryLayoutManager;


    private void initViews() {
        mTeamsLayoutManager = new LinearLayoutManager(this);
        mCategoryLayoutManager = new LinearLayoutManager(this);
        recyclerviewCategory.setLayoutManager(mCategoryLayoutManager);
        recyclerviewFood.setLayoutManager(mTeamsLayoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryBags);
        categoryAdapter.setOnItemClickListener(this);
        recyclerviewCategory.setAdapter(categoryAdapter);
        foodAndHeaderAdapter = new FoodAndHeaderAdapter(this, categoryBags, allFoodNumber,allFoodPrice);
        recyclerviewFood.setAdapter(foodAndHeaderAdapter);

        // Add the sticky headers decoration,给食物添加标题
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(foodAndHeaderAdapter);
        recyclerviewFood.addItemDecoration(headersDecor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recyclerviewFood.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if (needMove) {
                        needMove = false;
                        //获取要置顶的项在当前屏幕的位置，mIndex是记录的要置顶项在RecyclerView中的位置
                        int n = movePosition - mTeamsLayoutManager.findFirstVisibleItemPosition();
                        if (0 <= n && n < recyclerviewFood.getChildCount()) {
                            //获取要置顶的项顶部离RecyclerView顶部的距离
                            int top = recyclerviewFood.getChildAt(n).getTop() - dip2px(OrderMealActivity.this, 28);
                            //最后的移动
                            recyclerviewFood.scrollBy(0, top);
                        }
                    }
                    //第一个完全显示的item和最后一个item。
                    if (!isChangeByCategoryClick) {
                        int firstVisibleItem = mTeamsLayoutManager.findFirstCompletelyVisibleItemPosition();
                        int sort = foodAndHeaderAdapter.getSortType(firstVisibleItem);
                        changeSelected(sort);
                    } else {
                        isChangeByCategoryClick = false;
                    }
                }
            });
        } else {
            recyclerviewFood.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (needMove) {
                        needMove = false;
                        //获取要置顶的项在当前屏幕的位置，mIndex是记录的要置顶项在RecyclerView中的位置
                        int n = movePosition - mTeamsLayoutManager.findFirstVisibleItemPosition();
                        if (0 <= n && n < recyclerviewFood.getChildCount()) {
                            //获取要置顶的项顶部离RecyclerView顶部的距离
                            int top = recyclerviewFood.getChildAt(n).getTop() - dip2px(OrderMealActivity.this, 28);
                            //最后的移动
                            recyclerviewFood.scrollBy(0, top);
                        }
                    }
                    //第一个完全显示的item和最后一个item。
                    if (!isChangeByCategoryClick) {
                        int firstVisibleItem = mTeamsLayoutManager.findFirstCompletelyVisibleItemPosition();
                        int sort = foodAndHeaderAdapter.getSortType(firstVisibleItem);
                        changeSelected(sort);
                    } else {
                        isChangeByCategoryClick = false;
                    }
                }
            });
        }
    }

    private boolean needMove = false;
    private int movePosition;

    private void moveToPosition(int n) {
        //先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = mTeamsLayoutManager.findFirstVisibleItemPosition();
        int lastItem = mTeamsLayoutManager.findLastVisibleItemPosition();
        //然后区分情况
        if (n <= firstItem) {
            //当要置顶的项在当前显示的第一个项的前面时
            recyclerviewFood.scrollToPosition(n);
        } else if (n <= lastItem) {
            //当要置顶的项已经在屏幕上显示时
            int top = recyclerviewFood.getChildAt(n - firstItem).getTop();
            recyclerviewFood.scrollBy(0, top - dip2px(this, 28));
        } else {
            //当要置顶的项在当前显示的最后一项的后面时
            recyclerviewFood.scrollToPosition(n);
            movePosition = n;
            needMove = true;
        }
    }

    @Override
    public void onItemClick(int position) {
        changeSelected(position);
        moveToThisSortFirstItem(position);
        isChangeByCategoryClick = true;
    }

    private void moveToThisSortFirstItem(int position) {
        movePosition = 0;
        for (int i = 0; i < position; i++) {
            movePosition += foodAndHeaderAdapter.getCategoryBags().get(i).getFoodList().size();
        }
        moveToPosition(movePosition);
    }

    private boolean isChangeByCategoryClick = false;

    private void changeSelected(int position) {
        categoryBags.get(oldSelectedPosition).setSeleted(false);
        categoryBags.get(position).setSeleted(true);
        //增加左侧联动
        recyclerviewCategory.scrollToPosition(position);
        oldSelectedPosition = position;
        categoryAdapter.notifyDataSetChanged();
    }

    //根据手机分辨率从dp转成px
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    private void initData() {

        List<food> foodList1 = new ArrayList<>();
        foodList1.add(new food("辣子鸡", R.drawable.laj,"香辣",6.00));
        foodList1.add(new food("麻婆豆腐", R.drawable.mpdf,"麻辣",4.00));
        foodList1.add(new food("鱼香肉丝", R.drawable.yxrs,"酸辣",5.00));
        foodList1.add(new food("回锅肉", R.drawable.hgr,"不辣",7.00));
        Category c1 = new Category("炒菜", foodList1);

        List<food> foodList2 = new ArrayList<>();
        foodList2.add(new food("小鸡炖蘑菇", R.drawable.xjdmg,"养生",8.00));
        foodList2.add(new food("白雪蹄花", R.drawable.dth,"美容",8.00));
        Category c2 = new Category("炖菜", foodList2);

        List<food> foodList3 = new ArrayList<>();
        foodList3.add(new food("刀削面", R.drawable.dxm,"劲爽",4.00));
        foodList3.add(new food("担担面", R.drawable.ddm,"爽辣",4.00));
        foodList3.add(new food("米线", R.drawable.mx,"爽辣",5.00));
        foodList3.add(new food("酸辣粉", R.drawable.slf,"爽辣",5.00));
        Category c3 = new Category("早饭", foodList3);

        List<food> foodList4 = new ArrayList<>();

        foodList4.add(new food("油条", R.drawable.yt,"脆爽",1.00));
        foodList4.add(new food("豆浆", R.drawable.dj,"爽口",1.00));
        foodList4.add(new food("豆浆", R.drawable.dj,"爽口",1.00));
        Category c4 = new Category("面食", foodList4);


        categoryBags.add(new CategoryBag(c1, true));
        categoryBags.add(new CategoryBag(c2, false));
        categoryBags.add(new CategoryBag(c3, false));
        categoryBags.add(new CategoryBag(c4, false));
    }
}
