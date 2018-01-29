package src;

import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;

public class StatisticalAnalysis {

    private Iterator<String> iterator;
    private HashMap<String, Integer> map;

    public StatisticalAnalysis(Iterator<String> iterator) {

        this.iterator = iterator;
        this.map = new HashMap<String, Integer>();
        loadHashMap();
    }

    public void loadHashMap() {

        while (this.iterator.hasNext()) {
            String element = this.iterator.next().toLowerCase();

            if(this.map.containsKey(element)) {
                this.map.put(element, this.map.get(element) + 1);
            } else {
                this.map.put(element, 1);
            }
        }
    }

    public int countOf(String... elems) {
        
        int count = 0;
        for (String arg : elems) {
            if (map.containsKey(arg)){
                count += this.map.get(arg); 
            }
        }
        return count;
    }

    public int dictionarySize() {
        
        int sumOfUniqueElements;

        sumOfUniqueElements = this.map.keySet().size();
        
        return sumOfUniqueElements;
    }

    public int size() {
        
        int sum = 0;

        for (int value : this.map.values()) {
            sum += value;
        }
        return sum;
    }

    public Set<String> occurMoreThen(Float n) {

        Set<String> elementsSet = new HashSet<String>();

        for (String key : this.map.keySet()) {
            if (this.map.get(key) > n) {
                elementsSet.add(key);
            }
        }
        return elementsSet;
    }

    public ArrayList<String> ratioOfAllElements() {

        ArrayList<String> elementsRatio = new ArrayList<String>();
        float elementsCount;
        float allElementsCount;
        float ratio;
        String elementWithElementRatio;

        allElementsCount = size();

        for (String key : this.map.keySet()) {
            elementsCount = this.map.get(key);
            ratio = elementsCount / allElementsCount * 100;
            elementWithElementRatio = key + "->" + ratio;
            elementsRatio.add(elementWithElementRatio);
        }
        return elementsRatio;
    } 
}