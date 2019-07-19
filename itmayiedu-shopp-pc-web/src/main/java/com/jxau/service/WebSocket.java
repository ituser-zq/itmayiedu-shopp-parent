package com.jxau.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @PackageName:com.jxau.service
 * @ClassName:WebSocket
 * @Description:
 * @Author: ZQ
 * @Date:2019/05/07 13:38
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> writeArraySet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session){
        this.session=session;
        writeArraySet.add(this);
        log.info("#######有新的连接#####");
    }

    @OnClose
    public void onClose(){
        writeArraySet.remove(this);
        log.info("###########收到客户发送的消息########");
    }

    public void sendMessage(String message){
        for (WebSocket webSocket:writeArraySet){
            log.info("##########广播消息{}#######",message);

        try {
            webSocket.session.getBasicRemote().sendText(message);

        }catch (IOException e){
            log.info(e.getLocalizedMessage());
        }

        }
    }

}
