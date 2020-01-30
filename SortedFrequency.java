package com.example.java;

import java.util.*;

/**
 * Created by JOE on
 **/
public class SortedFrequency {

    public static void sortFreq(String[] str){

        /*
        * You have a book wich precents you some pages. You want to look through this book and get
          the count of each words that show up. When you collected that for each page you are to sort the
          order of base on frequency of collected words. (dont worry about "," , "?" "." or any other type of symbol)
          example input : [
                    ["nothing like you like something like me which nothing to be"],
                    ["work hard play hard like a  beast, work in the feild"]
                ]
          output :
            page 1
            like     : 3
            nothing  : 2
            you      : 1
            something: 1
            me       : 1
            which    : 1
            to       : 1
            be       : 1
            page 2
            word     : 2
            hard     : 2
            play     : 1
            like     : 1
            a        : 1
            beast    : 1
            in       : 1
            the      : 1
            field    : 1
        Please place description on top of the code which you are doing and use clean code principles.
        * */

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
    
}
