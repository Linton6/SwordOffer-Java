package others.coreJava;

import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author Linton
 * @Date 2019/7/6 17:34
 * @Email lintonhank@foxmail.com
 * @Version 1.0
 * @Description
 */

public class ThreadedEchoServer {
    public static void main(String[] args) throws IOException  {
        try{
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            while (true) {
                Socket incoming  = s.accept();
                System.out.println("Spawning " + i);

                Runnable r = new ThreadEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This class handles the client input for one  server socket connection
     */
   static class ThreadEchoHandler implements Runnable {
        private Socket incoming;

        public ThreadEchoHandler(Socket i){
            incoming = i;
        }

        public void run() {
            try{
                try {
                    InputStream inStream = incoming.getInputStream();
                    OutputStream outStream = incoming.getOutputStream();

                    Scanner in = new Scanner(inStream);
                    PrintWriter out = new PrintWriter(outStream, true);

                    out.println("Hello , Enter Bye to exit.");
                    // echo client input
                    boolean done = false;
                    while (!done && in.hasNextLine()){
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE"))
                            done = true;
                    }
                }
                finally {
                    incoming.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

