package com.example.anabi.finalyearproject1try.FireBaseBackend.fragment;

import java.io.Serializable;
import java.util.Date;

public class PostModel implements Serializable {

    String productDescription,productId,productImage,productName,productPrice,selectedProductCategory,userID,postUserEmail;
    private String selectedProductComponent;
    private String screenSize;
    //private String recommendation;

    // new
    private String recommendation;


    Date timeStamp;

    public PostModel(){}

    public String getSelectedProductComponent() {
        return selectedProductComponent;
    }

    public void setSelectedProductComponent(String selectedProductComponent) {
        this.selectedProductComponent = selectedProductComponent;
    }

    public String getScreenSize() {
        return screenSize;
    }


    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    // new


    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
    this.recommendation = recommendation;
    }

    //end

    public PostModel(String productDescription, String productId, String productImage, String productName, String productPrice, String selectedProductCategory, String userID, String postUserEmail, Date timeStamp, String selectedProductComponent, String screenSize, String Recommendation) {
        this.productDescription = productDescription;
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.selectedProductCategory = selectedProductCategory;
        this.userID = userID;
        this.postUserEmail = postUserEmail;
        this.timeStamp = timeStamp;
        this.recommendation = Recommendation;
        this.selectedProductComponent = selectedProductComponent;
        this.screenSize= screenSize;

    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getSelectedProductCategory() {
        return selectedProductCategory;
    }

    public String getUserID() {
        return userID;
    }

    public String getPostUserEmail() {
        return postUserEmail;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    // setter are newly added


}
