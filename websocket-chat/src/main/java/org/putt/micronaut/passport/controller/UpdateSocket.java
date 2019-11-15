package org.putt.micronaut.passport.controller;

import io.micronaut.websocket.WebSocketBroadcaster;
import io.micronaut.websocket.WebSocketSession;
import io.micronaut.websocket.annotation.OnClose;
import io.micronaut.websocket.annotation.OnMessage;
import io.micronaut.websocket.annotation.ServerWebSocket;
import org.putt.micronaut.passport.model.request.UpdateFactoryRequest;
import org.putt.micronaut.passport.model.response.FactoryResponse;
import org.putt.micronaut.passport.service.Factory;
import org.putt.micronaut.passport.service.Util;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import java.util.List;

@ServerWebSocket("/update/{topic}")
public class UpdateSocket {
    private WebSocketBroadcaster broadcaster;


    private static final String THIS_TOPIC = "update";
    private Factory factory;

    @Inject
    public UpdateSocket(WebSocketBroadcaster broadcaster, Factory factory) {
        this.factory = factory;
        this.broadcaster = broadcaster;
    }

    @OnMessage
    public Publisher<List<FactoryResponse>> onMessage(
            String topic,
            UpdateFactoryRequest updateFactoryRequest,
            WebSocketSession session) {
        factory.updateResponseFactory(updateFactoryRequest);
        return topic.equalsIgnoreCase(THIS_TOPIC) ? broadcaster.broadcast(factory.getAllFactories(), Util.isValid(topic)) : null;
    }


    @OnClose
    public Publisher<String> onClose(
            WebSocketSession session) {
        String msg = "["+ THIS_TOPIC +"  Disconnected!";

        return broadcaster.broadcast(msg);
    }

}
