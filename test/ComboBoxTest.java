/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashMap;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Максим
 */
public class ComboBoxTest {
    
    private spending.ComboBox comboBoxTest = new spending.ComboBox();
    private HashMap<String, Integer> testUnsortedMap = new HashMap<>();
    private TreeMap<String, Integer> testSortedMap = new TreeMap<>();
    {
    testUnsortedMap.put("A", 2);
    testUnsortedMap.put("B", 12);
    testUnsortedMap.put("C", 1);
    testUnsortedMap.put("D", 4);
    testUnsortedMap.put("F", 8);
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Start test ...");
    }
    
    @After
    public void tearDown() {
        System.out.println("End test ...");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
