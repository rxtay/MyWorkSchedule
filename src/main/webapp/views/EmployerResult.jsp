<%--
  Created by IntelliJ IDEA.
  User: Brian
  Date: 24/11/2022
  Time: 5:13 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Employer Result</title>
</head>
<body>
    <div class="container mt-4 mb-4 ">
        <%--    Create button section    --%>
        <div class="d-flex mb-4 justify-content-between">

                <button type="button" class=" btn btn-outline-dark  ">
                    Back
                </button>
                <h2> All Members</h2>

            <button type="button" class=" btn btn-outline-dark "  data-bs-toggle="modal" data-bs-target="#exampleModal">
                Add Member
            </button>
        </div>

        <%--    Branches Section    --%>
        <div class="d-grid">
            <c:forEach var="x" items="${users}">
                <div class="row m-0 mb-2">
                    <div class="card">
                        <div class="card-body d-flex justify-content-between align-items-center">
                            <h5 class="card-title m-0">${x.firstName} ${x.lastName}</h5>
                            <div>
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