/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

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
    
    private TElementoAB<Integer> insert(Comparable val) {
        TElementoAB<Integer> newNode = new TElementoAB<>(val, 0);
        root.insertar(newNode);
        return newNode;
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
        
        assertNull(root.buscar(9999999));
        assertNull(root.buscar(-9999999));
    }
    
    @Test
    public void inOrden() {
        root = new TElementoAB<>(50, 0);
        insert(23);
        insert(26);
        insert(87);
        insert(3);
        insert(99);
        insert(2);
        insert(43);
        
        assertEquals("2 3 23 26 43 50 87 99", root.inOrden());
    }
    
    @Test
    public void preOrden() {
        root = new TElementoAB<>(50, 0);
        insert(23);
        insert(26);
        insert(87);
        insert(3);
        insert(99);
        insert(2);
        insert(43);
        
        assertEquals("50 23 3 2 26 43 87 99", root.preOrden());
    }
    
    @Test
    public void postOrden() {
        root = new TElementoAB<>(50, 0);
        insert(23);
        insert(26);
        insert(87);
        insert(3);
        insert(99);
        insert(2);
        insert(43);
        
        assertEquals("2 3 43 26 23 99 87 50", root.postOrden());
    }
    
    @Test
    public void obtenerAlturaUnicoNodo() {
        root = new TElementoAB<>(10, 0);
        assertEquals(0, root.obtenerAltura());
    }
    
    @Test 
    public void obtenerAlturaUnHijo() {
        root = new TElementoAB<>(10, 0);
        TElementoAB<Integer> node = insert(5);
        
        assertEquals(1, root.obtenerAltura());
        assertEquals(0, node.obtenerAltura());
    }
    
    @Test
    public void obtenerAlturaVariosHijos() {
        root = new TElementoAB<>(50, 0);
        insert(23);
        insert(26);
        insert(87);
        insert(3);
        insert(99);
        insert(2);
        insert(43);
        
        assertEquals(3, root.obtenerAltura());
    }
    
    @Test
    public void nivelPrimerHoja() {
        root = new TElementoAB<>(10, 0);
        assertEquals(0, root.obtenerNivel(10));
    }
    
    @Test
    public void nivel() {
        root = new TElementoAB<>(50, 0);
        insert(23);
        insert(26);
        insert(87);
        insert(3);
        insert(99);
        insert(2);
        insert(43);
        
        assertEquals(0, root.obtenerNivel(50));
        assertEquals(1, root.obtenerNivel(23));
        assertEquals(1, root.obtenerNivel(87));
        assertEquals(2, root.obtenerNivel(3));
        assertEquals(2, root.obtenerNivel(26));
        assertEquals(2, root.obtenerNivel(99));
        assertEquals(3, root.obtenerNivel(2));
        assertEquals(3, root.obtenerNivel(43));
    }
    
    @Test
    public void cantHojasUnicoNodo() {
        root = new TElementoAB<>(10, 0);
        assertEquals(1, root.obtenerCantidadHojas());
    }
    
    @Test
    public void cantHojasVariosNodos() {
        root = new TElementoAB<>(50, 0);
        TElementoAB<Integer> _23 = insert(23);
        TElementoAB<Integer> _26 = insert(26);
        TElementoAB<Integer> _87 = insert(87);
        TElementoAB<Integer> _3 = insert(3);
        TElementoAB<Integer> _99 = insert(99);
        TElementoAB<Integer> _2 = insert(2);
        TElementoAB<Integer> _43 = insert(43);
        
        assertEquals(3, root.obtenerCantidadHojas());
        assertEquals(2, _23.obtenerCantidadHojas());
        assertEquals(1, _26.obtenerCantidadHojas());
        assertEquals(1, _87.obtenerCantidadHojas());
        assertEquals(1, _3.obtenerCantidadHojas());
        assertEquals(1, _99.obtenerCantidadHojas());
        assertEquals(1, _2.obtenerCantidadHojas());
        assertEquals(1, _43.obtenerCantidadHojas());
    }
    
    @Test
    public void tamanio() {
        root = new TElementoAB<>(50, 0);
        TElementoAB<Integer> _23 = insert(23);
        TElementoAB<Integer> _26 = insert(26);
        TElementoAB<Integer> _87 = insert(87);
        TElementoAB<Integer> _3 = insert(3);
        TElementoAB<Integer> _99 = insert(99);
        TElementoAB<Integer> _2 = insert(2);
        TElementoAB<Integer> _43 = insert(43);
        
        assertEquals(8, root.obtenerTamanio());
        assertEquals(5, _23.obtenerTamanio());
        assertEquals(2, _26.obtenerTamanio());
        assertEquals(2, _87.obtenerTamanio());
        assertEquals(2, _3.obtenerTamanio());
        assertEquals(1, _99.obtenerTamanio());
        assertEquals(1, _2.obtenerTamanio());
        assertEquals(1, _43.obtenerTamanio());
    }
    
    @Test
    public void eliminar() {
        root = new TElementoAB<>(50, 0);
        insert(23);
        insert(26);
        insert(87);
        insert(3);
        insert(99);
        insert(2);
        insert(43);
        
        // delete leaf
        root.eliminar(99);
        assertEquals("2 3 43 26 23 87 50", root.postOrden());
        
        // delete node with one right child
        root.eliminar(26);
        assertEquals("2 3 43 23 87 50", root.postOrden());
        
        // delete node with one left child
        root.eliminar(3);
        assertEquals("2 43 23 87 50", root.postOrden());
        
        // delete node with twho children
        root.eliminar(23);
        assertEquals("43 2 87 50", root.postOrden());
        
        // delete root
        TElementoAB<Integer> newExpectedRoot = root.buscar(43);
        root.eliminar(50);
        assertEquals("2 87 43", newExpectedRoot.postOrden());
    }
}
