<%--
  Created by IntelliJ IDEA.
  User: arzen
  Date: 21/11/2022
  Time: 9:32 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link rel="stylesheet" href="./webjars/bootstrap-icons/1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="./webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class="container mt-4 mb-4">
    <%--    Create button section    --%>
    <div class="d-flex justify-content-end mb-4">
        <button type="button" class=" btn btn-outline-dark  " data-bs-toggle="modal" data-bs-target="#exampleModal">
            Create Branch
        </button>
    </div>
    <%--    Branches Section    --%>
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
    <%--    Footer section    --%>
    <footer class="py-3 fixed-bottom">
        <p class="text-center text-muted">© Copyright 2022, MyWorkScedule</p>
    </footer>
</body>


<%--    Create branch modal --%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Create Branch</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form>
                <div class="modal-body">
                    <div class="form-group ">
                        <label for="CreateBranch">Branch Name</label>
                        <input id="CreateBranch" class="form-control my-2">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>

<%--    Edit branch modal    --%>
<div class="modal fade" id="editBranchModal" tabindex="-1" aria-labelledby="editBranchModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editBranchModalLabel">Edit Branch</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form>
                <div class="modal-body">
                    <div class="form-group ">
                        <label for="editBranch"> Branch Name</label>
                        <input id="editBranch" class="form-control my-2">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>
    </div>
</div>
</html>
