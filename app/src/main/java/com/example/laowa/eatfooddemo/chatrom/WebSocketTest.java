package com.example.laowa.eatfooddemo.chatrom;

/*
 *
 * Created by Administrator on 2017/10/15.
 */
import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;


import java.net.URI;
import java.net.URISyntaxException;


public class WebSocketTest {
    private static WebSocketClient webSocketClient;

    private WebSocket webSocket;
    public void test() throws URISyntaxException {
        webSocketClient = new WebSocketClient(new URI("ws://localhost:8080atRoom/CS-ZLF/1-1")) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("open");
                webSocketClient.send("链接成功");
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

    }

    public static void main(String[] args) throws URISyntaxException {
        WebSocketTest webSocketTest = new WebSocketTest();
        webSocketTest.test();
    }

}