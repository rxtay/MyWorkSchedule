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
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<div class=" container d-grid mt-4 d-md-flex justify-content-md-end">
  <button type="button" class=" btn btn-outline-dark  " data-bs-toggle="modal" data-bs-target="#exampleModal">
    Create Branch
  </button>
</div>


<div class="container mt-4 ">
  <c:forEach items="${branches}" var="x">
  <div class="d-grid">
    <div class="row">
      <div class=" card mb-2  " >


          <div class="col ">

            <div class="card-body row">

              <div class=" col-10 ">


                ${x.name}

              </div>

              <div class="col-auto">
                <i class="bi-pen" data-bs-toggle="modal" data-bs-target="#editBranchModal"></i>
              </div>
              <div class="col-auto">
                <i class="bi-trash"></i>
              </div>
            </div>
          </div>



      </div>
    </div>

  </div>
  </c:forEach>
</div>


</body>

<footer class="py-3 fixed-bottom">

  <p class="text-center text-muted">© Copyright 2022, MyWorkScedule</p>
</footer>

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
           <label for="CreateBranch"> Branch Name</label>
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
