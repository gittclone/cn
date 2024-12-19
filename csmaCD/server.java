import java.io.*;
import java.net.*;

public class server {
    public static void main(String[] args) {
        try{
            System.out.println("------------client2-----------");
            ServerSocket ss=new ServerSocket(1234);
            System.out.println("Waiting for connection");
            Socket con=ss.accept();
            System.out.println("connected");
            ObjectInputStream in=new ObjectInputStream(con.getInputStream());
            System.out.println((String)in.readObject());
            in.close();
            ss.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
