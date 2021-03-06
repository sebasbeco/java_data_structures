package ds.interfaces;


import ds.Lista;
import ds.TElementoAB;
import java.util.LinkedList;

public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();
    
    public T getDatos();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public IElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public IElementoAB<T> getHijoDer();

    
    public void setHijoIzq(IElementoAB<T> node);
    
    public void setHijoDer(IElementoAB<T> node);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public IElementoAB<T> buscar(Comparable unaEtiqueta);

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public boolean insertar(IElementoAB<T> elemento);
  
    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

     /**
     * pone las etiquetas del recorrido en inorden en una TLista.
     *
     * @param unaLista
     */
    public void inOrden(Lista<T> unaLista);

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
	
    /**
    * Retorna la altura del arbol cuya raiz es la del nodo actual.
    * @return Altura del subarbol.
    */
    public int obtenerAltura();

    /**
     * Retorna el tamaño del arbol cuya raiz es la del nodo actual.
     * @return tamaño del subarbol.
     */
    public int obtenerTamanio();

    /**
     * Retorna el nivel del elemento cuya etiqueta es la pasada por par�metro.
     * @param unaEtiqueta
     * @return Nivel
     */
    public int obtenerNivel(Comparable unaEtiqueta);

    /**
     * Retorna la cantidad de hojas del arbol cuya raiz es la del nodo actual.
     * @return Cantidad de hojas del subarbol.
     */
    public int obtenerCantidadHojas();

    public IElementoAB eliminar(Comparable unaEtiqueta);
    
    public void preOrden(Lista<T> unaLista);
    
    public void postOrden(Lista<T> unaLista);
    
}




