public class Sorts{
    
    public static String name(){
	return "09.Cheng.Cynthia";
    }
    
    public static void selectionSort(int[] data){
	for (int time=0; time < data.length; time++){
	    int minimum = data[0];
	    int minimumIndex = 0;
	    for (int i=time; i < data.length-1; i++){
			if (data[i]< minimum){
			    minimum = data[i];
			    minimumIndex = i;
			}
	    }
	    data[minimumIndex] = data[time];
	    data[time] = minimum;
	}
    }

    public static String toString(int[] data){
	String ans= "[";
	for (int i=0; i < data.length; i++){
	    ans += data[i] +", ";
	}
	return ans.substring(0,ans.length()-2) + "]";
    }

    public static void main(String[] args){
	int[] test = {8,5,3,4,6,10,0};
	selectionSort(test);
	System.out.println(toString(test));
	int[] test2 = {10,9,8,7,6,5,4};
	selectionSort(test2);
	System.out.println(toString(test2));
    }
}
