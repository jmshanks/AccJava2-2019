
package collectionfun19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionFun19 {

    public static void main(String[] args) {
        //** Lists
        ArrayList<Integer> alist = new ArrayList(); //Like arrays, only magical.
        //Great at searching, BAD at adding/removing.
        
        LinkedList llist = new LinkedList(); //Like arrays, but...
        //great at adding/removing, and not great at searching.
        
        alist.add(12);
        alist.add(13);
        alist.add(4);
        alist.add(2, 13);  
        System.out.println("Object at 2: " + alist.get(2));
        System.out.println("List contains 13: " + alist.contains(13));
        System.out.println("Index of the 13: " + alist.indexOf(13));
//        alist.remove(0);
        alist.remove(new Integer(13));
        for(int i : alist) {
            System.out.println(i);
        }
        
        List list = new ArrayList(); //new LinkedList();
        
        //** Sets -- Collections of unique values. 
        System.out.println("Moving on to sets...\n\n");
        Set set = new HashSet(); //Unordered
        Set<Object> tset = new TreeSet(); //Ordered
        set.add("Blah");
        set.add(2);
        set.add(12312.3123);
        set.add(new ArrayList());
        set.add(new TreeSet());
        for (Object o : set) {
            System.out.println(o);
        }
        
        //** Maps
        Map<String,String> hmap = new HashMap(); //Unorder Map (Dictionary)
        Map tmap = new TreeMap(); //Ordered Map (Dictionary)
        hmap.put("Boy", "A young male of a species");
        String x = hmap.getOrDefault("boy", "Not Found");
        System.out.println(x);
    }
    
}
