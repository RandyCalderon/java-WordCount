package src.wordCount;


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String words = "";
        String lowerCaseInput = words.toLowerCase();

        // Use \\s* if you want to separate by letters vs words
        Scanner input = new Scanner(new File("C:\\Users\\randy\\Programming\\Java\\java-WordCount\\src\\Input.txt")).useDelimiter("[^a-zA-Z-0-9]");

        List<String> wordArray = new ArrayList<String>();

        while(input.hasNext()) {
            words = input.next();
            wordArray.add(words);
        }
        input.close(); // Closing file reader

        String[] resultArray = wordArray.toArray(new String[0]);

        // Create hashmap that takes in Word as key and Count as value
        HashMap<String, Integer> wordCount = new HashMap<>();


        // ForEach
        for (String s : resultArray) {
            // Checking to see if split working as intended
            //System.out.println(s);
                if(wordCount.containsKey(s)) {
                    wordCount.put(s, wordCount.get(s) + 1);
                } else {
                    wordCount.put(s.toLowerCase(), 1);
                }


        }

        wordCount.remove("");

        //Checking values
        //wordCount.forEach((k, v) -> System.out.println("word: " +k + " count: " + v));

        ArrayList<HashMap.Entry<String, Integer>> wordCountList = new ArrayList<>();

        wordCountList.addAll(wordCount.entrySet());

        Collections.sort(wordCountList, new Comparator<HashMap.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int topList = 51;
        int count = 1;

        for(HashMap.Entry<String, Integer> wordEntry : wordCountList) {
            if(count == topList) {
                break;
            }
            System.out.println("Word: " + count + " Key: " + wordEntry.getKey() + " Value: " + wordEntry.getValue());
            count++;
        }
    }
}
