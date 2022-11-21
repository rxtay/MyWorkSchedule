<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Users</title>
</head>
<body>
    <div class="container mt-4 mb-4">
        <h1 class="fs-4 mb-4">${branch.getName()}</h1>
        <div class="d-grid">
            <c:forEach var="shift" items="${shifts}">
                <div class="row">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${shift.getFormattedDate()}</h5>
                            <p class="card-text">${shift.getFormattedDays()}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
