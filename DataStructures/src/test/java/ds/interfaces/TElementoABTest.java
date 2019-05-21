/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.interfaces;

import ds.TElementoAB;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author seba
 */
public class TElementoABTest {
    
    private TElementoAB<Integer> root;
    
    private void insert(Comparable val) {
        TElementoAB<Integer> newNode = new TElementoAB<>(val, 0);
        root.insertar(newNode);
    }
    
    @Test
    public void insertar() {
        root = new TElementoAB<>(10, 0);
        assertEquals(10, root.getEtiqueta());
        
        insert(5);
        assertEquals(5, root.getHijoIzq().getEtiqueta());
        
        insert(25);
        assertEquals(25, root.getHijoDer().getEtiqueta());
    }
    
    @Test
    public void buscar() {
        root = new TElementoAB<>(20, 0);
        assertEquals(20, root.buscar(20).getEtiqueta());
        
        insert(30);
        insert(25);
        insert(21);
        insert(40);
        assertEquals(40, root.buscar(40).getEtiqueta());
        
        insert(19);
        insert(18);
        insert(17);
        insert(5);
        insert(1);
        assertEquals(1, root.buscar(1).getEtiqueta());
    }
    
}
