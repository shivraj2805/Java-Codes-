public class binomialCoefficient {
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
    public static int binomialCoefficientCal(int n,int r){
        int a = fact(n);
        int b  = fact(r);
        int c = fact(n-r);

        int binomial = (int) (a/(b*c));
        return binomial;
    }

    public static void main(String[] args) {
       System.out.println(binomialCoefficientCal(5, 3)); 
    }
}
