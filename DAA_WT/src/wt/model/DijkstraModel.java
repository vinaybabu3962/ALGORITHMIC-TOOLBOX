package wt.model;

import java.util.StringTokenizer;
import java.util.*;
public class DijkstraModel {
	public int n;
	public int cost[][];
	public int distance[];
	public int visited[];
	public int pred[];
	public int count;
	public int start;
	public String out[];
	
	public DijkstraModel(String count, String indices, String start) {
		
		this.n=Integer.parseInt(count);
		this.start=Integer.parseInt(start);
		this.cost=new int[this.n][this.n];
		//System.out.println(indices);
		indices=indices.substring(1, indices.length()-1);
		//System.out.println(indices);
		Scanner sc=new Scanner(indices);
		
		System.out.println("***********************");
		
		
		int i=0;
		for( i=0;i<this.n;i++)  {
			String s=sc.nextLine();
			if(i!=this.n-1)
			s=s.substring(1,s.length()-2);
			else
				s=s.substring(1,s.length()-1);
				
			StringTokenizer s1=new StringTokenizer(s);
			int j=0;
			while(s1.hasMoreTokens()) {
				int x=Integer.parseInt(s1.nextToken());
				if(x==0) 
					this.cost[i][j]=1000009;
				else
					this.cost[i][j]=x;
				j++;
			}
		}
		
		for(i=0;i<this.n;i++) {
			for(int j=0;j<this.n;j++) {
				System.out.print(this.cost[i][j]+" ");
			}
			System.out.println();
		}
		this.distance=new int[this.n];
		this.visited=new int[this.n];
		this.pred=new int[this.n];
		this.count=1;
		int mindist=1000009;
		
		for( i=0;i<this.n;i++){
			this.distance[i]=this.cost[this.start][i];
			this.pred[i]=this.start;
			this.visited[i]=0;
		}
		this.distance[this.start]=0;
		this.visited[this.start]=1;
		int nextnode=0;
		while(this.count<this.n-1){
			
			mindist=1000009;
			for(i=0;i<this.n;i++)
				if(this.distance[i]<mindist&&this.visited[i]==0)
				{
					mindist=this.distance[i];
					nextnode=i;
				}
				this.visited[nextnode]=1;
				for( i=0;i<this.n;i++)
				{
					if(this.visited[i]==0)
						if(mindist+this.cost[nextnode][i]<this.distance[i])
						{
								this.distance[i]=mindist+this.cost[nextnode][i];
								this.pred[i]=nextnode;
								
						}
				}        
				this.visited[nextnode]=1;
				this.count++;	
		}
		this.out=new String[this.n];
		for( i=0;i<this.n;i++)
			{
				this.out[i]="";
				if(i!=this.start)
				{
					//printf("\nDistance of node%d=%d",i,distance[i]);
					//printf("\nPath=%d",i);
					this.out[i]+="Path="+i;
					int j=i;
					do
					{
						j=pred[j];
						this.out[i]+="<-"+j;
						//printf("<-%d",j);
					}while(j!=this.start);
			    }
				
			}
			for( i=0;i<this.n;i++)
				System.out.println(this.out[i]);
	}
}
