package com.example.laowa.eatfooddemo.friendscircle;

import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.laowa.eatfooddemo.R;
import com.example.laowa.eatfooddemo.friendscircle.view.XListView;
import com.example.laowa.eatfooddemo.friendscircle.view.XListView.IXListViewListener;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FriendsCircleActivity extends Activity implements IXListViewListener {

    XListView listView;
    // ListView的设配器
    private XBaseAdapter xBaseAdapter;

    @ViewById
    Button btnSendComment;

    FloatingActionButton floatingActionButton;
    @ViewById
    EditText etComment;

    String pic;
    String content;
    String name;
    int k = 3;  //用来对于发朋友圈计数
    String mode_new;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlist);
        afterViewInitList();

        Intent intent = getIntent();
        pic = intent.getStringExtra("imagePath");
        content = intent.getStringExtra("speakContent");
        name = intent.getStringExtra("name");
        System.out.println("name ==================" + name);
        Boolean num4 = intent.getBooleanExtra("boolean", false);

        if (name != null) {
            getrefresh();
            k ++;
        }
    }

    void afterViewInitList() {
        listView = (XListView) findViewById(R.id.listView);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.friend_circle_fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FriendsCircleActivity.this, "this is a floatingActionButton", Toast.LENGTH_SHORT).show();
                Intent circleIntentSend = new Intent(FriendsCircleActivity.this,SendFriend.class);
                startActivity(circleIntentSend);
            }
        });
        xBaseAdapter = new XBaseAdapter(this, R.layout.listview_item,this);
        listView.setAdapter(xBaseAdapter);
        listView.setXListViewListener(this);// 添加XListView的上拉和下拉刷新监听器
        listView.setPullLoadEnable(true);
        listView.setPullRefreshEnable(true);
        initXListData();
    }

    void initXListData() {
        Model model = new Model();
        model.setImgHead(R.drawable.head);
        model.setName("小明");
        model.setContent("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        model.setType(FinalVar.MSG_TEXT);
        model.setAgree(false);
        model.setPhonemodel("Nexus 5");
        model.setAddress("成都市 龙泉驿区");
        model.setDate(new SimpleDateFormat().format(new Date()).toString());
        xBaseAdapter.addModel(model);
        Model model2 = new Model();
        model2.setImgHead(R.drawable.qq_contact_list_friend_entry_icon);
        model2.setName("小红");
        model2.setContent("哈哈哈哈哈哈哈哈哈哈哈哈");
        model2.setType(FinalVar.MSG_IMAGE);
        model2.setPhonemodel("iPhone 5s");
        model2.setAddress("成都市 龙泉驿区");
        model2.setDate(new SimpleDateFormat().format(new Date()).toString());
        List<String> imageUrls = new ArrayList<>();
        imageUrls
                .add("");
        imageUrls
                .add("");
        model2.setImageUrls(imageUrls);
        model.setDate(new SimpleDateFormat().format(new Date()).toString());
        xBaseAdapter.addModel(model2);
        xBaseAdapter.notifyDataSetChanged();
    }

    @ItemClick(R.id.listView)
    public void onItemClick(int position) {
        // TODO Auto-generated method stub
        Log.d("ItemClick", "pos=" + position);
        position = position - 1;
        if (null != xBaseAdapter.getModel(position)) {
            Toast.makeText(this, "click Item...", Toast.LENGTH_SHORT).show();
        }
    }

    @Click(R.id.btnSendComment)
    void btnSendComment(){
        String comment = etComment.getEditableText().toString();
        Toast.makeText(this, comment, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        Log.d("xlistview", "onrefresh");
        refreshListViewInBackground();
    }

    @UiThread
    void refreshListViewInBackground() {// 模拟刷新数据
        Model model = new Model();
        model.setImgHead(R.drawable.head);
        model.setName("小东");
        model.setContent("为了梦想而努力。。。");
        model.setType(FinalVar.MSG_TEXT);
        model.setAgree(false);
        model.setPhonemodel("Nexus 5");
        model.setAddress("成都市 龙泉驿区");
        model.setDate(new SimpleDateFormat().format(new Date()).toString());
        xBaseAdapter.addModel(model,true);
        xBaseAdapter.notifyDataSetChanged();
        onLoad();
    }

    @Override
    public void onLoadMore() {
        Log.d("ItemClick", "onloadmore");
        loadMoreInBackground();
    }

    @UiThread
    void loadMoreInBackground() {
        Model model = new Model();
        model.setImgHead(R.drawable.head);
        model.setName("高富帅");
        model.setContent("无聊中...且行且珍惜");
        model.setType(FinalVar.MSG_TEXT);
        model.setAgree(false);
        model.setPhonemodel("Nexus 5");
        model.setAddress("南京市 高铁南站");
        model.setDate(new SimpleDateFormat().format(new Date()).toString());
        xBaseAdapter.addModel(model);
        xBaseAdapter.notifyDataSetChanged();
        listView.setSelection(xBaseAdapter.getCount() - 1);// 将光标移动到加载的交界处
        onLoad();
    }

    private void onLoad() {
        listView.stopRefresh();
        listView.stopLoadMore();
        listView.setRefreshTime("刚刚");
    }
    public static Bitmap GetBitmap(String path, int w, int h) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        BitmapFactory.decodeFile(path, opts);
        int width = opts.outWidth;
        int height = opts.outHeight;
        float scaleWidth = 0.f, scaleHeight = 0.f;
        if (width > w || height > h) {
            scaleWidth = ((float) width) / w;
            scaleHeight = ((float) height) / h;
        }
        opts.inJustDecodeBounds = false;
        float scale = Math.max(scaleWidth, scaleHeight);
        opts.inSampleSize = (int) scale;
        WeakReference<Bitmap> weak = new WeakReference<>(BitmapFactory.decodeFile(path, opts));
        return Bitmap.createScaledBitmap(weak.get(), w, h, true);
    }

    public void getrefresh() {for(int i = 0; i < k - 2; i ++) {
        mode_new = "mode" + k;
        System.out.println("mode_new=========================" + mode_new);
        Model mode_new = new Model();
        mode_new.setImgHead(R.mipmap.head1);
        mode_new.setName(name);
        mode_new.setContent(content);
        mode_new.setType(FinalVar.MSG_TEXT);
        mode_new.setAgree(false);
        mode_new.setPhonemodel("iphone 18");
        mode_new.setAddress("成都市 龙泉驿区");
        mode_new.setDate(new SimpleDateFormat().format(new Date()).toString());
        xBaseAdapter.addModel(mode_new);
        xBaseAdapter.notifyDataSetChanged();
    }
    }
}