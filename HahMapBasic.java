import java.util.*;
public class HahMapBasic {
   public static void main(String[] args) {
    HashMap<String,Integer>hm=new HashMap<>();

    //Insert 
    hm.put("India",100);
    hm.put("China", 150);
    hm.put("USA", 50);

    System.out.println(hm);

    //get
    int popullation=hm.get("India");
    System.out.println(popullation);

    //contains
    System.out.println(hm.containsKey("India"));
    System.out.println(hm.containsKey("Indonesia"));

    //remove
    System.out.println(hm.remove("China"));
    System.out.println(hm);

    //size
    System.out.println(hm.size());

    //is empty
    System.out.println(hm.isEmpty());

    //clear all
    hm.clear();
    System.out.println(hm.isEmpty());

    
   }
}
