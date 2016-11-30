public class ReferenceBook extends LibraryBook {
	String collection;

	public ReferenceBook(){

	}
	public ReferenceBook(String auth, String titl, String isbnn, String call, String collec) {
		author = auth;
		title = titl;
		isbn = isbnn;
		callNumber = call;
		collection = collec;
	}

	public String getCollection(){
		return collection;
	}

	public void setCollection(String input){
		collection = input;
	}

	public void checkout(String x, String y){
		System.out.println("cannot check out a reference book");
	}
	public void returned(){
		System.out.println("reference book could not have been checked out -- return impossible");
	}
	public String circulationStatus(){
		return "non-circulating reference book";
	}
	public String toString(){
		//from LibraryBook should be augmented with the collection information
		return "blah";
	}
}