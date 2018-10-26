package impl;

import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

public class JAktorTest {

    @Test
    public void getURL_thisAktor() throws UnknownHostException {
        JAktor jk = new JAktor();
        jk.setAddress("http://127.0.0.1:17777/");
        assertEquals("http://80.87.98.54:17777/", jk.getURL_thisAktor());
    }
}