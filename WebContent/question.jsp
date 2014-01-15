<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="include/style.css" type="text/css" />
<title>12 steps to better code</title>
</head>
<body>
    <div class="header">
        ${myQuestion.shortText}
    </div>
    <div class="container">
        <p>
        ${myQuestion.longText}
        </p>      
    </div>
    <div class="box">
    ${myQuestion.shortText}
    <form action="Calc" method="post">
    <input type="radio" name="question${myQuestion.questionNumber}" value="1" /> Yes
    <input type="radio" name="question${myQuestion.questionNumber}" value="0" /> No
    <br></br>
    <input type="submit" value="submit"/>
    </form>
    </div>
</body>
</html>