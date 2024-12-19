import java.io.*;
import java.net.*;
public class server1 {

    public static void main(String[] args) {
        try{
            System.out.println("---------client2--------");
            while(true)
            {
                ServerSocket ss=new ServerSocket(1234);
                System.out.println("waiting for connection");
                ss.accept();
                ss.close();
                System.out.println("connected");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}