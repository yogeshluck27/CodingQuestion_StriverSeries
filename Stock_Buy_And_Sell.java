
public class Stock_Buy_And_Sell {

	public static void main(String[] args) {
		
		System.out.println(calculateProfit(new int[]{7 , 1 ,5 , 3 , 6 ,4}));
	}
	
	//[7 , 1 ,5 , 3 , 6 ,4 ] 
	//min = MAX_VALUE ; profit = 0
	
	// 	min = 1 
	//	Profit = 5

	/*Create a variable maxPro and store 0 initially.
	Create a variable minPrice and store some larger value(ex: MAX_VALUE) value initially.
	Run a for loop from 0 to n.
	Update the minPrice to current element if minPrice is greater than the current element of the array
	Take the difference of the minPrice with the current element of the array and 
	compare and maintain it in maxPro.
	Return the maxPro.*/
	
	public static int calculateProfit(int[] prices){
		int maxprofit = 0;
		int minprice = Integer.MAX_VALUE;
		
		for(int i=0;i<prices.length;i++){
			
			if(prices[i] < minprice){
				minprice=prices[i]; // 1 
			}else if (prices[i]-minprice > maxprofit){ //4 //2 //5 //3 .So 5 is maxProfit
				maxprofit = prices[i]-minprice;
				
			}
		}
		
		return maxprofit;
		
	}
}
