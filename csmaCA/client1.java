import java.io.*;
import java.net.*;
public class client1
{
    public static void main(String[] args) {
        try{
        System.out.println("---------client1---------");
        client1 c=new client1();
        int r=0;
        Boolean b=false;
        for(int k=1;k<=15;k++)
        {
            System.out.println("attempt: "+k);
            System.out.println("is channel isidle: ");
            int i=0;
            while (true) {
                System.out.println(i=i+1);
                if(c.isidle())
                {
                    System.out.println("channel idle");
                    System.out.println("wait for time slot 5000");
                    Thread.sleep(5000);
                    System.out.println("is still idle");
                    if(c.isidle())
                    {
                        System.out.println("still idle");
                        r=2^k-1;
                        System.out.println("random nuumber: "+r);
                        System.out.println("wait for r time slot: "+r*6000);
                        Thread.sleep(r*6000);
                        System.out.println("message sent - hello world");
                        System.out.println("wait for time slot"+10000);
                        Thread.sleep(10000);
                        if(c.isidle())
                        {
                            System.out.println("ack received");
                            b=true;
                            break;
                        }
                        else
                        {
                            System.out.println("ack not recevied");
                            break;
                        }
                    }
                    else{
                        System.out.println("server is busy,retying....");
                        break;
                    } 
                }
            }
            if(b==true)
            {
                break;
            }
        }
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
}
Boolean isidle()
{
    try{
        Socket s=new Socket("localhost",1234);
        s.close();
        return true;
    }
    catch(Exception e)
    {
        return false;
    }
}
}
