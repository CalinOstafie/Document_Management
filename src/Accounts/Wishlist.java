package Accounts;

import Documents.Document;
import java.util.*;

public class Wishlist extends Cluster {
    
    //States
    private ArrayList<Document> wishlistCollection;
    
    //Constructors
    Wishlist() {
        wishlistCollection = new ArrayList<>();
    }

    // Getters & Setters
    public ArrayList<Document> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(ArrayList<Document> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }
    
}