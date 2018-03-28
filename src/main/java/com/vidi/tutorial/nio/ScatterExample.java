package com.vidi.tutorial.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Multiple buffer read from one channel.
 * Often use for getting the head and body.
 * @author tangleiNUAA
 */
public class ScatterExample {
    public static void main(String[] args){
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufferArray = {header, body};
        // You can use curl to send message to this ServerSocketChannel, and watch the result.
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(8080));
            SocketChannel channel = server.accept();
            channel.read(bufferArray);

            System.out.println(new String(bufferArray[0].array(), "UTF-8"));
            System.out.println(new String(bufferArray[1].array(), "UTF-8"));
            channel.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
