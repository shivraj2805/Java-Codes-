import java.util.ArrayList;
public class MultiDimmensionalArrayList {

    public static void printMultipleofList(){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1 ; i<=5 ;i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);

        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        System.out.println(mainList);

    }

    public static void SimpleConceptsOfMultiArrayList(){
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();

        ArrayList<Integer> List1 = new ArrayList<>();
        List1.add(1);
        List1.add(2);
        List1.add(3);
        mainList.add(List1);

        ArrayList <Integer> List2 = new ArrayList<>();
        List2.add(4);
        List2.add(5);
        List2.add(6);
        mainList.add(List2);

        ArrayList <Integer> List3 = new ArrayList<>();
        List3.add(7);
        List3.add(8);
        List3.add(9);
        mainList.add(List3);

        System.out.println(mainList);
        //print
        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> CurrList = mainList.get(i);

            for(int j=0;j<CurrList.size();j++){
                System.out.print(CurrList.get(j)+" ");
            }
            System.out.println();
        }
    }   
    public static void main(String args[]){
  
        printMultipleofList();
        SimpleConceptsOfMultiArrayList();
       
}

    }
   