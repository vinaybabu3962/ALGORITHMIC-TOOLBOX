package wt.model;

import java.util.StringTokenizer;

public class MatrixChainModel {
	public int n;
	public int[] arr;
	public char name;
	public String out="";
	public int result;
	public int[][] m;
	public void printParenthesis(int i, int j,
            int n, int[][] bracket)
	{
			// If only one matrix left in current segment
			if (i == j)
			{
			this.out+=(this.name++);
			return;
			}
			// System.out.print("(");
			this.out+="(";
			
			
			this.printParenthesis(i, bracket[i][j], n, bracket);
			this.printParenthesis(bracket[i][j] + 1, j, n, bracket);
			//System.out.print(")");
			this.out+=")";
	}
	void matrixChainOrder(int p[], int n)
	  {
	    this.m = new int[n][n];
	    int[][] bracket = new int[n][n];

	    for (int i = 1; i < n; i++)
	      this.m[i][i] = 0;

	    for (int L = 2; L < n; L++)
	    {
	      for (int i = 1; i < n - L + 1; i++)
	      {
	        int j = i + L - 1;
	        this.m[i][j] = Integer.MAX_VALUE;
	        for (int k = i; k <= j - 1; k++)
	        {
	          int q = this.m[i][k] + this.m[k + 1][j] + p[i - 1] * p[k] * p[j];
	          if (q < this.m[i][j])
	          {
	           this.m[i][j] = q;
	            bracket[i][j] = k;
	          }
	        }
			
	      }
	    }

	    this.name = 'A';
	    System.out.print("Optimal Parenthesization is : ");
	    this.printParenthesis(1, n - 1, n, bracket);
		this.result= this.m[1][n - 1];
	    System.out.print("\nOptimal Cost is : " + this.m[1][n - 1]);
	  }
	
	public MatrixChainModel(String count, String indices) {
		this.n=Integer.parseInt(count);
		this.arr=new int[this.n];
		StringTokenizer s1=new StringTokenizer(indices,",");
		int i=0;
		while(s1.hasMoreTokens()) {
			this.arr[i]=Integer.parseInt(s1.nextToken());
			i++;
		}
		//MatrixChainModel a=new MatrixChainModel();
	    this.matrixChainOrder(this.arr,this.n);
	    System.out.println("para:"+this.out+this.result);
		
	}
	public MatrixChainModel() {
		// TODO Auto-generated constructor stub
	}

}
