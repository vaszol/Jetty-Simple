package ru.vaszol;
/**
 * Created by vas on 01.09.2015.
 */
import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import javax.servlet.http.HttpServletRequest;

public class SampleWebSocketServlet extends WebSocketServlet {

    @Override
    public WebSocket doWebSocketConnect(HttpServletRequest httpRequest, String protocol) {
        final String id = httpRequest.getParameter("id");
        return new WebSocket.OnTextMessage() {

            @Override
            public void onMessage(String data) {
                System.out.println(id + " message > " + data);
            }

            @Override
            public void onOpen(WebSocket.Connection connection) {
                System.out.println(id + " open");
            }

            @Override
            public void onClose(int closeCode, String message) {
                System.out.println(id + " close");
            }
        };
    }
}