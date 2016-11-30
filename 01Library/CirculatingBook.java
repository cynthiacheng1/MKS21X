public class CirculatingBook extends LibraryBook {
	String currentHolder;
	String dueDate;

	public CirculatingBook(String auth, String titl, String isbnn, String callNum) {
		author = auth;
		title = titl;
		isbn = isbnn;
		callNumber = callNum;
		currentHolder = null;
		dueDate = null;
	}

	public String getCurrentHolder(){
		return currentHolder;
	}
	public String getDueDate(){
		return dueDate;
	}

	public void setCurrentHolder(String input){
		currentHolder = input;
	}
	public void setDueDate(String input){
		dueDate = input;
	}

	public void checkout(String pers, String date){
		currentHolder = pers;
		dueDate = date;
	}
	public void returned(){
		currentHolder = null;
		dueDate = null;
	}

	public String circulationStatus(){
		if (!(currentHolder.equals(null) || dueDate.equals(null))) {
			return getCurrentHolder() + "must return by " + getDueDate();
		}
		return "Book available on shelves";
	}

	public String toString(){
		return getTitle() + " by " + getAuthor() + " has an ISBN number "  + getISBN()+ ". Call Number: " + getCallNumber() + " CurrentHolder: " + getCurrentHolder() + " Due Date: " + getDueDate();

	}
}