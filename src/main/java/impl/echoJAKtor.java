package impl;

import java.io.FileOutputStream;
import java.io.IOException;

public class echoJAKtor extends JAktor {
    public byte[] buffer;
    @Override
    public void receive(byte[] message) throws IOException {
        this.received=new String(message);
        this.buffer=message;
        System.out.println("RECEIVED=>"+received);
    }
}
