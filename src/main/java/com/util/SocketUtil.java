package com.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class SocketUtil {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            while (true){
                Socket socket = server.accept();
                byte[] req = new byte[1024];
                socket.getInputStream().read(req);
                System.out.println(new String(req));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                bw.write("HTTP/1.1 200 OK \n\nTime:"+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
                bw.flush();
                bw.close();
                System.out.println("--------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
