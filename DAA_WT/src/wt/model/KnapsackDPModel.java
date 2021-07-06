package wt.model;

import java.util.StringTokenizer;

public class KnapsackDPModel {
	public int n,W;
	public int [] val;
	public int [] wt;
	public int [][] k;
	public int total;
	public int[] sel;
	static int max(int a, int b)
    {
          return (a > b) ? a : b;
    }
	public KnapsackDPModel(String count, String profits, String weights, String weight) {
		this.n=Integer.parseInt(count);
		StringTokenizer s1=new StringTokenizer(profits,",");
		StringTokenizer s2=new StringTokenizer(weights,",");
		this.W=Integer.parseInt(weight);
		int i=0;
		this.wt=new int[this.n];
		this.val=new int[this.n];
		
		while (s1.hasMoreTokens()) {
			this.val[i]=Integer.parseInt(s1.nextToken());
			this.wt[i]=Integer.parseInt(s2.nextToken());
		
			i+=1;
		}
		this.k = new int[n + 1][W+ 1];
        
		for (i = 0; i <= n; i++)
        {
            for (int w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                	this.k[i][w] = 0;
                else if (wt[i - 1] <= w)
                	this.k[i][w]
                        = max(val[i - 1]
                         + this.k[i - 1][w - wt[i - 1]],
                         this.k[i - 1][w]);
                else
                	this.k[i][w] = this.k[i - 1][w];
            }
        }
		this.total=this.k[n][W];
		this.sel=new int[n];
		for(int i1=0;i1<n;i1++) this.sel[i1]=0;
		System.out.println(this.k[n][W]);
		int res=this.k[n][W];
		int w=W;
		for (i = n; i > 0 && res > 0; i--) { 
  
            if (res == this.k[i - 1][w]) 
                continue; 
            else { 
  

				this.sel[i-1]=1;
  

                res = res - val[i - 1]; 
                w = w - wt[i - 1]; 
            } 
        }
		
	}

}
