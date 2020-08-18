package basic.arrays;

/*
    Input : {1, 5, 3, 8, 12}
    Output : 13
 */
public class StockBuyAndSell {

    public static void main(String[] args) {

        int [] price = {1, 5, 3, 8, 12};
        System.out.println(getMaxProfitNaiveSol(price, 0, 4));
        System.out.println(getMaxProfitBetterEasySol(price));
    }

    // end is n-1
    private static int getMaxProfitNaiveSol(int [] price, int start, int end){

        if(end <= start) return 0;

        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i+1; j <= end; j++) {
                if(price[j] > price[i]){

                    int currProfit = price[j] - price[i]
                            + getMaxProfitNaiveSol(price, start, i-1) // to the left of i
                            + getMaxProfitNaiveSol(price, j+1, end); // to the right of j

                    profit = getMax(profit, currProfit);
                }
            }
        }
        return profit;
    }

    private static int getMax(int a, int b){
        if(a > b) return a;
        else return b;
    }

    private static int getMaxProfitBetterEasySol(int [] price){

        int n = price.length;
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if(price[i] > price[i-1]){
                profit += price[i] - price[i-1];
            }
        }

        return profit;
    }

}
