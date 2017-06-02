
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

        <script type="text/javascript"  src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/js/jquery-1.12.0.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/js/jquery-ui.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/js/wow.min.js" />"></script>
    </head>
    <body>

        <!-- signin -->
        <div class="modal-dialog" role="document" style="margin-top: 10%">
            <div class="modal-content modal-info">
                <div class="modal-body modal-spa">
                    <div class="login-grids">
                        <div class="login">
                            <div class="login-left">
                                <ul>
                                    <li><a class="fb" href="#"><i></i>Sign in with Facebook</a></li>
                                    <li><a class="goog" href="#"><i></i>Sign in with Google</a></li>
                                    <li><a class="linkin" href="#"><i></i>Sign in with Linkedin</a></li>
                                </ul>
                            </div>
                            <div class="login-right">
                                <form action="${pageContext.request.contextPath}/user/login" 
                                      modelAttribute="taiKhoan" method="post">
                                    <h3>ĐĂNG NHẬP HỆ THỐNG</h3>
                                    <div style="color:red; margin-top: 10px">${msg}</div>
                                    <input type="text" placeholder="Địa chỉ Email" name="email">	
                                    <input type="password" placeholder="Mật khẩu" name="matKhau">	
                                    <h4><a href="${pageContext.request.contextPath}/home/forgetpass">Quên mật khẩu?</a></h4>
                                    <input type="submit" value="ĐĂNG NHẬP">
                                </form>
                            </div>
                            <div class="clearfix"></div>								
                        </div>
                        <p>Bấm <a href="${pageContext.request.contextPath}/home/index">vào đây</a> nếu như bạn muốn quay lại trang chủ</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- //signin -->

    </body>
</html>
