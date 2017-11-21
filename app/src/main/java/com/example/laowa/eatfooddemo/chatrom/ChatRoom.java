package com.example.laowa.eatfooddemo.chatrom;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.laowa.eatfooddemo.R;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class ChatRoom extends AppCompatActivity{
    private static WebSocketClient webSocketClient;
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private TextView chat_room_name;
    private Button btn_back;
    private int headLeft;
    private int headRight;

    private List<Msg> msgList = new ArrayList<Msg>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
        setContentView(R.layout.chatrom_activity);
        initMsgs();
        Intent intent = getIntent();
        String nameString = intent.getStringExtra("name");
        System.out.println("naemString ====================" + nameString);
        headLeft = intent.getIntExtra("imageLeft",0);
        headRight = intent.getIntExtra("imageRight",0);

        adapter = new MsgAdapter(ChatRoom.this,headLeft,headRight, R.layout.chatrom_msg_item, msgList);
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        msgListView = (ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);

        chat_room_name = (TextView) findViewById(R.id.chat_room_with);
        chat_room_name.setText(nameString);
//        System.out.println("===================" + nameString);


        btn_back = (Button) findViewById(R.id.chat_room_back);
        btn_back.setOnClickListener(new OnClickListener() {
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



        send.setOnClickListener(new OnClickListener(){
            @Override

            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);

//                    webSocketClient.send(content);

                    adapter.notifyDataSetChanged();//刷新显示
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }

            }
        });
//        try {
//            testDemo();
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }

    }
    private void initMsgs() {
        Msg msg1 = new Msg("你好，我是你的饭友。", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("你好，我们一起去吃饭吧！", Msg.TYPE_SEND);
        msgList.add(msg2);

    }
    public void testDemo() throws URISyntaxException {


        webSocketClient = new WebSocketClient(new URI("ws://localhost:8080atRoom/CS-ZLF/1-1")) {

            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("open");


            }

            @Override
            public void onMessage(String s) {
                System.out.println(s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {

            }

            @Override
            public void onError(Exception e) {

            }
        };
        webSocketClient.connect();
        while (!webSocketClient.getReadyState().equals(WebSocket.READYSTATE.OPEN)){
            Log.d("ssssss","链接成功");
        }

    }
}
