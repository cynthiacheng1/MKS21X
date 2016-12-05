import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String>{ 
SuperArray data;
int element;

public SuperArrayIterator(){
	data = new SuperArray();
	element = 0;
}

public SuperArrayIterator(SuperArray input){
	data = input;
	element = 0;
}

public boolean hasNext(){
	if (data.size() > (element +1)) {
		return true;
	}
	return false;
}

public String next(){
	if (hasNext()) {
		element ++;
		return data.get(element);
	}
	else{
		throw new NoSuchElementException();
	}
}

public void remove(){
	throw new UnsupportedOperationException();
}


}