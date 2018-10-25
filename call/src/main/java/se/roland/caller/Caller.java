package se.roland.caller;

import impl.JAktor;

public class Caller {
    public static void main(String[] args) throws InterruptedException {
         JAktor la1=new JAktor();
         la1.Address="http://127.0.0.1:16655";
         la1.spawn();
    }
}
