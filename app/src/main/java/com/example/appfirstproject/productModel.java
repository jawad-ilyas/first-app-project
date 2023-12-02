package com.example.appfirstproject;

public class productModel {

    int ivProductImg;
    String tvProductText  , tvDiscountedPrice , tvCurrentPrice;

    float rbProductRatingBar;

    public productModel(int ivProductImg, String tvProductText, String tvDiscountedPrice, String tvCurrentPrice, float rbProductRatingBar) {
        this.ivProductImg = ivProductImg;
        this.tvProductText = tvProductText;
        this.tvDiscountedPrice = tvDiscountedPrice;
        this.tvCurrentPrice = tvCurrentPrice;
        this.rbProductRatingBar = rbProductRatingBar;
    }
}
