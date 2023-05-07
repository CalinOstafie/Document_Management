package Accounts;

import Documents.Document;
import java.util.*;

public class Library {
    
    // States
    private ArrayList<Document> libraryCollection;

    // Constructors
    public Library() {
        libraryCollection = new ArrayList<>();
    }
        
    // Getters & Setters
    public ArrayList<Document> getLibraryCollection() {
        return libraryCollection;
    }

    public void setLibraryCollection(ArrayList<Document> libraryCollection) {
        this.libraryCollection = libraryCollection;
    }
    
}