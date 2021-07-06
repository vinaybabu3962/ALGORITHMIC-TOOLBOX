package wt.model;
import java.util.*;
public class GreedyKnapsackModel {
	public int capacity;
	public int n;
	public int  [] val;
	public int  [] profits;
	public int [] wt;
	public int  [] weights;
	public double [] sel;
	public double [] sel01;
	public double totalValue = 0d;
	public double totalValue01= 0d;
	static class ItemValue {
		Double cost;
		double wt, val, ind;
		public ItemValue(int wt, int val, int ind)
		{

			this.wt = wt;
			this.val = val;
			this.ind = ind;
			cost = new Double((double)val / (double)wt);
		}
	}
	public GreedyKnapsackModel(String count, String profits, String weights, String weight) {
		this.n=Integer.parseInt(count);
		StringTokenizer s1=new StringTokenizer(profits,",");
		StringTokenizer s2=new StringTokenizer(weights,",");
		this.capacity=Integer.parseInt(weight);
		int i=0;
		this.wt=new int[this.n];
		this.val=new int[this.n];
		this.weights=new int[this.n];
		this.profits=new int[this.n];
		while (s1.hasMoreTokens()) {
			this.val[i]=Integer.parseInt(s1.nextToken());
			this.wt[i]=Integer.parseInt(s2.nextToken());
			this.profits[i]=this.val[i];
			this.weights[i]=this.wt[i];
			i+=1;
		}
		
		ItemValue[] iVal = new ItemValue[this.n];
		this.sel=new double[this.n];
		this.sel01=new double[this.n];
		for (i = 0; i <this.n; i++) {
			iVal[i] = new ItemValue(this.wt[i], this.val[i], i);
			this.sel[i]=0d;
			this.sel01[i]=0d;
		}

		// sorting items by value;
		Arrays.sort(iVal, new Comparator<ItemValue>() {
		@Override
		public int compare(ItemValue o1, ItemValue o2)
		{
		return o2.cost.compareTo(o1.cost);
		}
		});

		int temp=this.capacity;

		for (ItemValue it : iVal) {

			int curWt = (int)it.wt;
			int curVal = (int)it.val;

			if (this.capacity - curWt >= 0) {
		
		
				this.capacity = this.capacity - curWt;
				this.totalValue += curVal;
				this.sel[(int)it.ind]=(double)1d;

			}
			else {
		
				double fraction= ((double)this.capacity / (double)curWt);
				this.sel[(int)it.ind]=(double)fraction;
				this.totalValue += (curVal * fraction);
				this.capacity= (int)(this.capacity - (curWt * fraction));

				break;
			}
		
		 
		}
		this.capacity=temp;
		for (ItemValue it : iVal) {

			int curWt = (int)it.wt;
			int curVal = (int)it.val;

			if (this.capacity - curWt >= 0) {
		
		
				this.capacity = this.capacity - curWt;
				this.totalValue01 += curVal;
				this.sel01[(int)it.ind]=(double)1d;

			}
			
		
		 
		}

		
		
		 for( i=0;i<this.n;i++){ System.out.print(this.sel[i]+" " );
		  
		 } System.out.println();
		 


		 System.out.println("Maximum value we can obtain = " + this.totalValue);
		
		
	}

	
}
