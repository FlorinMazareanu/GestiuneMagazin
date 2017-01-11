/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiunemagazin;

/**
 *
 * @author Florin M
 */
public class Product {
    private String productBarCode;
    private String productName;
    private int productQuantity;
    private float productPrice;
   

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    
    void printProduct(){
        System.out.println(productBarCode);
        System.out.println(productName);
        System.out.println(productQuantity);
        System.out.println(productPrice);
    }
    

}
