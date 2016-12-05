public class SuperArray implements Iterable<String>{
	private String[] data;
	private int size;

	public SuperArray() {
		size = 0;
		data = new String[10];
	}

	public int size() {
		return size;
	}

	public SuperArrayIterator iterator(){
        return new SuperArrayIterator(this);
    }

    public String get(int index){
    	if (index < 0 || index >= size()) {
    		throw new IndexOutOfBoundsException();
    	}
        return data[index];
    }

    public boolean add(String n){
        if (size == data.length){
            grow();
        }
        data[size] = n;
        size++;
        return true;
    }

	private void grow() {
		String[] fixedData = new String[(data.length*2+1)];
		for (int i =0; i < data.length; i ++) {
			fixedData[i] = data[i];
		}
		data = fixedData;
	}

	public String toString() {
		String ans = "[ ";
		for (int i = 0; i < size; i++) {
			ans = ans + data[i] + ", ";
		}
		ans = ans.substring(0 ,ans.length() - 2) + "]";
		if (size == 0) {
			ans = "[]";
		}
		return ans;
	}

	public String toStringDebug() {
		String ans = "[ ";
		for (int i = 0; i < data.length-1; i++) {
			if (i < size) {
				ans = ans + String.valueOf(data[i]) + ", ";
			}
			else {
				ans = ans + "_, ";
			}
		}
		ans = ans.substring(0,ans.length() - 2) + "]";
		return ans;
	}

	public void clear() {
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void set(int index, String element) {
    	if (index < 0 || index >= size) {
    		throw new IndexOutOfBoundsException();
    	}
		data[index] = element;
	}


	public void add(int index, String element) {
		if (index < 0) {
	    	throw new IndexOutOfBoundsException();
		}
		if (data.length== size) {
	    	grow();
		}
		String[] fixarray= new String[data.length];
		for (int i =0; i < index; i++){
		    fixarray[i]=data[i];
		}
		fixarray[index]=element;
		size++;
		for (int i = index+1; i<size; i++){
		    fixarray[i]=data[i-1];
		}
		data=fixarray;
    }

	public void remove(int index) {
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
		for (int i = index; i < size; i++) {
			data[i] = data[i+1];
		}
		size --;
	}

	public String[] toArray() {
		String[] array = new String[size];
		for (int i = 0; i < size; i++) {
			array[i] = data[i];
		}
		return (array);
	}

	public int indexOf(String n) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(n)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(String n) {
		for (int i = size-1; i < size; i--) {
			if (data[i].equals(n)) {
				return i;
			}
		}
		return -1;
	}

	public void trimToSize() {
		String[] temp = new String[size+1];
		for(int i = 0; i < size;i++){
            temp[i].equals(data[i]);
        }
        data = temp;
	}

	public SuperArray(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException();
		}
		else {
			data = new String[initialCapacity];
			size=0;
		}
	}


	public static void main(String[]args) {
		SuperArray test = new SuperArray();
		SuperArray test1 = new SuperArray(10);
		System.out.println(test.add("hello"));
		System.out.println(test.add("boo"));
		System.out.println(test.add("cool"));
		//System.out.println(test.toString());
		// System.out.println(test.get(0));
		System.out.println(test.toStringDebug());
		// //test.clear();
		// //System.out.println(test.toString());
		// System.out.println(test.isEmpty());
		// System.out.println(test.add(1));
		// System.out.println(test.add(2));
		// System.out.println(test.add(3));
		// test.set(0,5);
		test.add(1,"woah");
		System.out.println(test.toStringDebug());
		// System.out.println(test.size());
		// test.remove(5);
		// System.out.println(test.toStringDebug());
		// System.out.println(test.indexOf(3));
		// System.out.println(test.lastIndexOf(5));
		// System.out.println(test.toArray());
		// System.out.println(test.size());
		// test.trimToSize();
		// System.out.println(test.toStringDebug());
	}

}