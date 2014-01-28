/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.b3p.geotools.multipolygontest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geotools.data.DataStore;
import org.geotools.data.oracle.OracleNGDataStoreFactory;

/**
 *
 * @author Roy Braam
 */
public class GeotoolsOracleTest {
    private static final Log log = LogFactory.getLog(GeotoolsOracleTest.class);
    
    public GeotoolsOracleTest() throws ClassNotFoundException{
        log.info("GeotoolsOracleTest");
    }
    
    public void test() throws IOException, ClassNotFoundException{
        Map p = new HashMap();
        
        p.put("dbtype","oracle");
        p.put("host","localhost");
        p.put("port", 1522);
        p.put("schema","dhv");
        p.put("database","gis");
        p.put("user","dhv");
        p.put("passwd","pw4dhv");
        
        //DataStore ds = DataStoreFinder.getDataStore(p);
        
        DataStore ds = new OracleNGDataStoreFactory().createDataStore(p);
        
        for (String s : ds.getTypeNames()){
            System.out.println(s);
        }
    }
}
