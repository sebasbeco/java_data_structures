/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import ds.interfaces.IElementoAB;
import static java.lang.Integer.max;


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
        {
            if (hijoIzq != null)
                return hijoIzq.buscar(unaEtiqueta);
            return null;
        }
        else if (compareResult > 0)
        {
            if (hijoDer != null)
                return hijoDer.buscar(unaEtiqueta);
            return null;
        }
        return this;
    }
    
    // !! Cuidado que no soporta duplicados !!
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
    public void inOrden(Lista<T> unaLista) {
        if (hijoIzq != null)
            hijoIzq.inOrden(unaLista);
        unaLista.insertar(new Nodo(etiqueta, datos));
        if (hijoDer != null)
            hijoDer.inOrden(unaLista);
    }
    
    @Override
    public String inOrden() {
        Lista<T> inorderList = new Lista<>();
        inOrden(inorderList);
        return inorderList.imprimir(" ");
    }
    
    public void preOrden(Lista<T> unaLista) {
        unaLista.insertar(new Nodo(etiqueta, datos));
        if (hijoIzq != null)
            hijoIzq.preOrden(unaLista);
        if (hijoDer != null)
            hijoDer.preOrden(unaLista);   
    }
    
    public String preOrden() {
        Lista<T> preOrderList = new Lista<>();
        preOrden(preOrderList);
        return preOrderList.imprimir(" ");
    }
    
    public void postOrden(Lista<T> unaLista) {
        if (hijoIzq != null)
            hijoIzq.postOrden(unaLista);
        if (hijoDer != null)
            hijoDer.postOrden(unaLista);   
        unaLista.insertar(new Nodo(etiqueta, datos));
    }
    
    public String postOrden() {
        Lista<T> postOrderList = new Lista<>();
        postOrden(postOrderList);
        return postOrderList.imprimir(" ");
    }

    @Override
    public int obtenerAltura() {
        if (esHoja())
            return 0;
        
        int alturaIzq = 0;
        int alturaDer = 0;
        if (hijoIzq != null)
            alturaIzq += hijoIzq.obtenerAltura();
        if (hijoDer != null)
            alturaDer += hijoDer.obtenerAltura();
        
        return max(alturaIzq, alturaDer) + 1;
    }
    
    private boolean esHoja() {
        return hijoIzq == null && hijoDer == null;
    }
    
    
    // show throw exception, but interface does not allow it 
    @Override
    public int obtenerNivel(Comparable unaEtiqueta){
        int compareResult = unaEtiqueta.compareTo(etiqueta);
        
        if (compareResult < 0) {
            if (hijoIzq != null)
                return 1 + hijoIzq.obtenerNivel(unaEtiqueta);
        }
        else if (compareResult > 0) {
            if (hijoDer != null)
                return 1 + hijoDer.obtenerNivel(unaEtiqueta);
        }
        else {
            return 0;
        }
        
        return -1000000000;
    }
    
    @Override
    public int obtenerCantidadHojas() {
        if (esHoja())
            return 1;
        
        int hojasIzq = 0;
        int hojasDer = 0;
        if (hijoIzq != null)
            hojasIzq = hijoIzq.obtenerCantidadHojas();
        if (hijoDer != null)
            hojasDer = hijoDer.obtenerCantidadHojas();
        return hojasIzq + hojasDer;
    }

    @Override
    public int obtenerTamanio() {
        int t = 1;
        if (hijoIzq != null)
            t += hijoIzq.obtenerTamanio();
        if (hijoDer != null)
            t += hijoDer.obtenerTamanio();
        return t;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        int compareResult = unaEtiqueta.compareTo(etiqueta);
        
        if (compareResult < 0) {
            if (hijoIzq != null)
                hijoIzq = hijoIzq.eliminar(unaEtiqueta);
            return this;
        } else if (compareResult > 0) {
            if (hijoDer != null)
                hijoDer = hijoDer.eliminar(unaEtiqueta);
            return this;
        }
        return eliminar();
    }
    
    
    private TElementoAB eliminar() {
        // at most one child
        if (hijoIzq == null || hijoDer == null)
            return (hijoIzq != null) ? hijoIzq : hijoDer;
        
        // complete node
        TElementoAB<T> parent = this;
        TElementoAB<T> predecessor = this.hijoIzq;
        while (predecessor.hijoDer != null) {
            parent = predecessor;
            predecessor = predecessor.hijoDer;
        }
        
        if (parent != this) {
            parent.hijoDer = predecessor.hijoIzq;
            predecessor.hijoIzq = hijoIzq;
        }
        
        predecessor.hijoDer = hijoDer;
        return predecessor;
    }
}
