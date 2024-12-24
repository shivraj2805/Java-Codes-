public class recursion {
    public static void printDec(int n){
        if(n==1){
            System.out.println(n);
            return; 
        }

         System.out.println(n);
         printDec(n-1);
    }

    public static void inc(int n){
            if(n==1){
                System.out.println(n);
                return; 
            } 
             inc(n-1);
             System.out.println(n);
    }

    public static int fact(int n){
        if(n==1){
            return 1;
        }

        return n*fact(n-1);
    }

    public static int printSumOfNat(int n){
        if(n==1){
            return 1;
        }

        return n+ printSumOfNat(n-1);
    }

    public static int fab(int n){ //print nth fabonaci number
        if(n==0){
            return 0;
        }

        if(n==1){
            return 1;
        }

        return fab(n-1)+fab(n-2);
    } 

    public static boolean isSorted(int arr[],int i){
        if(i==arr.length-1){
            return true;
        }

        if(arr[i]>arr[i+1]){
            return false;
        }

        return isSorted(arr, i+1);
    }

    public static int firstoccurence(int arr[],int key,int i){
        if(i==arr.length-1){
            return -1;
        }

        if(arr[i]==key){
            return i;
        }

        return firstoccurence(arr, key, i+1);

    }

    public static int lastoccurence(int arr[],int key,int i){
        if(i==arr.length){
            return -1;
        }

      int isFound =lastoccurence(arr, key, i+1);
       if(isFound==-1 && arr[i]==key){
        return i;
       }
       return isFound;

    }

    public static int Power(int x,int n){
        if(n==0){
            return 1;
        }

        return x*(Power(x, n-1));
    }

public static int Optimizepower(int x,int n){
    if(n==0){
        return 1;
    }

    int halfpower=Optimizepower(x, n/2);
    int halfpowerSq = halfpower * halfpower;

    if(n%2 !=0){ //odd
        return x*halfpowerSq;
    }
    return halfpowerSq;
}
public static int tillingProblem (int n){
    //base case 
    if(n==0 || n==1){
        return 1;
    }

    //Vertical choice
    int fnm1 = tillingProblem(n-1);

    //horizontal Choice
    int fnm2=tillingProblem(n-2);

    int totalWays = fnm1 + fnm2;
    return totalWays;

}

public static int friendsPairing(int n){
    //base case
    if(n==1 || n==2){
        return n;
    }

    //choice

    //Single choice
    int fnm1 = friendsPairing(n-1);

    //pair
    int fnm2= (n-1) * friendsPairing(n-2);

    //Total Ways
    int totalways = fnm1 + fnm2;

    return totalways;
}

public static void printBinString(int n, int lastPlace,String str){
    if(n==0){
        System.out.println(str);
    }

    printBinString(n-1, 0, str+ "0");

    if(lastPlace ==0){
        printBinString(n-1, 1, str+"1");
    }
}
    public static void main(String[] args) {
       // printDec(10);
        //inc(10);
        //System.out.println(fact(5));
        //System.out.println(printSumOfNat(5));
        //System.out.println(fab(6)); //6th fabonainci number is 8
        //int arr[]={1,2,3,44,5,44};
        //System.out.println(isSorted(arr, 0));
        //System.out.println(firstoccurence(arr, 44, 0));
        //System.out.println(lastoccurence(arr, 44, 0));
        //System.out.println(Power(10, 9));
        //System.out.println(Optimizepower(2, 4));
        //System.out.println(tillingProblem(10));
        //System.out.println(friendsPairing(3));
        printBinString(2, 0, "");

    }
}
