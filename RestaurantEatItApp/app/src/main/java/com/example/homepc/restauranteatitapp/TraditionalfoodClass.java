package com.example.homepc.restauranteatitapp;

/**
 * Created by HomePC on 1/9/2018.
 */

public class TraditionalfoodClass {

    private String Itemname;
    private String Itemprice;
    private int Itemimage;
    public String Itemquantity;



    public TraditionalfoodClass(String iName, String iPrice, int iImage,String iquantity)
    {
        Itemname = iName;
        Itemprice = iPrice;
        Itemimage = iImage;
        Itemquantity = iquantity;



    }
    public String getItemName() {
        return Itemname;
    }

    public String getItemPrice() {return Itemprice;}

    public int getImageResourceId() {return Itemimage;}

    public String getItemquantity() {return Itemquantity;}






}
