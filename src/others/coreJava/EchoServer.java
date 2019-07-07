package others.coreJava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/7/6 16:32
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class EchoServer {
    public static void main(String[] args) throws IOException {
        // establis server socket
        try(ServerSocket s = new ServerSocket(8189)) {
            // wait for client connection
            try(Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();  // server
                OutputStream outputStream = incoming.getOutputStream();

                try(Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(outputStream, true /* autoFlush*/ );
                    out.println("Hello! Enter Bye to exit.");

                    // echo client input
                    boolean done = false;

                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("Bye"))
                            done = true;
                    }
                }
            }
        }
    }
}

