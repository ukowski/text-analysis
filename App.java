import src.dao.FileContent;
import src.controller.StatisticalAnalysis;
import src.view.AppView;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;

public class App {
    
    public static void main(String[] args) {

        long startTime, endTime;
        double benchmarkTime;
        FileContent fc;

        startTime = System.currentTimeMillis();
        
        if (args.length > 0) {

            for (int i=0 ; i < args.length ; i++) {

                fc = new FileContent(args[i]);
                printFileInformation(fc);
            }
        }
        endTime = System.currentTimeMillis();
        
        benchmarkTime = (endTime - startTime)/1000.0;
        AppView.printBenchmarkTime(benchmarkTime);
    }

    public static void printFileInformation(FileContent fc) {

        AppView.printFileName(getFilename(fc));
        AppView.printCharCount(getCharSize(fc));
        AppView.printWordsCount(getWordsSize(fc));
        AppView.printDictSize(getDictSize(fc));
        AppView.printWordCount("love", getCountOf(fc, "love"));
        AppView.printWordCount("hate", getCountOf(fc, "hate"));
        AppView.printWordCount("music", getCountOf(fc, "music"));
        AppView.printVowelsPercentage(getVowelsPercentage(fc));
        AppView.printMostUsedWords(getMostUsedWords(fc));
        AppView.printTwoElementsRatio("a", "e", getTwoElementsRatio("a", "e", fc));
        AppView.printAllElementsRatio(getRatioOfAllChars(fc));
    }

    public static String getFilename(FileContent fc) {

        return fc.getFileName();
    }

    public static int getCharSize(FileContent fc) {

        int size;
        Iterator<String> charIterator;

        charIterator = fc.charIterator();
        StatisticalAnalysis sa = new StatisticalAnalysis(charIterator);

        size = sa.size();
        return size;
    }

    public static int getWordsSize(FileContent fc) {

        int size;
        Iterator<String> wordsIterator;

        wordsIterator = fc.wordIterator();
        StatisticalAnalysis sa = new StatisticalAnalysis(wordsIterator);

        size = sa.size();
        return size;
    }

    public static int getDictSize(FileContent fc) {

        int dictSize;
        Iterator<String> wordsIterator;

        wordsIterator = fc.wordIterator();
        StatisticalAnalysis sa = new StatisticalAnalysis(wordsIterator);

        dictSize = sa.dictionarySize();
        return dictSize;
    }

    public static int getCountOf(FileContent fc, String... elements) {

        int count = 0;
        Iterator<String> wordIterator;
        Iterator<String> charIterator;
        StatisticalAnalysis sa;
        
        for (String element : elements) {

            if (element.length() > 1) {

                wordIterator = fc.wordIterator();
                sa = new StatisticalAnalysis(wordIterator);

                count += sa.countOf(element);

            } else {

                charIterator = fc.charIterator();
                sa = new StatisticalAnalysis(charIterator);

                count += sa.countOf(element);
            }
        }
        return count;
    }

    public static float getVowelsPercentage(FileContent fc) {

        float countOfAllVowels;
        float countOfAllChars;
        float percentage;

        countOfAllVowels = getCountOf(fc, "a", "e", "i", "o", "u");
        countOfAllChars = getCharSize(fc);

        percentage = countOfAllVowels / countOfAllChars * 100;
        return percentage;
    }

    public static Set<String> getMostUsedWords(FileContent fc) {

        int countOfAllWords = getWordsSize(fc);
        float onePercentOfWords;
        Iterator<String> wordIterator;
        Set<String> results;

        onePercentOfWords = countOfAllWords * 0.01f;

        wordIterator = fc.wordIterator();
        StatisticalAnalysis sa = new StatisticalAnalysis(wordIterator);
        results = sa.occurMoreThen(onePercentOfWords);
        
        return results;
    }

    public static float getTwoElementsRatio(String element1, String element2, FileContent fc){ 

        Iterator<String> charIterator;
        StatisticalAnalysis sa;
        Float ratio = 0f;

        charIterator = fc.charIterator();
        sa = new StatisticalAnalysis(charIterator);

        ratio = (float)sa.countOf(element2) / (float)sa.countOf(element1);
        
        return ratio;
    }

    public static ArrayList<String> getRatioOfAllChars(FileContent fc) {

        Iterator<String> charIterator;
        StatisticalAnalysis sa;
        ArrayList<String> ratioOfAllChars;

        charIterator = fc.charIterator();
        sa = new StatisticalAnalysis(charIterator);

        ratioOfAllChars = sa.ratioOfAllElements();

        return ratioOfAllChars;
    }
}