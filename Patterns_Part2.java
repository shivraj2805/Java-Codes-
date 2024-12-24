public class Patterns_Part2 {
    public static void HollowRectangular(int totRows , int totCols){
        for(int i=1;i<=totRows;i++){
            for(int j =1 ; j<=totCols;j++){
                if(i == 1 ||i==totRows || j ==1  || j==totCols){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void Rotated_Half_Pyramid(int n){
        //outer loop
        for(int i =1; i<=n;i++){
            //space
        for(int j = 1 ; j<=n-i;j++){
            System.out.print("  ");
        }

        //Star
        for(int j=1;j<=i;j++){
            System.out.print( " *");
        }

        System.out.println();
        }
    }

    public static void InvertedHalfPyramidWithNum(int n){
        for(int i =1; i<=n;i++){
            for(int j =1;j<=n-i+1;j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void FloydsTrainglePattern(int n){
        for(int i =1;i<=n;i++){
           int counter =1;
           for(int j=1;j<=i;j++){
            System.out.print(counter+" ");
            counter ++;
           }
           System.out.println();
        }
    }

    public static void TrainglePattern(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0  ");
                }
            }
            System.out.println();
        }
    }

    public static void Butterfly(int n){
        //1st Half
        for(int i=1;i<=n;i++){
            //star
        for(int star=1;star<=i;star++){
            System.out.print(" * ");
        }

        //space
        for(int j=1;j<=2*(n-i);j++){
            System.out.print("   ");
        }
         //star
         for(int star=1;star<=i;star++){
            System.out.print(" * ");
        }
        System.out.println();
            
        }
         //2nd Half
        for(int i=n;i>=1;i--){
            //star
        for(int star=1;star<=i;star++){
            System.out.print(" * ");
        }

        //space
        for(int j=1;j<=2*(n-i);j++){
            System.out.print("   ");
        }
         //star
         for(int star=1;star<=i;star++){
            System.out.print(" * ");
        }
        System.out.println();
        }
    }

    public static void solidRhombus(int n){
        for(int i=1;i<=n;i++){
            //Space
            for(int j=1;j<=n-i;j++){
                System.out.print("   ");
            }

            //Star

            for(int j=1; j<=n;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
        }

        public static void HollowRhombus(int n){
            for(int i=1;i<=n;i++){
                //Space
                for(int j=1;j<=n-i;j++){
                    System.out.print("   ");
                }

                //Star+Space

                for(int j=1;j<=n;j++){
                    if(i==1 || i==n || j==1 || j==n){
                        System.out.print(" * ");
                    }
                    else{
                        System.out.print("   ");
                    }
                }

                System.out.println();
            }
        }
     public static void diamond(int n){

        //1st Half
        for(int i=1;i<=n;i++){
            //Space

            for(int j=1;j<=n-i;j++){
                System.out.print("   ");
            }

            //Star
            for(int j=1;j<=2*i-1;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }

        //2nd Half
        for(int i=n;i>=1;i--){
            //Space

            for(int j=1;j<=n-i;j++){
                System.out.print("   ");
            }

            //Star
            for(int j=1;j<=2*i-1;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
     }
    public static void main(String[] args) {
        //HollowRectangular(4, 5);
        //Rotated_Half_Pyramid(4);
        //InvertedHalfPyramidWithNum(5);
        //FloydsTrainglePattern(5);
        //TrainglePattern(5);
        //Butterfly(5);
        //solidRhombus(5);
        //HollowRhombus(5);
        diamond(4);
    }
}
