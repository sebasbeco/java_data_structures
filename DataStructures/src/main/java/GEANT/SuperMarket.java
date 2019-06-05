/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEANT;

import ds.Lista;
import ds.Nodo;
import ds.TArbolBB;
import ds.TElementoAB;

/**
 *
 * @author seba
 */
public class SuperMarket {
    
    private TArbolBB<Product> products;
    
    public SuperMarket() {
        products = new TArbolBB<>();
    }
    
    public Product getProduct(String id) {
        TElementoAB<Product> p = products.buscar(id);
        if (p != null)
            return p.getDatos();
        return null;
    }
    
    public void addNewProduct(Product p) {
        if (products.buscar(p.getId()) == null) {
            TElementoAB<Product> newProd = new TElementoAB<>(p.getId(), p);
            products.insertar(newProd);
        }
    }
    
    public void addStock(String productID, int stock) throws Exception {
        Product p = getProduct(productID);
        if (p != null)
            p.addStock(stock);
        else
            throw new Exception(String.format("Non existing product %s", productID));
    }
    
    public void sell(String productID, int stock) throws Exception {
        Product p = getProduct(productID);
        if (p != null)
            p.reduceStock(stock);
        throw new Exception(String.format("Non existing product %s", productID));
    }
    
    public void discontinue(String productID) throws Exception {
        Product p = getProduct(productID);
        if (p != null)
            products.eliminar(productID);
        throw new Exception(String.format("Non existing product %s", productID));
    }
    
    public int inventory(String productID) throws Exception {
        Product p = getProduct(productID);
        if (p != null)
            return p.currentStock();
        throw new Exception(String.format("Non existing product %s", productID));
    }
    
    public String listAll() {
        Lista<Product> ps = products.inorden();
        StringBuilder builder = new StringBuilder();
        String format = "%-15s%-60s%-10d%-10.2f%-,15.2f";
                
        // add title
        builder.append(String.format("%-15s%-60s%-10s%-10s%-15s", 
                "ID", "Nombre", "Stock", "Precio", "Total"));
        builder.append(System.lineSeparator());
        
        int totalValue = 0;
        
        // add products
        Nodo<Product> node = ps.getPrimero();
        while (node != null) {
            Product p = node.getDato();
            builder.append(String.format(format, 
                    p.getId(), 
                    p.getName(), 
                    p.currentStock(), 
                    p.getPrice(), 
                    p.currentStock() * p.getPrice()));
            builder.append(System.lineSeparator());
            
            totalValue += p.currentStock() * p.getPrice();
            
            node = node.getSiguiente();
        }
        
        // add total
        builder.append("---------------------------------------------------------------------------------------------------------");
        builder.append(System.lineSeparator());
        builder.append(String.format("TOTAL                                                                                          %,d",
                totalValue));
        
        return builder.toString();   
    }
}
