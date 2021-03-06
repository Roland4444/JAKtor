package impl;

import abstrakt.Aktor;
import essent.J11Client;
import essent.Message;
import essent.Client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import io.javalin.Javalin;


public class JAktor extends Aktor {
    private  Serv serv;
    public String getURL_thisAktor() throws UnknownHostException {
        InetAddress inetAddress = InetAddress. getLocalHost();
        String addr = inetAddress. getHostAddress();
        return "http://"+addr+":"+getPortFromURL(this.Address)+"/";
    }
    Message msg = new Message("".getBytes(), "");
    public Client client = new J11Client();
    public String received = "";
    public void setAddress(String adr){
        this.Address=adr;
    }
    @Override
    public void receive(byte[] message) throws IOException {
        this.received=new String(message);
        FileOutputStream fos=new FileOutputStream("RECZ");
        fos.write(message);
        fos.close();
    }

    @Override
    public int send(byte[] message, String address) throws IOException {
        return this.client.send((message), address);
    }

    @Override
    public void spawn() throws InterruptedException {
        serv = new Serv();
        serv.setAktor(this);
        serv.start();

    }

    @Override
    public void terminate(){
        System.out.print("\n\n\nSHUTTING DOWN JAVALIN.....\n\n\n");
        serv.stopJavalin();
        serv.stop();
        serv.interrupt();
    }

    public String rollbackAdressURL() throws UnknownHostException {
        InetAddress ip=null;
        String ipString = null;
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ipString = socket.getLocalAddress().getHostAddress();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

         return "http://"+ ipString+":"+getPortFromURL(this.Address)+"/";

       // return "http://"+ ip.getHostAddress()+":"+getPortFromURL(this.Address)+"/";
    }

    public String Address = "";

    public static void main(String[] args) throws InterruptedException {
        JAktor la1=new JAktor();
        la1.setAddress("http://127.0.0.1:15555/");
        la1.spawn();
    }

}

class Serv extends Thread{
   JAktor aktor=null;
   public Javalin app;
   @Override
   public void run(){
        System.out.println("se.roland.aktor adress//>"+aktor.Address);
        app = Javalin.create().start(aktor.getPortFromURL(aktor.Address));
        System.out.println("STARTING JAVALIN on"+aktor.getPortFromURL(aktor.Address));
        app.post("/", ctx -> aktor.receive(ctx.bodyAsBytes()));
        try {
           System.out.println("Rollback address=>"+aktor.rollbackAdressURL());
        } catch (UnknownHostException e) {
           e.printStackTrace();
        }
   }

    public void setAktor(JAktor inp) {
        this.aktor=inp;
    }

    public void stopJavalin(){
       app.stop();
    }
}
