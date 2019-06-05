/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GEANT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author seba
 */
public class Main {
    
    public static void main(String[] args) {
        SuperMarket s = new SuperMarket();
        
        FileReader fr;
        try {
            fr = new FileReader("altas.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                Product p = parseProduct(line);
                s.addNewProduct(p);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
        
        System.err.println(s.listAll());
    }
    
    private static Product parseProduct(String line) {
        line = cleanLine(line);
        String[] split = line.split(",");
        String id = split[0].trim();
        String name = split[1].trim();
        double price = Double.parseDouble(split[2].trim());
        int stock = Integer.parseInt(split[3].trim());
        return new Product(name, id, price, stock);   
    }
    
    private static String cleanLine(String line) {
        StringBuilder builder = new StringBuilder(line);
        boolean inQuotes = false;
        for (int i = 0; i < builder.length(); i++) {
            char currentChar = builder.charAt(i);
            if (currentChar == '\"')
                inQuotes = !inQuotes;
            if (currentChar == ',' && inQuotes)
                builder.setCharAt(i, '.');
        }
        return builder.toString().replace("\"", "");
    }
    
}
