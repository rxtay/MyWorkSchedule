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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
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
                        <div>

                            <i class="bi-trash"></i>
                        </div>
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
</html>
