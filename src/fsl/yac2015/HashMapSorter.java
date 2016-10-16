package fsl.yac2015;

import java.util.*;

public class HashMapSorter<TKey, TValue> {

    public final Comparator<Map.Entry<TKey, Integer>> INTEGER_VALUE_DESC_COMPARATOR =
            new Comparator<Map.Entry<TKey, Integer>>() {
                public int compare(Map.Entry<TKey, Integer> o1, Map.Entry<TKey, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            };

    public final Comparator<Map.Entry<TKey, Integer>> INTEGER_VALUE_ASK_COMPARATOR =
            new Comparator<Map.Entry<TKey, Integer>>() {
                public int compare(Map.Entry<TKey, Integer> o1, Map.Entry<TKey, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            };

    public final Comparator<Map.Entry<Integer, TValue>> INTEGER_KEY_DESC_COMPARATOR =
            new Comparator<Map.Entry<Integer, TValue>>() {
                public int compare(Map.Entry<Integer, TValue> o1, Map.Entry<Integer, TValue> o2) {
                    return o2.getKey() - o1.getKey();
                }
            };


    public final Comparator<Map.Entry<Integer, TValue>> INTEGER_KEY_ASK_COMPARATOR =
            new Comparator<Map.Entry<Integer, TValue>>() {
                public int compare(Map.Entry<Integer, TValue> o1, Map.Entry<Integer, TValue> o2) {
                    return o1.getKey() - o2.getKey();
                }
            };


    public HashMap<TKey, TValue> sortByValues(HashMap<TKey, TValue> map, Comparator<Map.Entry<TKey, TValue>> comparator) {
        List list = new LinkedList(map.entrySet());
        Collections.sort(list, comparator);
        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }


}
