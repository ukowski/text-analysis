package src;

import java.util.Iterator;
import java.util.ArrayList;

public class WordIterator implements Iterator {
    
    private int index;
    private ArrayList<String> list;

    public WordIterator(FileContent fileContent) {
        this.index = 0;
        this.list = fileContent.getWordsList();
    }

    public boolean hasNext() {

        if (index < this.list.size()) {
            return true;
        }
        return false;
    }

    public String next() {
        if (hasNext()) {
            return this.list.get(index++);
        }
        return null;
    }
}