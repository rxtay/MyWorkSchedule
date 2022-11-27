<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <script src="../js/bootstrap.min.js"></script>
    <title>Users</title>
</head>
<body>
<div class="container mt-4 mb-4">
    <%--    Actions section    --%>
    <div class="d-flex mb-4 justify-content-between">
        <h1 class="fs-4">${branch.getName()}</h1>
        <div>
            <button type="button" class="btn-sm btn btn-dark" data-bs-toggle="modal" data-bs-target="#newShiftModal">New Shift</button>
            <button type="button" class="btn-sm btn btn-outline-dark">Announcements</button>
            <button type="button" class="btn-sm btn btn-outline-dark">View Members</button>
        </div>
    </div>
    <div class="d-grid">
        <c:forEach var="shift" items="${shifts}">
            <div class="row m-0">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex justify-content-between align-items-center">
                            <div>
                                <h5 class="card-title">${shift.getFormattedDate()}</h5>
                                <p class="card-text">${shift.getFormattedDays()}</p>
                            </div>
                            <div>
                                <a href="#" class="bi bi-pencil"></a>
                                <a href="#" class="bi bi-trash"></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>

<%--    New shift modal    --%>
<div class="modal fade" id="newShiftModal" tabindex="-1" aria-labelledby="newShiftModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newShiftModalLabel">New Shift</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form>
                <div class="modal-body">
                    <div class="form-group">
                        <div class="row m-0 mb-2 p-0">
                            <div class="col">
                                <input type="text" class="form-control" placeholder="Description" aria-label="description" required>
                            </div>
                            <div class="col">
                                <input type="number" class="form-control" placeholder="Rate" aria-label="Rate" required>
                            </div>
                        </div>
                        <div class="row m-0 p-0">
                            <div class="col">
                                <label class="d-block mb-2" for="startTime">Start Time</label>
                                <input type="time" id="startTime" name="startTime" required>
                            </div>
                            <div class="col">
                                <label class="d-block mb-2" for="endTime">End Time</label>
                                <input type="time" id="endTime" name="endTime" required>
                            </div>
                        </div>
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
