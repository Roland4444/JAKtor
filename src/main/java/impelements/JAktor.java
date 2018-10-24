package impelements;

import abstrakt.Aktor;
import essentials.Client;
import essentials.J11Client;
import essentials.Message;
import java.io.FileOutputStream;
import java.io.IOException;
import io.javalin.Javalin;


public class JAktor extends Aktor {
    Message msg = new Message("".getBytes(), "");
    Client client = new J11Client();
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
        Serv serv = new Serv();
        serv.setAktor(this);
        serv.start();

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

   @Override
   public void run(){
        System.out.println("aktor adress//>"+aktor.Address);
        Javalin app = Javalin.create().start(aktor.getPortFromURL(aktor.Address));
        System.out.println("STARTING JAVALIN on"+aktor.getPortFromURL(aktor.Address));
        app.post("/", ctx -> aktor.receive(ctx.bodyAsBytes()));
    }

    public void setAktor(JAktor inp) {
        this.aktor=inp;
    }
}
