package se.roland.aktor.abstrakt;

import se.roland.aktor.essent.Message;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void restoreMessage() {
        Message msg = new Message("message".getBytes(), "yrl");
        Message restored = Message.restoreMessage(Message.saveMessagetoByte(msg));
        assertEquals(new String(msg.message), new String(restored.message));
        System.out.println(msg.message);
        System.out.println(restored.message);
        assertEquals(msg.Address, restored.Address);
        System.out.println(restored.Address);
    }
}