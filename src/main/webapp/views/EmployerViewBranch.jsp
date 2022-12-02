<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="./webjars/bootstrap-icons/1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="./webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <title>Users</title>
</head>
<body>
<div class="container mt-4 mb-4">
    <%--    Actions section    --%>
    <div class="d-flex mb-4 justify-content-between">
        <h1 class="fs-4">${branch.getName()}</h1>
        <div>
            <button type="button" class="btn-sm btn btn-dark" data-bs-toggle="modal" data-bs-target="#newShiftModal">New
                Shift
            </button>
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
                                <a onclick='handleEdit("${shift.getFormattedDate()}", "${shift.getShiftId()}", "${shift.getContent()}", "${shift.getRate()}", "${shift.getStartTime()}", "${shift.getEndTime()}")'
                                   class="bi bi-pencil"></a>
                                <a href="#" class="bi bi-trash"></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<%--    Footer section    --%>
<footer class="py-3 fixed-bottom">
    <p class="text-center text-muted">© Copyright 2022, MyWorkSchedule</p>
</footer>
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
                                <input type="text" class="form-control" placeholder="Description"
                                       aria-label="description" required>
                            </div>
                            <div class="col">
                                <input type="number" class="form-control" placeholder="Rate" aria-label="Rate" required>
                            </div>
                        </div>
                        <div class="row m-0 p-0">
                            <div class="col">
                                <label class="d-block mb-2" for="startTime">Start Time</label>
                                <input type="time" name="startTime" required>
                            </div>
                            <div class="col">
                                <label class="d-block mb-2" for="endTime">End Time</label>
                                <input type="time" name="endTime" required>
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


<%--    Edit shift modal    --%>
<div class="modal fade" id="editShiftModal" tabindex="-1" aria-labelledby="editShiftModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editShiftModalLabel"></h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="hidden" id="shiftId" aria-label="shiftId">
                        <div class="row m-0 mb-2 p-0">
                            <div class="col">
                                <input type="text" id="description" class="form-control" placeholder="Description"
                                       aria-label="description" required>
                            </div>
                            <div class="col">
                                <input type="number" id="rate" class="form-control" placeholder="Rate" aria-label="Rate"
                                       required>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
    const handleEdit = (label, shiftId, description, rate, startTime, endTime) => {
        $('#editShiftModalLabel')
            .html(label)
        $('#shiftId')
            .val(shiftId)
        $('#description')
            .val(description)
        $('#rate')
            .val(rate)
        $('#startTime')
            .val(startTime.toString().split(" ")[1].replace(".", "").slice(0, 5))
        $('#endTime')
            .val(endTime.toString().split(" ")[1].replace(".", "").slice(0, 5))
        $('#editShiftModal')
            .modal('show')
    }
</script>
</html>
