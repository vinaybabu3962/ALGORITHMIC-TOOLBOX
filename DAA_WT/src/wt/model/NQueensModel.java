package wt.model;

public class NQueensModel {
	public int n;
	public int board[][];
	public boolean out;
	void printSolution(int board[][])
    {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++)
                System.out.print(" " + this.board[i][j]
                                 + " ");
            System.out.println();
        }
    }
	 boolean isSafe(int board[][], int row, int col)
	    {
	        int i, j;
	        for (i = 0; i < col; i++)
	            if (board[row][i] == 1)
	                return false;
	        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
	            if (this.board[i][j] == 1)
	                return false;
	        for (i = row, j = col; j >= 0 && i < n; i++, j--)
	            if (this.board[i][j] == 1)
	                return false;
	  
	        return true;
	    }
	 boolean solvenQUtil(int board[][], int col)
	    {
	        if (col >= this.n)
	            return true;
	        for (int i = 0; i < this.n; i++) {
	            if (isSafe(this.board, i, col)) {
	                this.board[i][col] = 1;
	                if (solvenQUtil(this.board, col + 1) == true)
	                    return true;
	  
	                this.board[i][col] = 0; 
	            }
	        }
	        return false;
	    }
	 
	public NQueensModel(String count) {
		this.n=Integer.parseInt(count);
		this.board=new int[this.n][this.n];
        if (solvenQUtil(board, 0) == false) {
            this.out=false;
            
        }
        else {
	        this.out=true;
	        printSolution(board);
        }
	}

}
