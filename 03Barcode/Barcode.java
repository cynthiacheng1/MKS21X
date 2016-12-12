public class Barcode implements Comparable<Barcode>{
    //instance variables
    private String _zip;
    private int _checkDigit = 0;

    public Barcode (String zip) {
	if ( (zip.length() != 5) || notDigit(zip)) {
	    throw new RuntimeException();
	}
	else {
	    _zip = zip;
	    _checkDigit = checkSum(zip);
	}
    }
    
    private static boolean notDigit(String zip){
    	for (int i =0; i < zip.length(); i++) {
    		if (zip.charAt(i) > '9' || zip.charAt(i) < '0') {
    			return true;
    		}
    	}
    	return false;
    }

    private static int checkSum(String input){
	int sum = 0;
	for (int i = 0; i < input.length(); i ++) {
		//System.out.println(Character.getNumericValue(input.charAt(i)));
		sum += Character.getNumericValue(input.charAt(i));
	}
	return sum%10;
    }


    public String toString(){
    	return _zip + " " + toCode(_zip);
    }

    public static String toCode(String zip){
		if ( (zip.length() != 5) || notDigit(zip)) {
		    throw new IllegalArgumentException();
		}
	    String[] Ref = new String[]{"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
		int num;
		String numString = "|";
		//System.out.println("HERE THIS");
		//System.out.println(checkSum(zip));
		String updatedZip = zip + checkSum(zip);
		for (int i =0; i < updatedZip.length(); i++) {
			numString += Ref[Character.getNumericValue(updatedZip.charAt(i))];                      
		}
		return numString + "|";
    }

    private static int searchArray(String object, String[] array){
    	for (int i=0; i<array.length; i++){
    		//System.out.println(array[i]);
    		if (array[i].equals(object)){
    			//System.out.println(i);
    			//System.out.println(array[i]);
    			//System.out.println(object);
    			return i;
    		}
    	}
    	//System.out.println("rejected");
    	//System.out.println(object);
    	return -1;
    }

    private static boolean notValidZip(String barcode){
    	boolean ans = true;
    	for (int i=0; i < barcode.length(); i++){
			if (barcode.substring(i,i+1).equals(":") || barcode.substring(i,i+1).equals("|")) {
				ans = false;
			}
			else {
				ans = true;
			}
		}
		return ans;
    }

    public static String toZip(String barcode) {
    	//if (barcode.substring(0) != "|" || barcode.substring(barcode.length()) != "|" || barcode.length() != 32 || notValidZip(barcode)){
    	//	throw new IllegalArgumentException();
    	//}
    	// System.out.println("all");
    	// System.out.println(barcode);
    	// System.out.println("index 0:");
    	// System.out.println(barcode.substring(0,1));
    	// System.out.println((barcode.substring(0,1) == "|"));
    	if (!(barcode.substring(0,1).equals("|"))){
		    throw new IllegalArgumentException("doesnt start w |");
		}
		//System.out.println(barcode.substring(barcode.length()-1));
		if (!(barcode.substring(barcode.length()-1).equals("|"))) {
			throw new IllegalArgumentException("doesnt end w |");
		}

		if (barcode.length() != 32) {
			throw new IllegalArgumentException("not right length");
		}

		if (notValidZip(barcode)) {
			throw new IllegalArgumentException("doesnt include only | :");
		}
    	String[] Ref = new String[]{"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    	String zipAndCheck = barcode.substring(1,barcode.length());
    	String zip="";
    	for (int i =0; i < zipAndCheck.length()/5; i++){
    		int encodedInt = searchArray(zipAndCheck.substring((i*5),(i*5)+5), Ref);
    		if (encodedInt == -1) {
    			throw new IllegalArgumentException("not valid ints");
    		}
    		zip += encodedInt;
    	}
    	//System.out.println(zip.substring(0, zip.length()));
    	String zipp = (zip.substring(0, zip.length()-1));
    	//System.out.println(checkSum(zipp));
    	//System.out.println(zip.substring(zip.length()-1));
    	if (!(zip.substring(zip.length()-1).equals("" + checkSum(zipp) ))) {
    		throw new IllegalArgumentException("check not same");
    	}
    	//System.out.println(barcode.substring(zip.length()-1));
    	return zip.substring(0, zip.length()-1);
    }


	public int compareTo(Barcode other) {
		return (_zip.compareTo(other._zip));
	}

	public static void main(String[]args){
		//Barcode b = new Barcode("10220");
		//Barcode c = new Barcode("99999");
		// Barcode d = new Barcode("11111");
		//System.out.println(b);
		//System.out.println(new Barcode("000000"));
		//System.out.println(new Barcode("00qa0"));
		//System.out.println(toZip("|:::||||:::::|:|::|:|||::::|:|:|"));
		//System.out.println(new Barcode("58900").compareTo(new Barcode("58900")));
		//System.out.println(new Barcode("58900").compareTo(new Barcode("00000")));
		//System.out.println((new Barcode("00000").compareTo(new Barcode("58900"))));
	}

}




