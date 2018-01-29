package src;

import java.util.ArrayList;
import java.util.Set;

public class View {
    public static void printFileName(String string) {

        System.out.println("==" + string + "==");
    }

    public static void printCharCount(Integer number) {

        System.out.println("Char count : " + number);
    }

    public static void printWordsCount(Integer number) {

        System.out.println("Word count : " + number);
    }

    public static void printDictSize(Integer number) {

        System.out.println("Dict size : " + number); 
    }

    public static void printWordCount(String word, Integer count) {

        System.out.println(word + " : " + count);
    }

    public static void printVowelsPercentage(Float percentage) {

        System.out.println("vowels % : " + percentage);
    }

    public static void printMostUsedWords(Set<String> words) {

        System.out.println("Most used words (>1%) : " + words);
    }

    public static void printTwoElementsRatio(String element1, String element2, Float ratio) {

        System.out.println(element1 + ":" + element2 + " count ratio: " + ratio);
    }

    public static void printAllElementsRatio(ArrayList<String> list) {

        System.out.println(list);
    }

    public static void printBenchmarkTime(double time) {

        System.out.println("Benchmark time: " + time + " secs");
    }


}   