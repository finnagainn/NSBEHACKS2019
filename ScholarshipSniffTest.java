import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class ScholarshipSniffTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   @Test public void womanTest() throws FileNotFoundException {
      ArrayList<String> s = new ArrayList<String>();
      
      String hair = "box braids";
      
      ScholarshipSniff sniff = new ScholarshipSniff(s);
      sniff = sniff.readFile("tiana.txt");
      
      Assert.assertTrue(sniff.isPossiblyBlackWoman(s));
      
   }
}
