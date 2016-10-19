package hu.bme.soft.arch.colleaguestore.client;

import com.google.gwt.junit.client.GWTTestCase;

public class SandboxGwtTest extends GWTTestCase {
    @Override
    public String getModuleName() {
        return "hu.bme.soft.arch.colleaguestore.MyProject";
    }

    public void testSandbox() {
        assertTrue(true);
    }
}