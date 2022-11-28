<%--
  Created by IntelliJ IDEA.
  User: miyok
  Date: 23/11/2022
  Time: 5:24 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="./js/bootstrap.min.js"></script>
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