<%--
  Created by IntelliJ IDEA.
  User: miyok
  Date: 30/11/2022
  Time: 10:04 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <title>My Shifts</title>
</head>
<body>
<div class="container mb-4 mt-4">
    <div class="d-grid">
        <c:forEach var="x" items="${shifts}">
            <div class="row m-0 mb-2">
                <div class="card">
                    <div class="card-body d-flex justify-content-between">
                        <h5 class="card-title">${x.content}</h5>
                        <h4 class="card-title">${x.startTime}</h4>
                        <h4 class="card-title">${x.endTime}</h4>
                        <h4 class="card-title">${x.rate}</h4>
                        <div>
                            <i class="bi-pen" data-bs-toggle="modal" data-bs-target="#editShiftModal"></i>
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
