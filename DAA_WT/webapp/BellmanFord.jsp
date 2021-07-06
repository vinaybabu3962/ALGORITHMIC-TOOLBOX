<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%! int i; %>
<%! int j; %>
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
<span style="background-image:linear-gradient(to right, #6db9ef, #7ce08a);color:black;" class="badge badge-pill badge-success"><h3>BELLMAN FORD</h3></span>
<br><br>
<% String s=(String)request.getAttribute("out");
	int [] cost=(int [] )request.getAttribute("cost") ;%>

<b><u>INFORMATION ABOUT NEGATIVE CYCLE:</u></b><h4><%=s %></h4>
<br><br>
<b><u>COST DETAILS:</u></b>
<br><br>
<% for(i=0;i<cost.length;i++) { %>
	
	<h4><b>Vertex <%=i %> -> cost = </b><%=cost[i] %> </h4>
<%} %>
</center>
</body>
</html>