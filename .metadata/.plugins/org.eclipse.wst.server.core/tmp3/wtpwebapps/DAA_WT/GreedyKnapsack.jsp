<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%! int i; %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
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
    width:50px;
    }
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
<h2 style="background-image: linear-gradient(to right, #6db9ef, #7ce08a);"></h2>
<span style="background-image:linear-gradient(to right, #6db9ef, #7ce08a);color:black;" class="badge badge-pill badge-success"><h3>Fractional Knapsack</h3></span>

<br><br>
Note:1 is considered as whole item selected  similarly 0 is not <br><br>
<table border="1" class="table-bordered table-hover">
	<tr> <th style="width:30px;">Item</th>
		 <th style="width:30px;">Profit</th>
		 <th style="width:30px;"> Weight</th>
		 <th style="width:30px;">Selection</th>
	</tr>
	<%  Double d=(double)request.getAttribute("final");
		 double [] sel=(double [] )request.getAttribute("selection");
	    int [] profits=(int [])request.getAttribute("profits") ; 
	  int [] weights =(int [])request.getAttribute("weights") ; 
	  for(i=0;i<sel.length;i++) {%>  
		<tr>
			<td><%=(i+1)%></td>
			<td><%=profits[i]%></td>
			<td><%=weights[i]%></td>
			<td><%=String.format("%.2f", sel[i]) %></td>
		</tr>
	<%}%>
</table>
total profit is<br>
<%=d  %>
<br><br><hr>
<span style="background-image:linear-gradient(to right, #6db9ef, #7ce08a);color:black;" class="badge badge-pill badge-success"><h3>0/1 Knapsack</h3></span>
<br><br>
Note:1 is considered as whole item selected  similarly 0 is not <br><br>
<table border="1" class="table-bordered table-hover">
	<tr> <th>Item</th>
		 <th>Profit</th>
		 <th>Weight</th>
		 <th>Selection</th>
	</tr>
	<%  Double d1=(double)request.getAttribute("final1");
		 double [] sel1=(double [] )request.getAttribute("selection1");
	    int [] profits1=(int [])request.getAttribute("profits") ; 
	  int [] weights1 =(int [])request.getAttribute("weights") ; 
	  for(i=0;i<sel1.length;i++) {%>  
		<tr>
			<td><%=(i+1)%></td>
			<td><%=profits1[i]%></td>
			<td><%=weights1[i]%></td>
			<td><%=String.format("%.2f", sel1[i]) %></td>
		</tr>
	<%}%>
</table>
total profit is<br>
<%=d1  %>
</center>
</body>
</html>