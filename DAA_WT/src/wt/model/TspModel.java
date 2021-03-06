package wt.model;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TspModel {
	public int n;
	public int final_path[] ;
	
    public boolean visited[];

    public int final_res = Integer.MAX_VALUE;
    
    public void copyToFinal(int curr_path[])
    {
        for (int i = 0; i <  this.n; i++)
            this.final_path[i] = curr_path[i];
         this.final_path[n] = curr_path[0];
    }
  
    
    public int firstMin(int adj[][], int i)
    {
        int min = Integer.MAX_VALUE;
        for (int k = 0; k <  this.n; k++)
            if (adj[i][k] < min && i != k)
                min = adj[i][k];
        return min;
    }
    public int secondMin(int adj[][], int i)
    {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int j=0; j< this.n; j++)
        {
            if (i == j)
                continue;
  
            if (adj[i][j] <= first)
            {
                second = first;
                first = adj[i][j];
            }
            else if (adj[i][j] <= second &&
                    adj[i][j] != first)
                second = adj[i][j];
        }
        return second;
    }
    public void TSPRec(int adj[][], int curr_bound, int curr_weight,
            int level, int curr_path[])
{

    if (level ==  this.n)
    {

        if (adj[curr_path[level - 1]][curr_path[0]] != 0)
        {

            int curr_res = curr_weight +
                    adj[curr_path[level-1]][curr_path[0]];
  

            if (curr_res <  this.final_res)
            {
                copyToFinal(curr_path);
                 this.final_res = curr_res;
            }
        }
        return;
    }


    for (int i = 0; i <  this.n; i++)
    {
      
        if (adj[curr_path[level-1]][i] != 0 &&
                 this.visited[i] == false)
        {
            int temp = curr_bound;
            curr_weight += adj[curr_path[level - 1]][i];

            if (level==1)
            curr_bound -= ((firstMin(adj, curr_path[level - 1]) +
                            firstMin(adj, i))/2);
            else
            curr_bound -= ((secondMin(adj, curr_path[level - 1]) +
                            firstMin(adj, i))/2);

            if (curr_bound + curr_weight < final_res)
            {
                curr_path[level] = i;
                 this.visited[i] = true;

                // call TSPRec for the next level
                 this.TSPRec(adj, curr_bound, curr_weight, level + 1,
                    curr_path);
            }

            curr_weight -= adj[curr_path[level-1]][i];
            curr_bound = temp;

            Arrays.fill( this.visited,false);
            for (int j = 0; j <= level - 1; j++)
                 this.visited[curr_path[j]] = true;
        }
    }
}


	public TspModel(String count,String indices) {
		this.n=Integer.parseInt(count);
		int curr_path[] = new int[ this.n + 1];
		int[][] adj=new int[this.n][this.n];
		this.final_path= new int[ this.n + 1];
		this.visited= new boolean[ this.n];
		this.final_res = Integer.MAX_VALUE;
		indices=indices.substring(1, indices.length()-1);
		//adj= new int[this.n][this.n];
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
				
				adj[i][j]=t;
				j++;
			}
			
			
		}

	    int curr_bound = 0;
	    Arrays.fill(curr_path, -1);
	    Arrays.fill( this.visited, false);

	    for (int i = 0; i <  this.n; i++)
	        curr_bound += (firstMin(adj, i) +
	                    secondMin(adj, i));

	    
	    curr_bound = (curr_bound==1)? curr_bound/2 + 1 :
	                                curr_bound/2;


	     this.visited[0] = true;
	    curr_path[0] = 0;

	    this.TSPRec(adj, curr_bound, 0, 1, curr_path);
	    System.out.printf("Minimum cost : %d\n", this.final_res);
        System.out.printf("Path Taken : ");
        for (int i = 0; i <=  this.n; i++) 
        {
            System.out.printf("%d ", this.final_path[i]);
        }
	}
}
