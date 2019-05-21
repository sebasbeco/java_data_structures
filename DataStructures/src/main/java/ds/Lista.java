/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import ds.interfaces.ILista;


public class Lista<T> implements ILista<T> {
    
    private Nodo<T> primero;
    private int largo;

    @Override
    public void insertar(Nodo<T> nodo) {
        if (esVacia())
            primero = nodo;
        else {
            Nodo<T> current = primero;
            while (current.getSiguiente() != null)
                current = current.getSiguiente();
            current.setSiguiente(nodo);
        }
        largo += 1;
    }

    @Override
    public Nodo<T> buscar(Comparable clave) {
        if (esVacia())
            return null;
        
        Nodo<T> current = primero;
        while (current != null && current.compareTo(clave) != 0)
            current = current.getSiguiente();
        return current;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        largo -= 1;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String imprimir(String separador) {
        if (esVacia())
            return "";
        
        StringBuilder builder = new StringBuilder();
        Nodo<T> current = primero;
        while (current != null) {
            builder.append(current.getEtiqueta());
            builder.append(separador);
            current = current.getSiguiente();
        }
        builder.deleteCharAt(builder.length() - 1); // remove last sep
        return builder.toString();
    }

    @Override
    public int cantElementos() {
        return largo;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
    
}
