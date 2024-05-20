<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="my" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="//cdn.datatables.net/2.0.7/css/dataTables.dataTables.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="//cdn.datatables.net/2.0.7/js/dataTables.min.js"></script>

<h3>게시글목록</h3>
<!-- 글번호, 제목, 작성자, 작성일시, 조회수 -->
<table id="example" class="display" style="width:100%">
  <thead>
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일시</th>
      <th>조회수</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="board" items="${list }">
      <tr>
        <td>${board.boardNo }</td>
        <td><a href="boardInfo.do?bno=${board.boardNo }&page=${paging.page}">${board.title }</a></td>
        <td>${board.writer }</td>
        <td>
          <fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd HH:mm:ss" />
        </td>
        <td>${board.viewCnt }</td>
      </tr>
    </c:forEach>
  </tbody>
  <tfoot>
    <tr>
      <th>글번호</th>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일시</th>
      <th>조회수</th>
    </tr>
  </tfoot>
</table>
<script>
  new DataTable('#example');
</script>
