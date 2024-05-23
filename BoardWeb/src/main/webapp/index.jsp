<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>=> index.jsp</title>
</head>

<body>
  <div id="show">
    <table border="2">
      <c:forEach var="catego" items="${list }">
        <tr>
          <td>${catego.p_cat }</td>
          <td></td>
        </tr>
        <c:forEach var="item" items="${catego.c_cat }">
          <tr>
            <td></td>
            <td>${item }</td>
          </tr>
        </c:forEach>
      </c:forEach>
    </table>
  </div>

</body>

</html>