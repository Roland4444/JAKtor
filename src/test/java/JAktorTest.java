import se.roland.impl.JAktor;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class JAktorTest {

    @Test
    public void received_$eq() throws InterruptedException, IOException {
        JAktor la1=new JAktor();
        JAktor la2=new JAktor();
        la1.setAddress("http://127.0.0.1:5555/");
        la2.setAddress("http://127.0.0.1:7777/");
        la1.spawn();
        la2.spawn();
        Thread.sleep(1000);
        la1.send("hi".getBytes(),  la2.Address);
        Thread.sleep(500);
        assertEquals(new String("hi".getBytes()), new String(la2.received.getBytes()) );
        byte[] arr = Files.readAllBytes(new File("info").toPath());
        la1.send(arr,  la2.Address);

    }
}