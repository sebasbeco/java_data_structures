/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import ds.interfaces.INodo;


public class Nodo<T> implements INodo<T> {
    
    private Comparable etiqueta;
    private T dato;
    private Nodo<T> siguiente;

    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        siguiente = nodo;
    }

    @Override
    public void imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imprimirEtiqueta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
    
    public int compareTo(Nodo<T> other) {
        return compareTo(other.etiqueta);
    }
    
}
