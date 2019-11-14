package org.putt.micronaut.passport.controller;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.putt.micronaut.passport.model.RequestFactory;
import org.putt.micronaut.passport.model.ResponseFactory;
import org.putt.micronaut.passport.service.Factory;
import org.putt.micronaut.passport.service.Util;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import java.util.List;

@ServerWebSocket("/load/{topic}")
public class LoadSocket {
    private WebSocketBroadcaster broadcaster;

    private static final String THIS_TOPIC = "LOAD";

    Factory factory;

    @Inject
    public LoadSocket(WebSocketBroadcaster broadcaster, Factory factory) {
        this.factory = factory;
        this.broadcaster = broadcaster;
    }

    @OnOpen
    public Publisher<List<ResponseFactory>> onOpen(String topic, WebSocketSession session) {
        return topic.equalsIgnoreCase(THIS_TOPIC) ? broadcaster.broadcast(factory.getAllFactories(), Util.isValid(topic)) : null;
    }



    @OnMessage
    public Publisher<List<ResponseFactory>> onMessage(
            String topic,
            String message,
            WebSocketSession session) {
        return topic.equalsIgnoreCase(THIS_TOPIC) ? broadcaster.broadcast(factory.getAllFactories(), Util.isValid(topic)) : null;

    }

    @OnClose
    public Publisher<String> onClose(
            WebSocketSession session) {
        String msg = "["+ THIS_TOPIC +"  Disconnected!";

        return broadcaster.broadcast(msg);
    }


}
