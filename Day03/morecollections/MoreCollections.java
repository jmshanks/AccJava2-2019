package morecollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class MoreCollections {

    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
        LinkedList lList = new LinkedList();
        HashSet hSet = new HashSet();
        TreeSet tSet = new TreeSet();
        HashMap hMap = new HashMap();
        TreeMap tMap = new TreeMap();
        
        List<Integer> list = aList;
        Set set = tSet;
        Map<String, String> map = hMap;
        
        list.add(12);
        list.add(13);
        list.add(4);
        list.add(4); //Will be added, since List, not Set
        list.add(7);
        list.sort(null);
        for (int x : list) {
            System.out.println(x);
        }
        System.out.println("\n");
        Collections.shuffle(list, new Random(System.currentTimeMillis()));
        for (int x : list) {
            System.out.println(x);
        }
        System.out.println("\n");
        set.add(4);
        set.add(4); //Will not be added, duplicate
        set.add(7);
        set.add(8);
        set.add(1);
        for (Object x : set) {
            System.out.println(x);
        }
        System.out.println("\n");
        
        map.put("Do", "A deer, a female deer.");
        map.put("Re", "A drop of golden sun!");
        map.put("Mi", "A name, I call myself.");
        map.put("Do", "The stuff that buys my beer.");
//        System.out.println("Do: " + map.get("Do"));
        for(String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
        
        Map<String, List<String>> dictionary = new TreeMap();
        addDef(dictionary, "Do", "A deer, a female deer.");
        addDef(dictionary, "Do", "The stuff that buys my beer.");
        System.out.println(dictionary);
    }
    
    public static void addDef(Map<String, List<String>> dict, String key, String def) {
        List<String> blah = dict.get(key);
        if (blah == null) {
            List blah2 = new LinkedList();
            blah2.add(def);
            dict.put(key, blah2);
        }
        else {
            blah.add(def);
        }
    }
    
}
