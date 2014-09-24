import com.carebears.CareBearHttpHandler;
import com.carebears.CareBearSocket;
import com.carebears.FakeHttpHandler;
import com.carebears.InternetSocket;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;

import static org.junit.Assert.assertEquals;

public class InternetSocketTest {
    CareBearHttpHandler handler;

    @Before
    public void setup() {
        handler = new FakeHttpHandler();
    }

    @Test
    public void StartsTheSocket() throws Exception
    {
        InetAddress host = InetAddress.getLocalHost();
        final CareBearSocket socket = new InternetSocket();

        new Thread() {
            public void run() {
                socket.start(handler);
            }
        }.start();

        java.net.Socket client = new java.net.Socket(host.getHostName(), 5000);

        try {
            PrintWriter out = new PrintWriter(client.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            out.println("Test");
            out.flush();

            assertEquals("Test", in.readLine());
        }
        finally {
            client.close();
        }

    }

}
