/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seba
 */
public class NodoTest {
    
    @Test
    public void compare() {
        Nodo<String> bigger = new Nodo<>("zzz", "foo");
        Nodo<String> smaller = new Nodo<>("aaa", "foo");
        
        assertTrue(bigger.compareTo(smaller) > 0);
    }
    
}
