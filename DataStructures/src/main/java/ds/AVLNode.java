package ds;

import ds.interfaces.IElementoAB;
import static java.lang.Integer.max;


class AVLNode<T> {
    
    private Comparable etiqueta;
    private T datos;
    private AVLNode<T> hijoIzq;
    private AVLNode<T> hijoDer;
    private int balance;
    
    
    public AVLNode(Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
    }
    
    public Comparable getEtiqueta() {
        return etiqueta;
    }
    
    public T getDatos() {
        return datos;
    }
    
    public AVLNode<T> getHijoIzq() {
        return hijoIzq;
    }
    
    public AVLNode<T> getHijoDer() {
        return hijoDer;
    }
    
    public void setHijoIzq(AVLNode<T> node) {
        hijoIzq = node;
    }
    
    public void setHijoDer(AVLNode<T> node) {
        hijoDer = node;
    }
    
    public AVLNode<T> insertar(AVLNode<T> node) {
        int compareResult = node.etiqueta.compareTo(etiqueta);
        
        if (compareResult < 0) 
        {
            if (hijoIzq != null)
                hijoIzq = hijoIzq.insertar(node);
            else
                hijoIzq = node;
        }
        else 
        {
            if (hijoDer != null)
                hijoDer = hijoDer.insertar(node);
            else
                hijoDer = node;
        }
        
        return balance();
    }
    
    private AVLNode<T> balance() {
        updateBalance(this);
        
        if (balanced())
            return this;
        
        if (balance < -1) {
            if (hijoIzq.balance <= 0)   // left left
                return rightRotate(this);
            else 
                return leftRightRotate(this);
        }
        else {
            if (hijoDer.balance >= 0)   // right right
                return leftRotate(this);
            else
                return rightLeftRotate(this);
        }
    }
    
    public AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = node.hijoDer;
        node.hijoDer = newRoot.hijoIzq;
        newRoot.hijoIzq = node;
        
        updateBalance(node);
        updateBalance(newRoot);
        
        return newRoot;
    }
    
    public AVLNode<T> rightRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = node.hijoIzq;
        node.hijoIzq = newRoot.hijoDer;
        newRoot.hijoDer = node;
        
        updateBalance(node);
        updateBalance(newRoot);
        
        return newRoot;
    }
    
    public AVLNode<T> leftRightRotate(AVLNode<T> node) {
        node.hijoIzq = leftRotate(node.hijoIzq);
        return rightRotate(node);
    }
    
    public AVLNode<T> rightLeftRotate(AVLNode<T> node) {
        node.hijoDer = rightRotate(node.hijoDer);
        return leftRotate(node);
    }
    
    public int getBalance() {
        return balance;
    }
    
    private void updateBalance(AVLNode<T> node) {
        int newBalance = 0;
        
        if (node.hijoIzq != null)
            newBalance -= node.hijoIzq.obtenerAltura() + 1;
        if (node.hijoDer != null)
            newBalance += node.hijoDer.obtenerAltura() + 1;
        
        node.balance = newBalance;
    }
    
    public int obtenerAltura(){
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
    
    public boolean esHoja() {
        return hijoDer == null && hijoIzq == null;
    }

    public boolean balanced() {
        return balance >= -1 && balance <= 1;
    }
    
}
