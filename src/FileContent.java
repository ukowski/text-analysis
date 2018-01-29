package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Iterator;


public class FileContent implements IterableText {

    private String fileName;
    private ArrayList<String> fileContent;
    private ArrayList<String> wordsList;
    private ArrayList<String> charsList;

    public FileContent(String fileName) {
        
        this.fileName = fileName;
        this.fileContent = loadData();
        this.wordsList = loadWordsList();
        this.charsList = loadCharsList();
    }

    public Iterator<String> charIterator() {

        CharIterator charIterator = new CharIterator(this);
        return charIterator; 
    }

    public Iterator<String> wordIterator() {
        
        WordIterator wordIterator = new WordIterator(this);
        return wordIterator;
    }

    public String getFileName() {
        return this.fileName;
    }

    public ArrayList<String> getWordsList() {
        
        return this.wordsList;
    }

    public ArrayList<String> getCharsList() {
        
        return this.charsList;
    }

    public ArrayList<String> loadData() {

        ArrayList<String> fileContent = new ArrayList<String>();

        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(this.fileName)))) {

            while (scanner.hasNextLine()) {
                
                String line = scanner.nextLine();
                fileContent.add(line);
            }

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public ArrayList<String> loadWordsList() {

        ArrayList<String> wordsList = new ArrayList<String>();

        for (String line : this.fileContent) {

            if (!line.equals("")){
                String[] splitedLine = line.split("\\s+");
                int wordsInLine = splitedLine.length;

                for (int i=0 ; i < wordsInLine ; i++) {
                    String word = splitedLine[i];
                    wordsList.add(word);
                }
            }
        }
        return wordsList;
    }
    
    public ArrayList<String> loadCharsList() {

        ArrayList<String> charsList = new ArrayList<String>();

        for (String line : this.fileContent) {

            line = line.replaceAll("\\s+", "");
            
            if(!line.equals("")) {
                for (int i=0 ; i < line.length() ; i++) {
                    char character = line.charAt(i);
                    String strCharacter = String.valueOf(character);
                    charsList.add(strCharacter);
                }
            }
        }
        return charsList;
    }
}