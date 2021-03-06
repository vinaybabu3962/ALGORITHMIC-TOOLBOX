<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%! int i; %>
<%! int j; %>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>N QUEENS</title>
<style>
	*{
		margin: 0px;
		padding:0px;
	}
	.nav-item{
	margin-right:15px;
	}
    .abcd{
    background-image: linear-gradient(to right, #6db9ef, #7ce08a);
    }
   td{
   text-align:center;}
</style>
</head>
<body>
<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-light bg-light abcd">
        <a href="index.html" class="navbar-brand">ALGORITHMIC TOOL BOX</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                
                
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">KNAPSACK</a>
                    <div class="dropdown-menu">
                    	<a href="GreedyKnapsack.html" class="dropdown-item">Greedy Knapsack</a>
  						<a href="KnapSackDP.html" class="dropdown-item">Knapsack using DP</a>
                
                    </div>
                </li>
                <li class="nav-item">
                  <a href="MatrixChainMultiplication.html" class="nav-link">Matrix chain multiplication</a>
                    
                </li>
                <li class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Shortest path</a>
                    <div class="dropdown-menu">
                     	<a href="Dijkstras.html" class="dropdown-item">Dijkstras shortest path</a>
  						<a href="BellmanFord.html" class="dropdown-item">Bellman Ford Algorithm</a>
                
                    </div>
                </li>
                 <li class="nav-item">
                 
                  <a href="FloydWarshall.html" class="nav-link">All pairs shortest path</a> 
                </li>
                <li class="nav-item">
                 
                  <a href="NQueens.html" class="nav-link">N Queens </a> 
                </li>
                <li class="nav-item">
                 
                  <a href="Tsp.html" class="nav-link">TSP</a> 
                </li>
            </ul>
            
        </div>
    </nav>
</div>
<center>
<span style="background-image:linear-gradient(to right, #6db9ef, #7ce08a);color:black;" class="badge badge-pill badge-success"><h3>N-QUEENS PROBLEM</h3></span>
<% boolean b=(boolean)request.getAttribute("out");
 int [][] board=(int [][] )request.getAttribute("matrix"); %>
 <% if(b==false) { %>
 	<h2 style="color:red;">Solution does not exist!!</h2>
 <% } else { %>
 <h4>One of the possible solution is:</h4>
 	<table border="1" class="table-bordered table-hover">
 		<% for(i=0;i<board.length;i++) { %>
 			<tr>
 			<% for(j=0;j<board[0].length;j++)  {%>
 				<% if(board[i][j]==1) { %>
 					<td style="color:black;width:30px;">&#9813;</td>
 				<%}else{ %>
 					<td style="width:30px;">-</td>
 				<%} %>
 			<%} %>
 			</tr>
 		<%} %>
 	</table>
 <%} %>
</center>
</body>
</html>