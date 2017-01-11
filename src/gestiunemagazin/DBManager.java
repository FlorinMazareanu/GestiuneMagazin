/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiunemagazin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florin M
 */
public class DBManager {
    Connection con;
    String query;
    DBManager(){
        try {   
            this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","STORE_ADMIN","u8cartof6");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getItem(int a){       
        return a;
    }
    
    String GetScriptFile(String scriptFile){
        String scriptFileName = scriptFile;
        String query = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(scriptFileName));
            String currentLine;
            try {
                while((currentLine = br.readLine()) != null){
                    query = query + currentLine;                    
                }
                this.query = query;
                //System.out.println(this.query);
            } catch (IOException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.query;
    }
    
    void UpdateItemQuantity(String updateQuery, String codeBarText, int itemQuantity){
       PreparedStatement preparedStatement = null; 
       //String updateQ = "UPDATE STORE_ADMIN.STORED_PRODUCTS SET QUANTITY = QUANTITY - ? " + "WHERE BAR_CODE = ?";
       //String codeBarTextSQ = codeBarText.replace("'","\"");
        try {
            preparedStatement = con.prepareStatement(updateQuery);
            preparedStatement.setInt(1, itemQuantity);
            preparedStatement.setString(2, codeBarText); 
            preparedStatement.executeUpdate();
            //System.out.println("Update!");
            //System.out.println("itemQuantity: " + itemQuantity);
            //System.out.println(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    Product SelectProductVariables(String getPriceQuery, String codeBarText, int itemQuantity){
        PreparedStatement preparedStatement = null;
        Product p = new Product();
        try {
            preparedStatement = con.prepareStatement(getPriceQuery);
            preparedStatement.setString(1, codeBarText);
            //System.out.println("price");
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String pName = rs.getString("PRODUCT_NAME");
                p.setProductName(pName);
                float pPrice = rs.getFloat("PRICE");                
                p.setProductPrice(pPrice);                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    
    
    /*
    public static getStudentAge(String nrMatricol){
		PreparedStatement stmt = con.prepareStatement(string smecher);
		stmt.executeQuery();
		si dau raspunsu cu return nr, unde nr il iau din ce imi da query.
		Ai exemple in proiectu ala
    }
    */
}
