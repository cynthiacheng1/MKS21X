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

    public static void insertionSort(int[] data){
	 	for (int i=1; i < data.length; i ++){
	 		//System.out.println("check: " + data[i] + " index:" +i);
	 	    int check = data[i];
	 	    for (int j=i; j >0; j--){
	 	    	//System.out.println("before: "+data[j-1]);
		 		if (check < data[j-1]){
		 			//System.out.println("went through if");
		 		    data[j] = data[j-1];
		 		    data[j-1] = check;
		 		}
	 	    }
	 	}
    }	    

    public static void bubbleSort(int[] data){
        int sorted=1;
        while (sorted > 0){
        	sorted = 0;
            for (int i =1; i < data.length; i++){
                int temp = data[i];
                //System.out.println("num i'm lookin at " +temp);
                if (data[i] < data[i-1]){
                    data[i] = data[i-1];
                    data[i-1] = temp;
                    sorted ++;
                    //System.out.println(sorted);
                }
                //System.out.println(sorted);
            }
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
		int[] test = {8,5};
		int[] test1 = {8,5,3,4,9,0};
		bubbleSort(test1);
		System.out.println(toString(test1));
		int[] test2 = {10,9,8,7,6,5,4};
		bubbleSort(test2);
		System.out.println(toString(test2));
    }
}
