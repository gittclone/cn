import java.io.*;
import java.net.*;
public class client {
    public static void main(String[] args) {
        try{
            System.out.println("------------client1-------------");
            client c =new client();
            int tp=2000;
            int r=0;
            int tb=0;
            for(int i=1;i<=15;i++)
            {
                System.out.println("attempt"+i);
                if(c.send()=="sent")
                {
                    break;
                }
                else{
                    r=2^i-1;
                    System.out.println("random Numbers: "+r);
                    tb=r*tp;
                    System.out.println("waiting for next connection: "+tb);
                    Thread.sleep(tb);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    String send()
    {
        String str=null;
        String msg="CNLAB";
        try{
            Socket s =new Socket("localhost",1234);
            ObjectOutputStream out=new ObjectOutputStream(s.getOutputStream());
            out.writeObject(msg);
            System.out.println("message sent: "+msg);
            str="sent";
        }
        catch(Exception e){
            str="collision occured";
            System.out.println("message sent: "+msg);
        }
        return str;
    }
}
