package test.data;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data.InstanceReader;
import main.Configuration;

public class TSPLIBReader {
    @Test
    public void test() {
        InstanceReader instanceReader = new InstanceReader(Configuration.instance.dataFilePath);
        instanceReader.open();
        data.TSPLIBReader tspLibReader = new data.TSPLIBReader(instanceReader);
        assertEquals(280,tspLibReader.getCities().size());
    }
}