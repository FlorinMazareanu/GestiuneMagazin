/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiunemagazin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Florin M
 */
public class WriteBonFiscal {
    public static void WriteBonFiscal(String productName, int productQuantity, float productPrice, String priceString){
        try(FileWriter fw = new FileWriter("bonFiscal.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
        out.println(productName);
        out.println(productQuantity + " X " + productPrice + "........." + priceString);
        } catch (IOException e) {    
        }
    }
            
}
