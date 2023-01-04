<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="model.Amortization" %>
<%@ page import="model.Loan" %>
    
<%
	String principal = (String) request.getAttribute("principal");
	int term = (Integer) request.getAttribute("term");
	double rate = (Double) request.getAttribute("rate");
	String table = (String) request.getAttribute("table");	
%>  
    
    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<link rel='stylesheet' type="text/css" href='styles.css'>
	<title>Loan Amortization</title>
	</head>
	
		<body>
		<div class="header">
			<h1>Completed Loan Amortization Calculation</h1>
		</div>
			<h4>Your Loan:</h4>
			
			<p>Loan Principal: <%= principal %> </p>
			<p>Loan Term (Months): <%= term*12 %> </p>
			<p>Loan Rate (Monthly): <%= rate/12 %>%</p>
			<p>To enter a new loan:<a href="index.jsp">Reset</a></p>
			
			<h4 style="text-align: center;">Loan Amortization Table </h4>
			<div class="table">
			<p><%=table%> </p>
			</div>
			<footer>Loan Amortization Designed and Created by Daniel Saul | MIST 4630 | Copyright 2021</footer>
		</body>
</html>