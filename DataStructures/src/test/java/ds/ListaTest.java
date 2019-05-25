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
public class ListaTest {
    
    private Lista<String> list;
    
    @Before
    public void setUp() {
        list = new Lista<>();
    }
    
    public void insert(String val) {
        Nodo<String> newNode = new Nodo<>(val, "");
        list.insertar(newNode);
    }
    
    @Test
    public void insert() {
        insert("foo");
        assertEquals("foo", list.imprimir(","));
        
        insert("bar");
        assertEquals("foo,bar", list.imprimir(","));
        
        insert("test");
        insert("test2");
        assertEquals("foo-bar-test-test2", list.imprimir("-"));
        
        assertEquals(4, list.cantElementos());
    }
    
    @Test
    public void buscar() {
        assertNull(list.buscar("non-existent"));
        
        insert("foo");
        assertEquals("foo", list.buscar("foo").getEtiqueta());
        
        insert("bar");
        insert("test");
        insert("chuuaka");
        
        assertEquals("chuuaka", list.buscar("chuuaka").getEtiqueta());
        assertNull(list.buscar("chucky"));
    }
    
    @Test
    public void eliminarVacia() {
        assertFalse(list.eliminar("non-existent"));
    }
    
    @Test
    public void eliminarPrimero() {
        insert("node1");
        assertEquals(1, list.cantElementos());
        assertTrue(list.eliminar("node1"));
        assertEquals(0, list.cantElementos());
    }
    
    @Test
    public void eliminarVarios() {
        insert("foo");
        insert("bar");
        insert("uruguay");
        insert("test");
        
        assertTrue(list.eliminar("foo"));
        assertEquals("bar", list.getPrimero().getEtiqueta());
        assertEquals(3, list.cantElementos());
        
        assertTrue(list.eliminar("uruguay"));
        assertEquals(2, list.cantElementos());
        
        assertTrue(list.eliminar("test"));
        assertEquals(1, list.cantElementos());
    }
    
}
