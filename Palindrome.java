public class Palindrome {
    public static boolean isPalindrome(int n){
        int reverse = 0;
        while(n!=0){
            int reminder = n%10;
            reverse =(int) (reverse*10 + reminder);
            n = n/10;
        }
       
        if(n==reverse){
            return true;
        }
            return false;
        
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1991));
    }
}
