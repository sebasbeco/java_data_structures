/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEANT;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seba
 */
public class ProductTest {
    
    @Test
    public void create() {
        Product p = new Product("fideos", "1234", 20);
        assertEquals("fideos", p.getName());
        assertEquals("1234", p.getId());
        assertEquals(20, p.getPrice(), 0.1);
        assertEquals(0, p.currentStock());
    }
    
}
