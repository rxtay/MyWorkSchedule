<%--
  Created by IntelliJ IDEA.
  User: miyok
  Date: 23/11/2022
  Time: 5:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${context}/webjars/bootstrap-icons/1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${context}/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="${context}/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <title>Employee Branches</title>
</head>
<body>
<div class="container mb-4 mt-4">
    <div class="d-grid">
        <c:forEach var="x" items="${branches}">
            <div class="row m-0 mb-2">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <h5 class="card-title">${x.name}</h5>
                        <div>
                            <i class="bi-pen" data-bs-toggle="modal" data-bs-target="#editBranchModal"></i>
                            <i class="bi-trash"></i>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
