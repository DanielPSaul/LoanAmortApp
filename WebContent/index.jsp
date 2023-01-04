<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import="model.Amortization" %>
 <%@ page import="model.Loan" %>
    
    
 <%
 	double principal = 0.0;
 	int term = 0;
 	double rate = 0.0;
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
				<h1>Loan Amortization</h1>
			</div>
				<p>Hello! Welcome to your personal loan amortization calculator!</p>
				<p>Please enter your loan's principal amount, loan term in years, and the loan rate as a whole number!</p>
				<p>Thank you!</p>
				
				<form name="loanForm" action="doAmortization" method="post">
					<label>
						Loan Principal:
					</label>
					<input type="text" name="principal" />
					
					<label>
						Loan Term (Years):
					</label>
					<input type="text" name="term" />
					
					<label>
						Loan Rate (APR):
					</label>
					<input type="text" name="rate" /> 
					
					<br />
					
					<input type="submit" name="submit" value="Calculate">
					
					<input type="hidden" name="principal" value="<%= principal %>" />
					<input type="hidden" name="term" value="<%= term %>" /> 
					<input type="hidden" name="rate" value="<%= rate %>" />
				</form>
				
				<footer>Loan Amortization Designed and Created by Daniel Saul | MIST 4630 | Copyright 2021</footer>
			</body>
</html>