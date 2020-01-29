package com.example.java;

import java.util.*;

/**
 * Created by JOE on
 **/
public class SortedFrequency {

    public static void sortFreq(String[] str){

        ArrayList<String[]> strArray = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            strArray.add(i, str[i].split(" "));
        }

        HashMap<String, Integer> countMap = new HashMap<>();
        for (int j = 0; j < strArray.size(); j++) {
            System.out.println("\nPage " + (j+1));
            String[] elem = strArray.get(j);
            countMap.clear();
            for (int i = 0; i < elem.length; i++) {
                Integer count = countMap.get(elem[i]);
                if (count == null) {
                    countMap.put(elem[i], 1);
                } else {
                    countMap.put(elem[i], count + 1);
                }
            }
            Map<String, Integer> map = sort(countMap);
            Set set = map.entrySet();
            Iterator iter = set.iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry = (Map.Entry)iter.next();
                System.out.print(entry.getKey() + ": ");
                System.out.println(entry.getValue());
            }

        }
    }

    public static HashMap sort(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // defined the customized comparator here
        Collections.sort(list, new Comparator(){
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry)(o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });
        Collections.reverse(list);

        HashMap sortedHashMap = new LinkedHashMap();
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static void main(String args[]){
        SortedFrequency.sortFreq(new String[]{"nothing like you like something like me which nothing to be",
                "work hard play hard like a beast, work in the field"});
    }

    /*public static void sortFreq2(String[] str) {
        ArrayList<String[]> strArray = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            strArray.add(i, str[i].split(" "));
        }
        HashMap<String, Integer> countMap = new HashMap<>();
        for (int j = 0; j < strArray.size(); j++) {
            System.out.println("\nPage " + (j+1));
            String[] elem = strArray.get(j);
            countMap.clear();
            for (int i = 0; i < elem.length; i++) {
                Integer count = countMap.get(elem[i]);
                if (count == null) {
                    countMap.put(elem[i], 1);
                } else {
                    countMap.put(elem[i], count + 1);
                }
            }
            Map<Integer, String> map = new TreeMap<Integer, String>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            map.putAll(countMap);
            Set set = map.entrySet();
            Iterator iter = set.iterator();
            while (iter.hasNext()) {
                Map.Entry<String, Integer> entry = (Map.Entry)iter.next();
                System.out.print(entry.getKey() + ": ");
                System.out.println(entry.getValue());
            }

        }
    }
*/
}
