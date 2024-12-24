public class DecToBin {
    public static void decToBinary(int DecNum){
        int pow = 0;
        int binNum =0;

        while(DecNum > 0){
            int rem = DecNum % 2;
            binNum = binNum + (int)(rem * Math.pow(10,pow));
            DecNum = DecNum/2;
            pow++;
        }
        System.out.println((binNum));
    }

    public static void main(String[] args) {
        decToBinary(15);
    }
}
