import java.io.*;
import java.net.Socket;
import java.util.*;
public class tcpc {

    public static void main(String[] args)throws IOException{
        Socket s =new Socket("localhost",1234);
        DataInputStream in =new DataInputStream(s.getInputStream());
        DataOutputStream out=new DataOutputStream(s.getOutputStream());
        String msg;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("(from client)message from server: ");
            msg=sc.nextLine();
            out.writeUTF(msg);
            msg=in.readUTF();
            System.out.println("server says: "+msg);
        }
    }
}
