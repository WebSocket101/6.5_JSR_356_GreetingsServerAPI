package GreetingsServerAPI;

import java.io.IOException;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class GreetingsServer_API extends Endpoint {

    @Override
    public void onOpen(final Session session, EndpointConfig ec) {
        System.out.println("New session "+session.getId());
        
        session.addMessageHandler(new MessageHandler.Whole<String>() {

            @Override
            public void onMessage(String name) {
                try {
                    session.getBasicRemote().sendText("Dear " + name);
                } catch (IOException ex) {
                }
            }
        });
    }
    
    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Session " + session.getId() + " beendet");
        System.out.println(closeReason);
    }
}
