<%--
  Created by IntelliJ IDEA.
  User: rongx
  Date: 11/28/2022
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <c:set var="context" value="${pageContext.request.contextPath}" />
    <link rel="stylesheet" href="${context}/webjars/bootstrap-icons/1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${context}/webjars/bootstrap/5.2.0/css/bootstrap.min.css">
    <script src="${context}/webjars/bootstrap/5.2.0/js/bootstrap.min.js"></script>
    <script src="${context}/webjars/jquery/3.6.1/jquery.js"></script>
    <title>Title</title>
</head>
<body>
<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                <div class="card rounded">
                    <div class="card-body p-5">
                        <h3 class="text-center mb-5">MyWorkSchedule</h3>
                        <form method="post" action="login">
                            <div class="form-floating mb-3">
                                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
                                <label for="email">Email address</label>
                            </div>
                            <div class="form-floating mb-4">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                <label for="password">Password</label>
                            </div>
                            <div class="d-grid">
                                <input type="submit" class="btn btn-primary btn-block" value="Login" />
                            </div>
                            <p class="text-center text-muted mt-5 mb-0">Don't have an account?
                                <a href="#" class="text-body"><u>Register</u></a>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
<script>
    window.onload = () => {
        var message = '<%=request.getAttribute("alert")%>'
        if (message !== "null") {
            alert(message)
        }
    }
</script>
</html>
