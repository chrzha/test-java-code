<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Enumeration" %>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta content="text/html; charset=UTF-8" http-equiv="content-type">
<title>Get Remote IP</title>

<style type="text/css">


</style>

<%
     String remoteHost = request.getRemoteHost();
     String remoteAddr = request.getRemoteAddr();
     String forwardedIP = request.getHeader("X-Forwarded-For");
%>
</head>
<body>
    <h2> request.getRemoteHost() :<%= remoteHost %></h2>
    <h2> request.getRemoteAddr() :<%= remoteAddr %></h2>
    <h2> request.getHeader("X-Forwarded-For") : <%= forwardedIP %></h2>
    <h3>request headers:<h3>
     <% Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
                String key = (String) headers.nextElement();
                String value = request.getHeader(key);
         out.println("<h3>"+key+":"+value+"</h3>");

        }
     %>
</body>
</html>