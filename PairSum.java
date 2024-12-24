import java.util.ArrayList;

public class PairSum {
    public static boolean PairSumFun1(ArrayList<Integer> list , int target){
        for(int i=0;i<list.size();i++){
            for(int j=i+1;j<list.size();j++){
                if(list.get(i)+list.get(j)==target){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean OptimizeCodePairSum2(ArrayList<Integer> list , int target){
        int lp=0;
        int rp=list.size()-1;

        while(lp<rp){
            if(list.get(lp)+list.get(rp)==target){
                return true;
            }else if(list.get(lp)+list.get(rp)<target){
                lp++;
            }else{
                rp--;
            }
        }
        return false;
    }

    //code for roatated sorted array list

    public static boolean sumPair2(ArrayList<Integer> list2, int target){
        int pivote=-1;
        int n=list2.size()-1;

        for(int i=0;i<list2.size();i++){
            if(list2.get(i)>list2.get(i+1)){
                pivote=i;
                break;
            }
        }
        int lp=pivote+1;           //smallest
        int rp=pivote;             //largest

        while(lp!=rp){

            if(list2.get(lp)+list2.get(rp)==target){
                return true;
            }else if(list2.get(lp)+list2.get(rp)<target){
                lp=((lp+1)%n);
            }else{
               rp= (n-1+rp);
            }
        }
        return false;

        }
    

    public static void main(String[] args) {
    ArrayList<Integer> list=new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);

    int target=11;
    System.out.println(PairSumFun1(list, target));
    System.out.println(OptimizeCodePairSum2(list, target));

    ArrayList<Integer> list2 = new ArrayList<>();
    list2.add(11);
    list2.add(15);
    list2.add(6);
    list2.add(8);
    list2.add(9);
    list2.add(10);
    
    int target2=16;
    System.out.println(sumPair2(list2, target2));


    }
}
