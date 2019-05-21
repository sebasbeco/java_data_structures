/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import ds.interfaces.IElementoAB;


public class TElementoAB<T> implements IElementoAB<T> {
    
    Comparable etiqueta;
    T datos;
    TElementoAB<T> hijoIzq;
    TElementoAB<T> hijoDer;

    public TElementoAB(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    
    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {
        int compareResult = unaEtiqueta.compareTo(etiqueta);
        
        if (compareResult < 0)
            return hijoIzq.buscar(unaEtiqueta);
        if (compareResult > 0)
            return hijoDer.buscar(unaEtiqueta);
        
        return this;
    }

    @Override
    public boolean insertar(TElementoAB<T> elemento) {
        int compareResult = elemento.etiqueta.compareTo(etiqueta);
        
        if (compareResult < 0) 
        {
            if (hijoIzq == null) {
                hijoIzq = elemento;
                return true;
            }
            return hijoIzq.insertar(elemento);
        }
        if (compareResult > 0)
        {
            if (hijoDer == null) {
                hijoDer = elemento;
                return true;
            }
            return hijoDer.insertar(elemento);
        }
        // already exists, return false
        return false;
    }

    @Override
    public String inOrden() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inOrden(Object unaLista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerAltura() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerTamanio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int obtenerCantidadHojas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
