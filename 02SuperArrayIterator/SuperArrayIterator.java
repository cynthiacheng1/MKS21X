import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String>{ 
SuperArray data;
int element;

public SuperArrayIterator(SuperArray input){
	data = input;
	element = 0;
}

public boolean hasNext(){
	return data.size() > element;
}

public String next(){
	if (hasNext()){
		element++;
		return data.get(element-1);
	}
	else{
		throw new NoSuchElementException();
	}
}

public void remove(){
	throw new UnsupportedOperationException();
}


}