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
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${context}/webjars/bootstrap-icons/1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${context}/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="${context}/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
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

<%--    Add employee modal    --%>
<div class="modal fade show" id="exampleModal" tabindex="-1" aria-labelledby="exampleModal" aria-hidden="true" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addBranchEmployeeLabel">Add Employee</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
                <div class="modal-body ">
                    <c:forEach var="x" items="${usersBranchless}">
                        <form method="post" action="members">
                            <div class="row m-0 mb-2">
                                <div class="card">
                                    <div class="card-body d-flex justify-content-between align-items-center">
                                        <h5 class="card-title m-0">${x.firstName} ${x.lastName}</h5>
                                        <button type="submit"> Add
                                        <input  type="hidden" value="${x.employeeId}" name="employeeId" id="employeeId">
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
        </div>
    </div>
</div>
</html>
