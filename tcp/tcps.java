import java.io.*;
import java.net.*;
import java.util.*;
public class tcps {

    public static void main(String[] args)throws IOException {
        ServerSocket ss=new ServerSocket(1234);
        Socket con=ss.accept();
        DataInputStream in =new DataInputStream(con.getInputStream());
        DataOutputStream out=new DataOutputStream(con.getOutputStream());
        String msg;
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            msg=in.readUTF();
            System.out.println("Client Says: "+msg);
            System.out.println("(from server) message to client: ");
            msg=sc.nextLine();
            out.writeUTF(msg);
        }
    }
}
