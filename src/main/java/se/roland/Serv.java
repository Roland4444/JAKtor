package se.roland;

import se.roland.impl.JAktor;
import io.javalin.Javalin;


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
