import java.util.ArrayList;
import java.util.Collections;
public class AL {

    public static void SwapArrayList(ArrayList<Integer> list, int idx1 , int idx2 ){
        int temp = list.get(idx1);
        list.set(idx1 , list.get(idx2));
        list.set(idx2 , temp);
        System.out.println("Swap ArrayList");
        System.out.println(list);
    }
    public static void main(String[] args) {
        ArrayList <Integer> list=new ArrayList<>();
       
        //Add Element
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1,7);       //list.add(index,element);
        System.out.println(list);

        //Get operations
        int element = list.get(2);         //pass index
        System.out.println(element);

        //Remove element
        list.remove(2);    //pass index
        System.out.println(list);

        //set element at index
        list.set(2,10);                //list.set(index, new value)
        System.out.println(list);

        System.out.println(list.contains(1));       //pass element and it can tell element present or not
        
        System.out.println(list.size());            //it gives the size of arrayList

        //Iterate through Array
        System.out.println("Iteration of loop - ");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        //Print reverse array list
        System.out.println("Reverse Array List");
        for(int j=list.size()-1;j>=0;j--){
            System.out.print(list.get(j)+ " ");
        }
        System.out.println();

        //Find Max
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<list.size();i++){
           if(max<list.get(i)){
            max=list.get(i);
           }
        }
        System.out.println("Max element is "+max);

        //Swap Function
        SwapArrayList(list, 1, 2);

        //built in sorting function
        Collections.sort(list);          //Ascending order mai sort karega
        System.out.println("Sorted ArrayList =  "+list);

        Collections.sort(list, Collections.reverseOrder());     //Decesending order mai sort krta hai
        System.out.println("Sorted ArrayList in desending order =  "+list);   
    }
}
