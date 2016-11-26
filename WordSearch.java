import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch{
    private char[][]data;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public WordSearch(int rows,int cols, String filename){
        data = new char[rows][cols];
        wordsToAdd = new ArrayList<String>();
        wordsAdded = new ArrayList<String>();
        loadwords(filename);
        startRandom();
        clear();
    }

    public WordSearch(int rows,int cols, String filename, int seed, boolean key){
        data = new char[rows][cols];
        wordsToAdd = new ArrayList<String>();
        wordsAdded = new ArrayList<String>();
        loadwords(filename);
        startRandom(seed);
        clear();
    }

    private void clear(){
        for (int i = 0; i < data.length; i ++) {
            for (int j=0; j < data[0].length; j++) {
                data[i][j] = '_';
            }
        }
    }

    public void startRandom(){
        int seed = (int)(Math.random()*100000);
    //seed = 17127;
        //change this to any seed you want.
        System.out.println("This is your seed: "+seed);
        randgen = new Random(seed);
    }

    public void startRandom(int x){
        int seed = x;
        //seed = 17127;
        //change this to any seed you want.
        System.out.println("This is your seed: "+seed);
        randgen = new Random(seed);
    }

    public void fillWithChar() {
        String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < data.length; i ++) {
            for (int j=0; j < data[0].length; j++) {
                if (data[i][j] == '_') {
                    data[i][j] = abc.charAt(Math.abs(randgen.nextInt() % abc.length()));
                }
            }
        }
    }

    public String toString(){
        String ans = "";
        int i;
        for (i = 0; i < data.length; i ++) {
            for (int j=0; j < data[0].length; j++) {
                ans += data[i][j] + " ";
            }
            ans += "\n";
        }
        return ans;
    }

    // public boolean addWordHorizontal(String word,int row, int col){
    //     if (col + word.length() <= data[row].length) {
    //         for (int i = 0; i < word.length(); i++) {
    //             if ( (word.charAt(i) == (data[row][col+i])) || (data[row][col+i] == '_') )  {
    //                 return true;
    //             }
    //             else {
    //                 return false;
    //             }
    //         }
    //     }
    //     return false;


    public boolean addWord(String word, int row, int col, int changeRow, int changeCol) {
        try {
            if (changeCol == 0 && changeRow == 0) {
                //System.out.println("INDEXES EQUAL ZERO");
                return false;
            }
            for (int i = 0; i < word.length(); i++ ) {
                // System.out.println("INDEX");
                // System.out.println(i);
                // System.out.println(data[row+(i* changeRow)][col +(i * changeCol)]);
                // System.out.println("is it full?");
                // System.out.println( (data[row+(i* changeRow)][col +(i * changeCol)] != '_' ));
                // System.out.println("row num");
                // System.out.println(row+(i * changeRow));
                // System.out.println("col num");
                // System.out.println(col+(i * changeCol));
                if ((data[row+(i* changeRow)][col +(i * changeCol)] != '_' )) {
                    // System.out.println("CURRENT INDEX");
                    // System.out.println(data[row+(i * changeRow)][col+(i * changeCol)]);
                    if ( word.charAt(i) != (data[row+(i * changeRow)][col+(i * changeCol)])) {
                        return false;
                    }
                }
            }
        }catch (ArrayIndexOutOfBoundsException e){ 
            //System.out.println("WENT OUT OF BOUNDS");
            return false;
        }
        for (int i =0; i <word.length(); i++) {
            data[row+(i*changeRow)][col+(i*changeCol)] = word.charAt(i);
        }
        wordsAdded.add(word);
        wordsToAdd.remove(word);
        return true;
    }

    public void loadwords(String filename) {
    try{
        Scanner in = new Scanner(new File(filename));
        //print each word in the text file:
        while(in.hasNext()){
            String word = in.next();
            //System.out.println(word.toUpperCase());
            wordsToAdd.add(word);
        }
    }catch(FileNotFoundException e){
        System.out.println("Invalid filename or path");
        System.exit(1);
    }
    }

    public void printWordList() {
        System.out.println("Words To Add");
        for(int i = 0; i < wordsToAdd.size(); i++) {
            System.out.println(wordsToAdd.get(i));
        }
        System.out.println("\nWords Added");
        for (int i =0; i < wordsAdded.size(); i++) {
            System.out.println(wordsAdded.get(i));
        }
    }

    public void fillWithWords(){
        for (int i = 0; i < wordsToAdd.size(); i++) {
            boolean failure = true;
            int ctr = 0;
            while(ctr < 200 && failure){
                failure = !(addWord(wordsToAdd.get(i), Math.abs(randgen.nextInt() % data.length+1), Math.abs(randgen.nextInt() % data[0].length+1), Math.abs(randgen.nextInt()) % 3 - 1, Math.abs(randgen.nextInt()) % 3 - 1));
                ctr++;
            }
        }
    }

    public static void main(String[]args){
        if (args.length < 3) {
            System.out.println("Hello! To Make a WordSearch you will need to type \njava WordSearch <insert num of rows you want> <insert num of colums you want> <filename where you will be extracting words> <seed if you have> <key if you want answer key> ");
        }
        else {
            int row = Integer.parseInt(args[0]);
            int col = Integer.parseInt(args[1]);
            String file = args[2];
            int seed = (int) (Math.random()*100000);
            boolean key = false;
            if (args.length >= 4) {
                seed = Integer.parseInt(args[3]);
            }
            if (args.length >= 5){
                key = args[4].equals("key");
            }
            WordSearch w = new WordSearch(row, col, file, seed, key);
            w.fillWithWords();
            if (!key) {
                w.printWordList();
                w.fillWithChar();
            }
            System.out.println(w);
        }

    }

}
