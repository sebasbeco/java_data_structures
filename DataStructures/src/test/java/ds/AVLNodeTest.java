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
        return new AVLNode<String>(value, "");
    }

    @Test
    public void testBalance() {
        AVLNode<String> node = createNode(10);
        assertEquals(0, node.getBalance());
        
        node.insertar(createNode(1));
        assertEquals(-1, node.getBalance());
        assertEquals(1, node.getHijoIzq().getEtiqueta());
        
        node.insertar(createNode(20));
        assertEquals(0, node.getBalance());
        assertEquals(20, node.getHijoDer().getEtiqueta());
        
        node.insertar(createNode(40));
        assertEquals(1, node.getBalance());
        assertEquals(40, node.getHijoDer().getHijoDer().getEtiqueta());
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
        node.setHijoDer(createNode(20));
        node.getHijoDer().setHijoDer(createNode(30));
        
        AVLNode<String> newRoot = node.leftRotate(node);
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, newRoot.getHijoIzq().getEtiqueta());
        assertEquals(30, newRoot.getHijoDer().getEtiqueta());
    }
    
    @Test
    public void leftRotatetWithLeftChildren() {
        /* Initial              Expected
        
            10                      20
              \                    /  \
               20       ====>    10    30
              / \                 \     \
             15  30                15   40
                  \
                   40
        */
        AVLNode<String> node = createNode(10);
        node.setHijoDer(createNode(20));
        node.getHijoDer().setHijoIzq(createNode(15));
        node.getHijoDer().setHijoDer(createNode(30));
        node.getHijoDer().getHijoDer().setHijoDer(createNode(40));
        
        AVLNode<String> newRoot = node.leftRotate(node);
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, newRoot.getHijoIzq().getEtiqueta());
        assertEquals(15, newRoot.getHijoIzq().getHijoDer().getEtiqueta());
        assertEquals(30, newRoot.getHijoDer().getEtiqueta());
        assertEquals(40, newRoot.getHijoDer().getHijoDer().getEtiqueta());
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
        node.setHijoIzq(createNode(20));
        node.getHijoIzq().setHijoIzq(createNode(10));
        
        AVLNode<String> newRoot = node.rightRotate(node);
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, newRoot.getHijoIzq().getEtiqueta());
        assertEquals(30, newRoot.getHijoDer().getEtiqueta());
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
        node.setHijoDer(createNode(40));
        node.setHijoIzq(createNode(20));
        node.getHijoIzq().setHijoIzq(createNode(10));
        node.getHijoIzq().setHijoDer(createNode(25));
        node.getHijoIzq().getHijoIzq().setHijoIzq(createNode(0));
        
        AVLNode<String> newRoot = node.rightRotate(node);
        assertEquals(20, newRoot.getEtiqueta());
        assertEquals(10, newRoot.getHijoIzq().getEtiqueta());
        assertEquals(0, newRoot.getHijoIzq().getHijoIzq().getEtiqueta());
        assertEquals(30, newRoot.getHijoDer().getEtiqueta());
        assertEquals(40, newRoot.getHijoDer().getHijoDer().getEtiqueta());
        assertEquals(25, newRoot.getHijoDer().getHijoIzq().getEtiqueta());
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
        node.setHijoDer(createNode(40));
        node.setHijoIzq(createNode(20));
        node.getHijoIzq().setHijoIzq(createNode(10));
        node.getHijoIzq().setHijoDer(createNode(25));
        node.getHijoIzq().getHijoDer().setHijoDer(createNode(28));
        
        AVLNode<String> newRoot = node.leftRightRotate(node);
        assertEquals(25, newRoot.getEtiqueta());
        assertEquals(20, newRoot.getHijoIzq().getEtiqueta());
        assertEquals(10, newRoot.getHijoIzq().getHijoIzq().getEtiqueta());
        assertEquals(30, newRoot.getHijoDer().getEtiqueta());
        assertEquals(40, newRoot.getHijoDer().getHijoDer().getEtiqueta());
        assertEquals(28, newRoot.getHijoDer().getHijoIzq().getEtiqueta());
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
        node.setHijoIzq(createNode(5));
        node.setHijoDer(createNode(20));
        node.getHijoDer().setHijoDer(createNode(25));
        node.getHijoDer().setHijoIzq(createNode(15));
        node.getHijoDer().getHijoIzq().setHijoIzq(createNode(13));
        
        AVLNode<String> newRoot = node.rightLeftRotate(node);
        assertEquals(15, newRoot.getEtiqueta());
        assertEquals(10, newRoot.getHijoIzq().getEtiqueta());
        assertEquals(5, newRoot.getHijoIzq().getHijoIzq().getEtiqueta());
        assertEquals(13, newRoot.getHijoIzq().getHijoDer().getEtiqueta());
        assertEquals(20, newRoot.getHijoDer().getEtiqueta());
        assertEquals(25, newRoot.getHijoDer().getHijoDer().getEtiqueta());
    }
    
}
