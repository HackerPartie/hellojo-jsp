<?xml version="1.0" encoding="UTF-8" ?>
<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="include/style.css" type="text/css" />
<title>Insert title here</title>
</head>
<body>
    <div class="header">
        <%
        out.println(request.getAttribute("shortQuestion"));
        %>
    </div>
    <div class="container">
        <p>
            <%
            out.println(request.getAttribute("longQuestion"));
            %>
        </p>      
    </div>
    <div class="box">
    <%
    out.println(request.getAttribute("shortQuestion"));
    %>
    <form action="Calc" method="post">
    <input type="radio" name="question<%out.print(request.getAttribute("questionNumber"));%>" value="1" /> Yes
    <input type="radio" name="question<%out.print(request.getAttribute("questionNumber"));%>" value="0" /> No
    <br></br>
    <input type="submit" value="submit"/>
    </form>
    </div>
</body>
</html>