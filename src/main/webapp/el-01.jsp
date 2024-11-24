<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL / JSTL</title>
</head>
<body>
	호스트 : ${header.host }<br>
	매개변수 : ${param.name }<br>
	<br>
	<hr>
	${empty param.x? "비어있음" : param.x }
	<br><hr>
	<c:set var="id" value="gildong"/>
	<c:set var="income" value ="2000000"/>
	<c:out value = "${id}"/>은 <c:out value="${income}"/> 수입이 있음
	
	<hr>
	<c:if test="${income<8000}">
		안녕!!
	</c:if>
	<c:if test="${income>8000}">
		많이 받으시네요!
	</c:if>	
	<hr>
	<c:set var="score" value="${param.score }"/>
	
	<c:if test="${empty score}">
		"비어있어요!!
	</c:if>
	<c:if test="${!empty score}">
		<c:out value="${score }"/>
	</c:if>	
	<br>
	<c:forTokens var="i" items="C,Java,javascript,python,c++" delims=",">
		${i}
	</c:forTokens>
	
	<hr>
	<fmt:formatNumber value="1234567890">
		
	</fmt:formatNumber> 
	
</body>
</html>
