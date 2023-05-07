package Accounts;

import java.util.*;
import java.util.stream.Collectors;
import Documents.Document;

public class Client extends Users {

    // States
    private String name;
    private double balance;
    private Wishlist wishlist;
    private Library library;

    // Constructors
    public Client(String name) {
        this.name = name;
        balance = 0.0;
        wishlist = new Wishlist();
        library = new Library();
    }
    
    // Methods -->  
    private ArrayList<Document> ableToBuy() { // Returns ArrayList<Document> of affordable documents
        return (ArrayList<Document>) wishlist.getWishlistCollection().stream()
                .filter(document -> document.getPrice() <= balance).collect(Collectors.toList());
    }
    
    public Document searchWishlistTitle(String title) {
    	TreeMap<String, Document> documents = new TreeMap<>(Users.sortTitleAscendingTreeMap());
    	return new Document(title, 0, balance);
	}

    // Getters & Setters
    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Document> getWishlist() {
        return wishlist.getWishlistCollection();
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }

    public ArrayList<Document> getLibrary() {
        return library.getLibraryCollection();
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}