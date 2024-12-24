import java.util.ArrayList;

public class MostWaterInAContainer{
    public static int storedWater(ArrayList<Integer> height){             //Time Complexity => O(N^2)
        int maxWater=0;

        for(int i=0;i<height.size();i++){
            for(int j=i;j<height.size();j++){
                int ht = Math.min(height.get(i), height.get(j));
                int width=j-i;
                int CurrWater = ht*width;
                maxWater = Math.max(maxWater, CurrWater);
            }
        }
        return maxWater;
    }

    public static int OptimizeCodeForStoredWater(ArrayList<Integer> height){         //Time Complexity => o(N)
        int lp=0;
        int rp=height.size()-1;
        int maxWater=0;

        while(lp<rp){
            //calulate Area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp-lp;
            int CurrWater=ht*width;
            maxWater=Math.max(maxWater, CurrWater);

            //pointer increse
            if(height.get(lp)<height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        height.add(10);

        System.out.println(storedWater(height));
        System.out.println(OptimizeCodeForStoredWater(height));
    }
    
}