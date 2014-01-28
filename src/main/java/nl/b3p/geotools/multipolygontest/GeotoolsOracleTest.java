/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.b3p.geotools.multipolygontest;

import com.vividsolutions.jts.geom.Geometry;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.oracle.OracleNGDataStoreFactory;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.filter.FilterFactory2;

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
        log.info("FeatureTypes: ");
        for (String s : ds.getTypeNames()){
            log.info(s);
        }
        
        FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
        FeatureSource fs = ds.getFeatureSource("WEGEN_WEGVAK");
        //FeatureCollection fc = fs.getFeatures(ff.equal(ff.property("STRAATNAAM"), ff.literal("Bleulandpad"),false));
        FeatureCollection fc = fs.getFeatures();
        FeatureIterator<SimpleFeature> fi = fc.features();
        while(fi.hasNext()){
            SimpleFeature sf = fi.next();
            Geometry geom = (Geometry)sf.getDefaultGeometry();
            StringBuffer sb = new StringBuffer();
            sb.append("Object id: ").append(sf.getAttribute("OBJ_ID"));
            sb.append(" straatnaam: ").append(sf.getAttribute("STRAATNAAM"));
            sb.append(" valid: ").append(geom.isValid());            
            log.info(sb.toString());
            //log.info(geom.toString());
            
        }
    }
}
