package com.vidi.tutorial.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * base usage of RandomAccessFIle to write file.
 * @author tangleiNUAA
 */
public class FileWriteExample {
    public static void main(String[] args) {
        try {
            RandomAccessFile aFile = new RandomAccessFile(System.getProperty("user.dir") + "/data/test_write.txt", "rw");
            FileChannel channel = aFile.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(48);
            buffer.clear();
            buffer.put("Hello, world!".getBytes());
            buffer.flip();

            channel.write(buffer);
            channel.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
