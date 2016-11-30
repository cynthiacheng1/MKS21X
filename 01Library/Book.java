public class Book{
	String author;
	String title;
	String isbn;

	public Book(){

	}
	public Book(String auth, String titl, String isbnn) {
		author = auth;
		title = titl;
		isbn = isbnn;
	}

	public String getAuthor(){
		return author;
	}
	public String getTitle(){
		return title;
	}
	public String getISBN(){
		return isbn;
	}

	public void setAuthor(String input){
		author = input;
	}
	public void setTitle(String input){
		title = input;
	}
	public void setISBN(String input) {
		isbn = input;
	}

	public String toString(){
		return (getTitle() + " by " + getAuthor() + " has an ISBN number" + getISBN());
	}
}