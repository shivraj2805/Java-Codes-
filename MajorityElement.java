import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        HashMap<Integer , Integer > map=new HashMap<>();

        int arr[]={1,3,2,5,1,3,1,5,1};

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }

        Set<Integer> keySet= map.keySet();

        for (Integer key : keySet) {
            if(map.get(key) > arr.length/3){
                System.out.println(key);
            }
        }
    }
}
