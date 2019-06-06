/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author seba
 */
public class AVLNodeTest {
    
    private AVLNode<String> createNode(int value) {
        return new AVLNode<>(value, "");
    }
    
    @Test
    public void rightRotate() {
        /* Initial              Expected
        
                30                20
               /                 /  \
              20      ====>     10  30
             /      
            10      
        */
        
        AVLNode<String> node = createNode(30);
        node.insertar(createNode(20));
        AVLNode<String> newRoot = node.insertar(createNode(10));
        
        AVLNode<String> l = newRoot.getHijoIzq();
        AVLNode<String> r = newRoot.getHijoDer();
        
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, l.getEtiqueta());
        assertEquals(30, r.getEtiqueta());
        
        assertEquals(0, newRoot.getBalance());
        assertEquals(0, l.getBalance());
        assertEquals(0, r.getBalance());
    }
    
    @Test
    public void rightRotatetWithRightChildren() {
        /*    Initial                Expected
        
                30                      20
               /  \                    /  \
             20    40                10    30
            /  \        ====>        /     / \
           10   25                  0     25  40
          /   
         0    
        
        */
        AVLNode<String> node = createNode(30);
        node.insertar(createNode(40));
        node.insertar(createNode(20));
        node.insertar(createNode(10));
        node.insertar(createNode(25));
        AVLNode<String> newRoot = node.insertar(createNode(0));
        
        AVLNode<String> l = newRoot.getHijoIzq();
        AVLNode<String> ll = newRoot.getHijoIzq().getHijoIzq();
        AVLNode<String> r = newRoot.getHijoDer();
        AVLNode<String> rr = newRoot.getHijoDer().getHijoDer();
        AVLNode<String> rl = newRoot.getHijoDer().getHijoIzq();
        
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, l.getEtiqueta());
        assertEquals(0, ll.getEtiqueta());
        assertEquals(30, r.getEtiqueta());
        assertEquals(40, rr.getEtiqueta());
        assertEquals(25, rl.getEtiqueta());
        
        assertEquals(0, newRoot.getBalance());
        assertEquals(-1, l.getBalance());
        assertEquals(0, ll.getBalance());
        assertEquals(0, r.getBalance());
        assertEquals(0, rr.getBalance());
        assertEquals(0, rl.getBalance());
    }
    
    @Test
    public void leftRotate() {
        /* Initial              Expected
        
            10                      20
              \                    /  \
               20       ====>     10  30
                \
                 30
        */
        
        AVLNode<String> node = createNode(10);
        node.insertar(createNode(20));
        AVLNode<String> newRoot = node.insertar(createNode(30));
        
        AVLNode<String> l = newRoot.getHijoIzq();
        AVLNode<String> r = newRoot.getHijoDer();
        
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, l.getEtiqueta());
        assertEquals(30, r.getEtiqueta());        
        
        assertEquals(0, newRoot.getBalance());
        assertEquals(0, l.getBalance());
        assertEquals(0, r.getBalance());        
    }
    
    @Test
    public void leftRotatetWithLeftChildren() {
        /* Initial              Expected
        
             10                      20
            /  \                    /  \
           5   20       ====>     10    30
              / \                 /\     \
             15  30              5  15   40
                  \
                   40
        */
        AVLNode<String> node = createNode(10);
        node.insertar(createNode(5));
        node.insertar(createNode(20));
        node.insertar(createNode(15));
        node.insertar(createNode(30));
        AVLNode<String> newRoot = node.insertar(createNode(40));        

        AVLNode<String> l = newRoot.getHijoIzq();
        AVLNode<String> r = newRoot.getHijoDer();
        AVLNode<String> lr = l.getHijoDer();
        AVLNode<String> ll = l.getHijoIzq();
        AVLNode<String> rr = r.getHijoDer();
        
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, l.getEtiqueta());
        assertEquals(15, lr.getEtiqueta());
        assertEquals(5, ll.getEtiqueta());
        assertEquals(30, r.getEtiqueta());
        assertEquals(40, rr.getEtiqueta());
        
        assertEquals(0, newRoot.getBalance());
        assertEquals(0, l.getBalance());
        assertEquals(0, lr.getBalance());
        assertEquals(0, ll.getBalance());
        assertEquals(1, r.getBalance());
        assertEquals(0, rr.getBalance());
    }
    
    @Test
    public void leftRightRotate() {
        /*    Initial                Expected
        
                30                      25
               /  \                    /  \
             20    40                20    30
            /  \          ====>      /     / \
           10  25                   10    28  40
                \
                28
        
        */
        AVLNode<String> node = createNode(30);
        node.insertar(createNode(40));
        node.insertar(createNode(20));
        node.insertar(createNode(10));
        node.insertar(createNode(25));
        AVLNode<String> newRoot = node.insertar(createNode(28));
        
        AVLNode<String> l = newRoot.getHijoIzq();
        AVLNode<String> ll = l.getHijoIzq();
        AVLNode<String> r = newRoot.getHijoDer();
        AVLNode<String> rr = r.getHijoDer();
        AVLNode<String> rl = r.getHijoIzq();
        
        assertEquals(25, newRoot.getEtiqueta());
        assertEquals(20, l.getEtiqueta());
        assertEquals(10, ll.getEtiqueta());
        assertEquals(30, r.getEtiqueta());
        assertEquals(40, rr.getEtiqueta());
        assertEquals(28, rl.getEtiqueta());
        
        assertEquals(0, newRoot.getBalance());
        assertEquals(-1, l.getBalance());
        assertEquals(0, r.getBalance());
        assertEquals(0, ll.getBalance());
        assertEquals(0, rl.getBalance());
        assertEquals(0, rr.getBalance());
    }
    
    @Test
    public void rightLeftRotate() {
        /* Initial                Expected
        
            10                          15
           /  \                        /  \
         5     20                    10   20
              /  \        ====>     / \     \
             15  25                5   13    25
            /     
           13     

        */
        AVLNode<String> node = createNode(10);
        node.insertar(createNode(5));
        node.insertar(createNode(20));
        node.insertar(createNode(25));
        node.insertar(createNode(15));
        AVLNode<String> newRoot = node.insertar(createNode(13));
        
        AVLNode<String> l = newRoot.getHijoIzq();
        AVLNode<String> r = newRoot.getHijoDer();
        AVLNode<String> ll = l.getHijoIzq();
        AVLNode<String> lr = l.getHijoDer();
        AVLNode<String> rr = r.getHijoDer();
        
        assertEquals(15, newRoot.getEtiqueta());
        assertEquals(10, l.getEtiqueta());
        assertEquals(5, ll.getEtiqueta());
        assertEquals(13, lr.getEtiqueta());
        assertEquals(20, r.getEtiqueta());
        assertEquals(25, rr.getEtiqueta());
        
        assertEquals(0, newRoot.getBalance());
        assertEquals(0, l.getBalance());
        assertEquals(1, r.getBalance());
        assertEquals(0, ll.getBalance());
        assertEquals(0, lr.getBalance());
        assertEquals(0, rr.getBalance());
    }    
}
