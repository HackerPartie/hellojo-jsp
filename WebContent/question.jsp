<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="include/style.css" type="text/css" />
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

<title>12 steps to better code: ${myQuestion.shortText}</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h2>
				<strong>${myQuestion.shortText}</strong>
			</h2>
		</div>
		<p>${myQuestion.longText}</p>

		<div class="well">
			${myQuestion.shortText}
			<form action="Calc" method="post">
				<input type="radio" name="question${myQuestion.questionNumber}"
					value="1" /> <strong>Yes</strong><input type="radio"
					name="question${myQuestion.questionNumber}" value="0" /><strong>No</strong><br></br>
				<input type="submit" value="submit" />
			</form>
		</div>
	</div>
</body>
</html>