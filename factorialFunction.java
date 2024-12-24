public class factorialFunction {
   
    public static int fact(int n){
        if (n==0){
            return 1;
        }

        int f=1;
        for(int i =1; i<=n;i++){
            f*=i;
        }
        return f;

    }
    public static void main(String[] args) {
        System.out.println(fact(45));
    }
}
