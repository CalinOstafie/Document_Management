package Documents;

public class Document {

	// States
	private String title;
	private int rating;
	private double price;
	
	//Constructors
	public Document(String title, int rating, double price) {
		super();
		this.title = title;
		this.rating = rating;
		this.price = price;
	}

	// Getters & Setters
	public String getTitle() {
		return title;
	}

	public int getRating() {
		return rating;
	}

	public double getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	// toString
	@Override
	public String toString() {
		return "Document [title=" + title + ", rating=" + rating + ", price=" + price + "]";
	}
}