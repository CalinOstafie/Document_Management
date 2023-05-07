package Accounts;

import java.util.ArrayList;
import java.util.Comparator;

import Documents.Document;

public class Users implements Operators {

	// Methods
	public static Comparator<Document> sortPriceAscending() {
		
		return new Comparator<Document>() {
			@Override
			public int compare(Document obj1, Document obj2) {
				double num = obj1.getPrice() - obj2.getPrice();
				
				if(num > 0)
					return 1;
				else if(num < 0)
					return -1;	
				return 0;
			}
		};
	}
	
	public static Comparator<Document> sortPriceDescending() {
		
		return new Comparator<Document>() {
			@Override
			public int compare(Document obj1, Document obj2) {
				double num = obj2.getPrice() - obj1.getPrice();
				
				if(num > 0)
					return 1;
				else if(num < 0)
					return -1;	
				return 0;
			}
		};
	}

	public static Comparator<Document> sortRatingAscending() {
		
		return new Comparator<Document>() {
			@Override
			public int compare(Document obj1, Document obj2) {
				return obj1.getRating() - obj2.getRating();
			}
		};
	}
	
	public static Comparator<Document> sortRatingDescending() {
		
		return new Comparator<Document>() {
			@Override
			public int compare(Document obj1, Document obj2) {
				return obj2.getRating() - obj1.getRating();
			}
		};
	}

	public static Comparator<Document> sortTitleAscending() { 
		// Note: When sorting maps, only use key type. Don't use values associated with keys 
		// --> e.g.: Not Document in this case b/c it's not what we're ordering, but rather Strings
		return new Comparator<Document>() {
			@Override
			public int compare(Document obj1, Document obj2) {
				return obj1.getTitle().compareToIgnoreCase(obj2.getTitle());
			}
		};
	}
	
	public static Comparator<Document> sortTitleDescending() {
		
		return new Comparator<Document>() {
			@Override
			public int compare(Document obj1, Document obj2) {
				return obj2.getTitle().compareToIgnoreCase(obj1.getTitle());
			}
		};
	}

	public static Comparator<String> sortTitleAscendingTreeMap() {
            // For Sorting String Keys
		return new Comparator<String>() {
			@Override
			public int compare(String obj1, String obj2) {
				return obj1.compareToIgnoreCase(obj2);
			}
		};
	}
	
	public static Comparator<String> sortTitleDescendingTreeMap() {
		return new Comparator<String>() {
			@Override
			public int compare(String obj1, String obj2) {
				return obj2.compareToIgnoreCase(obj1);
			}
		};
	}
}