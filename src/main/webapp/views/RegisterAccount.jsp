<%--
  Created by IntelliJ IDEA.
  User: arzen
  Date: 28/11/2022
  Time: 9:52 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="./css/bootstrap.min.css">
    <script src="./js/bootstrap.min.js"></script>
</head>
<body>

<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                <div class="card rounded">
                    <div class="card-body p-5">
                        <h3 class="text-center mb-5">MyWorkSchedule</h3>

                        <form  method="post" action="register"  >
                            <div class="form-floating mb-3 ">
                                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" required>
                                <label for="firstName">First Name</label>


                            </div>
                            <div class="form-floating mb-3 ">
                                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" required>
                                <label for="lastName">Last Name</label>
                            </div>
                            <div class="form-floating mb-3 ">
                                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com" required>
                                <label for="email">Email address</label>
                            </div>
                            <div class="form-floating mb-3 ">
                                <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                                <label for="password">Password</label>
                            </div>
                            <div class="mb-4 ">
                                <select class="form-select " name="role" id="role" aria-label="type" required>
                                    <option value="employee" selected>Employee</option>
                                    <option value="employer">Employer</option>
                                </select>
                            </div>
                            <div class="d-grid">
                                <button type="submit"
                                        class="btn btn-primary btn-block"  >
                                    Register
                                </button>
                            </div>
                            <p class="text-center text-muted mt-5 mb-0">Already have an account?
                                <a href="#" class="text-body"><u>Login</u></a>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
