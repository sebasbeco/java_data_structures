package ds;

import ds.interfaces.IElementoAB;


class AVLNode<T> extends TElementoAB<T> implements IElementoAB<T> {
    
    private int balance;
    
    public AVLNode(Comparable etiqueta, T datos) {
        super(etiqueta, datos);
    }
    
    public boolean insertar(AVLNode<T> node) {
        int compareResult = node.etiqueta.compareTo(etiqueta);
        
        if (compareResult < 0) {
            if (hijoIzq != null)
                hijoIzq.insertar(node);
            else
                hijoIzq = node;
            balance -= 1;
        }
        else {
            if (hijoDer != null)
                hijoDer.insertar(node);
            else
                hijoDer = node;
            balance += 1;
        }
        
        return false;
                    
    }
    
    public AVLNode<T> leftRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = (AVLNode)node.hijoDer;
        node.hijoDer = newRoot.hijoIzq;
        newRoot.hijoIzq = node;
        
//        updateBalance(node);
//        updateBalance(newRoot);
        
        return newRoot;
    }
    
    public AVLNode<T> rightRotate(AVLNode<T> node) {
        AVLNode<T> newRoot = (AVLNode)node.hijoIzq;
        node.hijoIzq = newRoot.hijoDer;
        newRoot.hijoDer = node;
        
//        updateBalance(node);
//        updateBalance(newRoot);
        
        return newRoot;
    }
    
    public AVLNode<T> leftRightRotate(AVLNode<T> node) {
        node.hijoIzq = leftRotate((AVLNode)node.hijoIzq);
        return rightRotate(node);
    }
    
    public AVLNode<T> rightLeftRotate(AVLNode<T> node) {
        node.hijoDer = rightRotate((AVLNode)node.hijoDer);
        return leftRotate(node);
    }
    
    public int getBalance() {
        return balance;
    }
    
}
