package wt.model;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BellmanFordModel {
	public int n,t,start;
	public int cost[];
	public int distance[];
	public int visited[];
	public int pred[];
	public int count;
	public String out="";
	public int graph[][];
	public int edges[][];
	
	public BellmanFordModel(String count, String indices, String start) {
		this.n=Integer.parseInt(count);
		this.start=Integer.parseInt(start);
		this.cost=new int[this.n];
		
		indices=indices.substring(1, indices.length()-1);
		int x=(this.n*(this.n-1))/2;
		this.graph= new int[this.n][this.n];
		int ed=0;
		this.edges= new int[x][2];
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
				this.graph[i][j]=t;
				if(t!=0)
				{
					this.edges[ed][0]=i;
					this.edges[ed][1]=j;
					ed=ed+1;
				}
				j++;
			}
			
		}
		int Infinity=1000009;
		for(int i=0;i<this.n;i++)
			this.cost[i]=Infinity;
		this.cost[this.start]=0;
		
		for(int i=0;i<this.n-1;i++)
		{
			for(int j=0;j<ed;j++)
			{
				int u=this.edges[j][0],v=this.edges[j][1];
				if(this.cost[u]+this.graph[u][v]<this.cost[v])
					this.cost[v]=this.cost[u]+this.graph[u][v];
			}
		}
		x=1;                                                       
		for(int j=0;j<ed;j++)
		{
			int u=this.edges[j][0],v=this.edges[j][1];
			if(this.cost[u]+this.graph[u][v]<this.cost[v])
				x=0;
		}
		if(x==1)
		{
			this.out="There Are No Negative Cycles";
		}
		else
			this.out="Negative Cycle Detected";
			
		for(int i=0;i<this.n;i++)
			   System.out.println("Vertex"+i+" -> cost = "+this.cost[i]);
		
	}
}
