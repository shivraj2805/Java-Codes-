public class Stock {
    public static int buyAndSell(int prices[]){
        int buyPrice=Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                int profit=prices[i]-buyPrice;
                maxProfit=Math.max(maxProfit, buyPrice);
            }else{
                buyPrice=prices[i];
            }

        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[]={1,2,3,4,58,5,55,66,2};
        System.out.println(buyAndSell(prices));;
    }
}
