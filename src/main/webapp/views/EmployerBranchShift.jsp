<%--
  Created by IntelliJ IDEA.
  User: arzen
  Date: 30/11/2022
  Time: 10:52 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${context}/webjars/bootstrap-icons/1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${context}/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="${context}/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <script src="${context}/webjars/jquery/3.6.1/jquery.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container mt-4">
    <div class="d-flex justify-content-end mb-4">
        <button type="button" class=" btn btn-outline-dark  " data-bs-toggle="modal" data-bs-target="#exampleModal">
            Assign Member
        </button>
    </div>
    <div class="d-grid">
        <c:forEach var="x" items="${users}">
            <div class="row m-0 mb-2">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <h5 class="card-title">${x.firstName} ${x.lastName} </h5>
                        <form id="form-${x.employeeId}" action="${context}/employer/branch/shift/delete" method="post">
                            <input type="hidden" name="employeeId" value="${x.employeeId}" />
                            <div>
                                <i onclick="handleClick('<c:out value="${x.employeeId}" />')" class="bi-trash"></i>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<footer class="py-3 fixed-bottom">
    <p class="text-center text-muted">© Copyright 2022, MyWorkSchedule</p>
</footer>
</body>
<script>
    const handleClick = (employeeId) => {
        $("#form-"+employeeId).submit()
    }
    window.onload = () => {
        var message = '<%=request.getAttribute("message")%>'
        if (message !== "null") {
            alert(message)
        }
    }
</script>
</html>
