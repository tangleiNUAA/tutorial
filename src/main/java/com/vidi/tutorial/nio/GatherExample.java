package com.vidi.tutorial.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Multiple buffer write to one channel.
 * @author tangleiNUAA
 */
public class GatherExample {
    public static void main(String[] args){
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        header.put("Content-Type: text/plain".getBytes());
        header.flip();
        body.put("Hello, world!".getBytes());
        body.flip();

        ByteBuffer[] bufferArray = {header, body};

        // Use "curl" to to get the message.
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(8080));
            SocketChannel channel = server.accept();
            channel.write(bufferArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
