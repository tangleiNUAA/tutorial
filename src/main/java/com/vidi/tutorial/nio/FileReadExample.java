package com.vidi.tutorial.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * base usage of RandomAccessFIle to read file.
 * @author tangleiNUAA
 */
public class FileReadExample {
    public static void main(String[] args) {
        try {
            // Use RandomAccessFile to get a instance of FileChannel.
            // Also can Use the static function open to create a instance.
            RandomAccessFile aFile = new RandomAccessFile(System.getProperty("user.dir") + "/data/file.txt", "rw");
            FileChannel channel = aFile.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // read into buffer
            int bytesRead = channel.read(buffer);

            while (bytesRead != -1) {
                System.out.println("Read" + bytesRead);
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());

                }

                buffer.clear();
                bytesRead = channel.read(buffer);
            }

            aFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
