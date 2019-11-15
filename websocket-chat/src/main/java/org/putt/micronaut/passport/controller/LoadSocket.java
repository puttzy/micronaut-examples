package org.putt.micronaut.passport.controller;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.OnOpen;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.putt.micronaut.passport.model.response.FactoryResponse;
import org.putt.micronaut.passport.service.Factory;
import org.putt.micronaut.passport.service.Util;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import java.util.List;

@ServerWebSocket("/load/{topic}/{sessionId}")
public class LoadSocket {
    private WebSocketBroadcaster broadcaster;

    private static final String THIS_TOPIC = "LOAD";

    private Factory factory;

    @Inject
    public LoadSocket(WebSocketBroadcaster broadcaster, Factory factory) {
        this.factory = factory;
        this.broadcaster = broadcaster;
    }

    @OnOpen
    public Publisher<List<FactoryResponse>> onOpen(String topic, String sessionId, WebSocketSession session) {
        return topic.equalsIgnoreCase(THIS_TOPIC) ? broadcaster.broadcast(factory.getAllFactories(), Util.isValid(topic, sessionId)) : null;
    }



    @OnMessage
    public Publisher<List<FactoryResponse>> onMessage(
            String topic,
            String message,
            WebSocketSession session) {
        return topic.equalsIgnoreCase(THIS_TOPIC) ? broadcaster.broadcast(factory.getAllFactories(), Util.isValid(topic)) : null;

    }

    @OnClose
    public Publisher<String> onClose(
            String sessionId,
            WebSocketSession session) {
        String msg = "["+ THIS_TOPIC +"]  Disconnected!";

        return broadcaster.broadcast(msg, Util.isValid(sessionId));
    }


}
