public class binToDec {
    public static void binToDecNum(int binNum){
        int pow = 0;
        int decNum = 0;

        while(binNum > 0){
           int lastDigit = binNum % 10;
           decNum = decNum + (int)(lastDigit * Math.pow(2,pow));
           binNum = binNum /10;
           pow++;

        }
        System.out.println(decNum);
    }
    public static void main(String[] args) {
        binToDecNum(1100);
    }
}
