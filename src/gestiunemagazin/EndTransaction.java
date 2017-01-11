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
public class EndTransaction {
    public static void EndTransaction(float totalValue){
        try(FileWriter fw = new FileWriter("bonFiscal.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)){
        out.println(" ");
        out.println("----------------");
        out.println("Total:........ " + totalValue + " RON");
        } catch (IOException e) {    
        }
    }
}
