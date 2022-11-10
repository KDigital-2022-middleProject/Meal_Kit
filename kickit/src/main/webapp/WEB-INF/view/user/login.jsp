<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<style>

</style>
<head>
 <link href="${path}/resources/css/login.css" rel="stylesheet">

<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
<c:url value="/login" var="loginUrl" />
<div id="container" class="container">
    <!-- FORM SECTION -->
    <div class="row">
      <!-- SIGN UP -->
     
      <div class="col align-items-center flex-col sign-up">
        <div class="form-wrapper align-items-center">

          <div class="form sign-up">
            <form action="join" method="post">
            <div class="input-group">
              <i class='bx bxs-user'></i>
              <input type="text" placeholder="Username" name = "name" id = "name" >
            </div>
            <div class="input-group">
              <i class='bx bx-mail-send'></i>
              <input type="email" placeholder="Email" name = "email" name = "email">
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <input type="password" placeholder="Password" name = "password" id = "">
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <input type="password" placeholder="Confirm password">
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <input type="text" placeholder="Phone Number" name = "tel" id = "tel">
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <input type="text" placeholder="Address" name = "address" id = "address" >
            </div>
      		  <%-- <sec:csrfInput /> 또는  --%>
      		  <%-- 시큐리티 csrf 땜시 이렇게 해줘야함 --%>
   			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <button type = "submit">
              Sign up
            </button>
          </form >
            <p>
              <span>
                Already have an account?
              </span>
              <b onclick="toggle()" class="pointer">
                Sign in here
              </b>
            </p>
          </div>
        </div>
  
      </div>
      <!-- END SIGN UP -->
      <!-- SIGN IN -->
      <div class="col align-items-center flex-col sign-in">
        <div class="form-wrapper align-items-center">
          <div class="form sign-in">
                 <form:form name="loginFrm" action="${loginUrl }" method="post">
            <div class="input-group">
              <i class='bx bxs-user'></i>
              <input type="text" placeholder="Username" name = "email" id = "email">
            </div>
            <div class="input-group">
              <i class='bx bxs-lock-alt'></i>
              <input type="password" placeholder="Password" name = "password" id = "password">
            </div>
            <button type = "submit">
              Sign in
            </button>
                        </form:form>
            <p>
              <span>
                Don't have an account?
              </span>
              <b onclick="toggle()" class="pointer">
                Sign up here
              </b>
            </p>
          </div>
        </div>
        <div class="form-wrapper">
    
        </div>
      </div>
      <!-- END SIGN IN -->
    </div>
    <!-- END FORM SECTION -->
    <!-- CONTENT SECTION -->
    <div class="row content-row">
      <!-- SIGN IN CONTENT -->
      <div class="col align-items-center flex-col">
        <div class="text sign-in">
          <h2>
            Welcome
          </h2>
  
        </div>
        <div class="img sign-in">
    
        </div>
      </div>
      <!-- END SIGN IN CONTENT -->
      <!-- SIGN UP CONTENT -->
      <div class="col align-items-center flex-col">
        <div class="img sign-up">
        
        </div>
        <div class="text sign-up">
          <h2>
            Join with us
          </h2>
  
        </div>
      </div>
      <!-- END SIGN UP CONTENT -->
    </div>
    <!-- END CONTENT SECTION -->
  </div>
     <script src="${path}/resources/js/login.js"></script>
</body>
</html>


