/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author seba
 */
public class TArbolBBTest {
    
    private TArbolBB<Integer> tree;
    
    @Before
    public void setup() {
        tree = new TArbolBB<>();
    }
    
    private TElementoAB<Integer> insert(int val) {
        TElementoAB<Integer> node = new TElementoAB<>(val, 0);
        tree.insertar(node);
        return node;
    }
    
    private void insertMany() {
        insert(50);
        insert(23);
        insert(3);
        insert(87);
        insert(99);
        insert(26);
        insert(43);
        insert(2);
    }
    
    @Test
    public void insert() {
        insert(10);
        assertEquals(10, tree.getRoot().getEtiqueta());
        
        insert(20);
        assertEquals(20, tree.getRoot().getHijoDer().getEtiqueta());
        assertNull(tree.getRoot().getHijoIzq());
        
        insert(5);
        assertEquals(5, tree.getRoot().getHijoIzq().getEtiqueta());
        assertEquals(20, tree.getRoot().getHijoDer().getEtiqueta());
    }
    
    @Test
    public void buscar() {
        insertMany();
        assertEquals(2, tree.buscar(2).getEtiqueta());
        assertNull(tree.buscar(93208));
    }
    
    @Test
    public void inOrden() {
        assertEquals("", tree.inOrden());
        
        insertMany();
        assertEquals("2 3 23 26 43 50 87 99", tree.inOrden());
    }
    
    @Test
    public void altura() {
        assertEquals(-1, tree.obtenerAltura());
        
        insertMany();
        assertEquals(3, tree.obtenerAltura());
    }
    
    @Test 
    public void tamanio() {
        assertEquals(0, tree.obtenerTamanio());
        
        insertMany();
        assertEquals(8, tree.obtenerTamanio());
    }
    
    @Test
    public void nivel() {
        assertEquals(-1, tree.obtenerNivel(999999));    // non existent
        
        insertMany();
        assertEquals(0, tree.obtenerNivel((50)));
        assertEquals(1, tree.obtenerNivel((23)));
        assertEquals(1, tree.obtenerNivel(87));
        assertEquals(2, tree.obtenerNivel(3));
        assertEquals(2, tree.obtenerNivel(26));
        assertEquals(2, tree.obtenerNivel(99));
        assertEquals(3, tree.obtenerNivel(2));
        assertEquals(3, tree.obtenerNivel(43));
    }   
    
    @Test
    public void eliminar() {
        tree.eliminar(99999); // non existent, nothing should happen
        
        insertMany();
        tree.eliminar(99);   // delete leaf
        assertEquals("2 3 43 26 23 87 50", tree.postOrden());
        
        tree.eliminar(3);     // delete node with one left child
        assertEquals("2 43 26 23 87 50", tree.postOrden());
        
        tree.eliminar(26);    // delete node with one right child
        assertEquals("2 43 23 87 50", tree.postOrden());
        
        tree.eliminar(50);      // delete root
        assertEquals("2 23 87 43", tree.postOrden());
    }
}
