/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiunemagazin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florin M
 */
public class TotalValueFile {
    public static float TotalValueFile(String productName, int productQuantity, float productPrice, String priceXQuantityString){
        float totalValue = 0;
        try(FileWriter fw = new FileWriter("totalValue.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
        out.println(priceXQuantityString);
        } catch (IOException e) {    
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("totalValue.txt"));
            for(String line; (line = br.readLine()) != null; ){
                //System.out.println("Linie: " + line);
                if (!line.isEmpty()) {
                    totalValue = totalValue + Float.parseFloat(line);
                    //System.out.println("totalValue: " + totalValue);
                       
                    //System.out.println("productQuantity: " + productQuantity);
                    
                }               
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TotalValueFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TotalValueFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        WriteBonFiscal.WriteBonFiscal(productName, productQuantity, productPrice, priceXQuantityString);
        
       return totalValue; 
    }
}
