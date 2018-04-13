package src.dao;

import java.util.Iterator;

public interface IterableText {

    public Iterator<String> charIterator();

    public Iterator<String> wordIterator();
}