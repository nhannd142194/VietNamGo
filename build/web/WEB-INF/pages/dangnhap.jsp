<%-- 
    Document   : dangnhap
    Created on : May 31, 2017, 9:41:51 PM
    Author     : Hang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>

        <!-- signin -->
        <div class="modal-dialog" role="document" style="margin-top: 10%">
            <div class="modal-content modal-info">
                <div class="modal-body modal-spa">
                    <div class="login-grids">
                        <div class="login">
                            <div class="login-left">
                               
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
                       
                    </div>
                </div>
            </div>
        </div>
        <!-- //signin -->

    </body>
</html>
