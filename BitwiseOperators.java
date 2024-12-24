public class BitwiseOperators {
    
    public static void EvenOdd(int n){
        int bitmask=1;
        if((n&bitmask)==0){
            System.out.println("Even");
        }
        else{
            System.out.println("Odd");
        }
    }

    public static int GetIthBit(int n,int i){
        int bitMask=1<<i;

        if((n&bitMask)==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int SetIthBit(int n, int i){
        int bitMask=1<<i;

        
        return n|bitMask;
    }
    public static int ClearIthBit(int n,int i){
        int BitMask=~(1<<i);
        return n&BitMask;
    }
    public static int updateBit(int n, int i, int NewBit){
        if(NewBit==0){
          return  ClearIthBit(n, i);
        }else{
           return SetIthBit(n, i);
        }
    }
    public static int clearIbits(int n, int i){
        int BitMask=~0<<i;

        return n & BitMask;
    }
    public static int ClearRangeOfBits(int n, int i, int j){
        int a= ~0<<(j+1);
        int b=(1<<i)-1;
        int BitMask=a|b;

        return n & BitMask;
    }
   
    public static int count (int n){
        int count =0;

        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
    public static int fastExpo(int a,int n){
        int ans=1;

        while(n>0){
            if((n&1)!=0){
                ans=ans*a;
            }
            a=a*a;
            n=n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n= 3;
        int a=5;
        //EvenOdd(n);
       // System.out.println(GetIthBit(n, 2));
       //System.out.println(SetIthBit(n, 2));
      // System.out.println(ClearIthBit(n, 1));
      //System.out.println(updateBit(n, 1,1));
      //System.out.println(clearIbits(n, 2));
     // System.out.println(ClearRangeOfBits(n,2,7 ));
     //System.out.println(count(n));
     System.out.println(fastExpo(a,n));
    }
}
