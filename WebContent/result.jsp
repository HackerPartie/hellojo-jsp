<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="include/style.css" type="text/css" />
<title>12 steps to better code: the test</title>
</head>

<body>
    <div class="header">
       And now you've got ... 
    </div>
    <div class="container">
        <p>
            Now you've got a score of 
            <%
            out.print(request.getAttribute("sumScore"));
            %>
            which is not bad, but remember many companies have 11 out of 12 all the time.
            
        </p>
        
            It is just that they forget to do the usuability testing.
    </div>     
</body>
</html>