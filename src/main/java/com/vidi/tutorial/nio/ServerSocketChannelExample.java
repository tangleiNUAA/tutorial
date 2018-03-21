package com.vidi.tutorial.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * A channel to listen to TCP connection.
 * @author tangleiNUAA
 */
public class ServerSocketChannelExample {
    public static void main(String[] args) {
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(8080));
            ByteBuffer buffer = ByteBuffer.allocate(48);
            SocketChannel channel = server.accept();

            channel.read(buffer);
            System.out.println(new String(buffer.array(), "UTF-8"));

            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
