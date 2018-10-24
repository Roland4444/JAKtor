package se.roland.se.roland.abstrakt;

import se.roland.se.roland.essentials.Message;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void restoreMessage() {
        Message msg = new Message("message".getBytes(), "yrl");
        Message restored = Message.restoreMessage(Message.saveMessagetoByte(msg));
        assertEquals(msg.message, restored.message);
        System.out.println(msg.message);
        System.out.println(restored.message);
        assertEquals(msg.Address, restored.Address);
        System.out.println(restored.Address);
    }
}