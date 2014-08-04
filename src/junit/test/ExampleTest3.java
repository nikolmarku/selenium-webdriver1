package junit.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;

import junit.util.*;

/**
 * 
 * @author nikolmarku
 *
 */
@RunWith(ExtendedRunner.class)  
public class ExampleTest3 {  
     @Test  
     @Repeat(10)  
     public void sometimesFail() {  
          int rand = new Random().nextInt(3);  
          System.out.println("- : "+rand % 3 );
          if (rand % 3 == 0) {  
               fail();  
          }  
     }  
}  