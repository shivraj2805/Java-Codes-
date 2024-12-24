public class PairsOfArray {
    public static void pairsOfArray(int array[]){
        int totPairs=0;
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                System.out.print("("+array[i]+","+array[j]+")");
                totPairs++;
            }
            System.out.println();
        }
        System.out.println(totPairs);
    }

    public static void main(String[] args) {
        int array[]={2,4,6,8,10};
        pairsOfArray(array);
    }
}
