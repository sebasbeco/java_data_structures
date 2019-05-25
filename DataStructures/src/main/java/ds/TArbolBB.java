/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import ds.interfaces.IArbolBB;
import ds.TElementoAB;


public class TArbolBB<T> implements IArbolBB<T> {
    
    private TElementoAB<T> root;
    
    public TElementoAB<T> getRoot() {
        return root;
    }

    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (root != null) 
            return root.insertar(unElemento);
        root = unElemento;
        return true;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        if (root != null)
            return root.buscar(unaEtiqueta);
        return null;
    }

    @Override
    public String inOrden() {
        if (root != null)
            return root.inOrden();
        return "";
    }
    
    @Override
    public Lista<T> inorden() { // buen nombre?
        Lista<T> list = new Lista<>();
        if (root != null)
            root.inOrden(list);
        return list;
    }

    @Override
    public int obtenerAltura() {
        if (root != null)
            return root.obtenerAltura();
        return -1;
    }

    @Override
    public int obtenerTamanio() {
        if (root != null)
            return root.obtenerTamanio();
        return 0;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        if (root == null)
            return -1;
        return root.obtenerNivel(unaEtiqueta);
    }

    @Override
    public int obtenerCantidadHojas() {
        if (root == null)
            return 0;
        return root.obtenerCantidadHojas();
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (root != null)
            root = root.eliminar(unaEtiqueta);
    }
    
    public String postOrden() {
        if (root != null)
            return root.postOrden();
        return "";
    }
    
}
