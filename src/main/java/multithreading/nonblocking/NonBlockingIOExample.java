package multithreading.nonblocking;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingIOExample {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();

        //Set channel to non-blocking
        socketChannel.configureBlocking(false);

        //connect to server
        socketChannel.connect(new java.net.InetSocketAddress("example.com", 80));
        while (!socketChannel.finishConnect()){
            System.out.println("Still connecting.....");
            //Wait  or do some other work.
        }

        //Write data to the channel
        ByteBuffer buffer = ByteBuffer.wrap("Hello,Server!".getBytes());
        while (buffer.hasRemaining())
            socketChannel.write(buffer);

        //Read data from the channel
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(readBuffer);
        if(bytesRead > 0) {
            readBuffer.flip();
            byte[] data = new byte[bytesRead];
            readBuffer.get(data);
            System.out.println("Received: " + new String(data));
        }

        socketChannel.close();
    }
}
