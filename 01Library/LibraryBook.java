public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
	String callNumber;
	String currentHolder;
	String dueDate;

	public LibraryBook(){

	}
	public LibraryBook(String auth, String titl, String isbnn, String callNum) {
		author = auth;
		title = titl;
		isbn = isbnn;
		callNumber = callNum;
		currentHolder = null;
		dueDate = null;
	}

	public String getCallNumber(){
		return callNumber;
	}

	public void setCallNumber(String input){
		callNumber = input;
	}

	abstract void checkout(String patron, String due);
	abstract void returned();
	abstract String circulationStatus();

	public int compareTo(LibraryBook book){
		return  (callNumber).compareTo(book.getCallNumber());
	}

	public String toString(){
		//toString from Book is augmented with a circulation status and call number
		return getTitle() + " by " + getAuthor() + " has an ISBN number "  + getISBN()+ ". Call Number:" + getCallNumber();
	}
}