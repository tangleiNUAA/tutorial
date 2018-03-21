package com.vidi.tutorial.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Write to SocketChannel
 * @author tangleiNUAA
 */
public class SocketChannelWriteExample {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            buffer.put("Hello, world!".getBytes());
            buffer.flip();

            socketChannel.write(buffer);
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
