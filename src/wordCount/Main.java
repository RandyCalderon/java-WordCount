package src.wordCount;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String words = "";

        // Use \\s* if you want to separate by letters vs words
        Scanner input = new Scanner(new File("C:\\Users\\randy\\Programming\\Java\\java-WordCount\\src\\Input.txt")).useDelimiter("\\s+");

        List<String> wordArray = new ArrayList<String>();

        while(input.hasNext()) {
            words = input.next();
            wordArray.add(words);
        }
        input.close(); // Closing file reader

        String[] resultArray = wordArray.toArray(new String[0]);


        // ForEach
        for (String s : resultArray) {
            System.out.println(s); // Checking to see if split working as intended
        }


        // Hashmap
    }
}
