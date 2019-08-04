package filereader;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class ClientTest {

    @Test(expected = IllegalArgumentException.class)
    public void testClient() {
        Client.main(new String[]{});
    }

    @Test
    public void testValidArgumentsExpectReportGenerated()
    {
        Client.main(new String[]{"/tmp/input.csv", "/tmp/output.csv"});
        assertTrue(new File("/tmp/output.csv").exists());
    }
}