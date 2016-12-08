public class Barcode implements Comparable<Barcode>{
    //instance variables
    private String _zip;
    private int _checkDigit = 0;

    public Barcode (String zip) {
	if ( (zip.length() != 5)|| (!(_zip.matches("[0-9]+"))) ) {
	    throw new RuntimeException();
	}
	else {
	    _zip = zip;
	    _checkDigit = checkSum()%10;
	}
    }

    public String getZip(){
    	return _zip;
    }
    
    public Barcode clone(){
	Barcode clone = new Barcode(_zip);
	return clone;
    }

    public int checkSum(){
	int sum = 0;
	for (int i = 0; i < _zip.length(); i ++) {
		sum += Character.getNumericValue(_zip.charAt(i));
	}
	return sum;
    }

    public String toString(){
	int num = 0;
	String NumString= "";
	switch (num) {
            case 1:  NumString = ":::||";
                     break;
            case 2:  NumString = "::|:|";
                     break;
            case 3:  NumString = "::||:";
                     break;
            case 4:  NumString = ":|::|";
                     break;
            case 5:  NumString = ":|:|:";
                     break;
            case 6:  NumString = ":||::";
                     break;
            case 7:  NumString = "|:::|";
                     break;
            case 8:  NumString = "|::|:";
                     break;
            case 9:  NumString = "|:|::";
		     break;
	    case 0:  NumString = "||:::";
		     break;
	}
	for (int i =0; i < _zip.length(); i++) {
		num = Character.getNumericValue(_zip.charAt(i));
		NumString += num;                      
	}
	return NumString;
    }

	public int compareTo(Barcode other) {
		return (Integer.parseInt(_zip) - Integer.parseInt(other.getZip()));
	}

	public static void main(String[]args){
		Barcode b = new Barcode("08451");
		Barcode c = new Barcode("99999");
		Barcode d = new Barcode("11111");
		System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
		System.out.println(b.toString().compareTo("084518"));
		//|||:::|::|::|::|:|:|::::|||::|:|")); //0
		System.out.println(b.compareTo(b)); //0
		System.out.println(c.compareTo(b));
		System.out.println(d.compareTo(b));
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




