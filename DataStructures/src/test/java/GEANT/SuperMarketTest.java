/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEANT;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author seba
 */
public class SuperMarketTest {
    
    private SuperMarket s;
    
    @Before
    public void setup() {
        s = new SuperMarket();
    }

    @Test
    public void testAddNewProduct() {
        Product fideos = new Product("fideos", "123", 20, 1);
        s.addNewProduct(fideos);
        
        assertEquals("fideos", s.getProduct("123").getName());
    }
    
}
