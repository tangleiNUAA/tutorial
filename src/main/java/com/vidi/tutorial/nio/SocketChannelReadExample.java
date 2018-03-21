package com.vidi.tutorial.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Base usage of TCP connect in nio.
 * @author tangleiNUAA
 */
public class SocketChannelReadExample {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
            ByteBuffer buffer = ByteBuffer.allocate(48);

            // Read the buffer
            int byteRead = socketChannel.read(buffer);

            while (byteRead != -1) {
                System.out.println(byteRead);
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.println((char) buffer.get());
                }

                buffer.clear();
                byteRead = socketChannel.read(buffer);
            }

            socketChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
