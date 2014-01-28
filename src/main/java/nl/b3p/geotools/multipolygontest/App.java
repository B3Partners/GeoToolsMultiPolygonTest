package nl.b3p.geotools.multipolygontest;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geotools.util.logging.Logging;


public class App 
{
    private static final Log log = LogFactory.getLog(App.class);
    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
        try{
            Logging.ALL.setLoggerFactory("org.geotools.util.logging.Log4JLoggerFactory");
        }catch (Exception e){
            log.error("While setting log4j for geotools",e);
        }
        
        GeotoolsOracleTest test = new GeotoolsOracleTest();
        test.test();
    }
}
