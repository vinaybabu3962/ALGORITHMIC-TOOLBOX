package wt.model;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FloydWarshallModel {
	public int n,t,start;
	public int cost[];
	public int distance[];
	public int visited[];
	public int pred[];
	public int count;
	public String out="";
	public int graph[][];
	public int edges[][];
	public FloydWarshallModel(String count,String indices) {
		this.n=Integer.parseInt(count);
		indices=indices.substring(1, indices.length()-1);
		this.graph= new int[this.n][this.n];
		Scanner sc=new Scanner(indices);
		for(int i=0;i<this.n;i++)
		{
			String s=sc.nextLine();
			if(i!=this.n-1)
			s=s.substring(1,s.length()-2);
			else
				s=s.substring(1,s.length()-1);
				
			StringTokenizer s1=new StringTokenizer(s);
			int j=0;
			while(s1.hasMoreTokens()) {
				int t=Integer.parseInt(s1.nextToken());
				
				if(t==0)
				{
					if(i==j) {
						this.graph[i][j]=0;
					}
					else {
						this.graph[i][j]=10000007;
					}
				}
				else {
					this.graph[i][j]=t;
				}
				j++;
			}
			
			
		}
		for(int i=0;i<this.n;i++)
		{
			for(int j=0;j<this.n;j++)
			{
				for(int k=0;k<this.n;k++)
				{
					if(this.graph[i][k]+this.graph[k][j]<this.graph[i][j])
					{
						this.graph[i][j]=this.graph[i][k]+this.graph[k][j];
					}
				}
			}
		}
		
	}
}
