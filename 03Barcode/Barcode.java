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
	    _checkDigit = checkSum()%10;
	}
    }
    
    private boolean notDigit(String zip){
    	for (int i =0; i < zip.length(); i++) {
    		if (zip.charAt(i) > '9' || zip.charAt(i) < '0') {
    			return true;
    		}
    	}
    	return false;
    }

    public int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i ++) {
		sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum;
    }


    public String toString(){
    String[] Ref = new String[]{"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|::|", ":||::", "|:::|", "|::|:", "|:|::"};
	int num;
	String numString = "|";
	String updatedZip = _zip + _checkDigit;
	for (int i =0; i < updatedZip.length(); i++) {
		numString += Ref[Character.getNumericValue(updatedZip.charAt(i))];                      
	}
	return numString + "|";
    }

	public int compareTo(Barcode other) {
		return (_zip.compareTo(other._zip));
	}

	public static void main(String[]args){
		Barcode b = new Barcode("08451");
		Barcode c = new Barcode("99999");
		// Barcode d = new Barcode("11111");
		System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
		// System.out.println(b.toString().compareTo("084518"));
		// //|||:::|::|::|::|:|:|::::|||::|:|")); //0
		System.out.println(b.compareTo(b)); //0
		System.out.println(new Barcode("58900").compareTo(new Barcode("00000")));
		System.out.println(new Barcode("00000").compareTo(new Barcode("58900")));
		// System.out.println(c.compareTo(b));
		// System.out.println(d.compareTo(b));
		/*length
		Barcode e = new Barcode("123456");
		System.out.println(e);
		*/
		/*length
		Barcode e = new Barcode("1234");
		System.out.println(e);
		*/
		/*type
		Barcode e= new Barcode("12.45");
		System.out.println(e);
		*/
	}

}




