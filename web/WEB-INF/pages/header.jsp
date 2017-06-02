
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>header</title>
        <style>
            #fixNav{
                width: 100%;
                height: 35px;
                background-color: #0082bb;
                display: block;
                box-shadow: 0px 2px 2px rgba(0,0,0,0.5); /*Đổ bóng cho menu*/
                position: fixed; /*Cho menu cố định 1 vị trí với top và left*/
                top: 0; /*Nằm trên cùng*/
                left: 0; /*Nằm sát bên trái*/
                z-index: 100000; /*Hiển thị lớp trên cùng*/
            }    
        </style>
    </head>
    <body>

        <!-- top-header -->
        <div class="top-header" id="fixNav">
            <div class="container">
               
                <ul class="tp-hd-rgt wow fadeInRight animated" data-wow-delay=".5s"> 
                    <c:if test="${not empty sessionScope.taiKhoan.email}">
                        <li class="tol"><a href=""><c:out value="${sessionScope.taiKhoan.email}"/></a></li>
                        <c:if test="${sessionScope.taiKhoan.quyen == '1'}">
                        <li class="tol"><a href="${pageContext.request.contextPath}/admin/index">Trang quản trị</a></li>
                        </c:if>
                        <li class="tol"><a href="${pageContext.request.contextPath}/user/logout">Đăng xuất</a></li>
                    </c:if>
                    <c:if test="${empty sessionScope.taiKhoan.email}">
                        <li class="tol">Toll Number : 0168 335 0920</li>				
                        <li class="sig"><a href="${pageContext.request.contextPath}/home/register">Đăng ký</a></li> 
                        <li class="sigi"><a href="${pageContext.request.contextPath}/home/login">/ Đăng nhập</a></li>
                   </c:if>

                </ul>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--- /top-header ---->
        <!--- header ---->
        <div class="header" style="margin-top: 30px">
            <div class="container">
                <div class="logo wow fadeInDown animated" data-wow-delay=".5s">
                    <a href="index.html">12520303 <span>J2EE</span></a>	
                </div>

                <div class="lock fadeInDown animated" data-wow-delay=".5s"> 
                    <li><i class="fa fa-lock"></i></li>
                    <li><div class="securetxt">SAFE &amp; SECURE<br> ONLINE PAYMENTS</div></li>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--- /header ---->
        <!--- footer-btm ---->
        <div class="footer-btm wow fadeInLeft animated" data-wow-delay=".5s">
            <div class="container">
                <div class="navigation">
                    <nav class="navbar navbar-default">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                            <nav class="cl-effect-1">
                                <ul class="nav navbar-nav">
                                    <li><a href="${pageContext.request.contextPath}/home/index">Trang chủ</a></li>
                                    <li><a href="${pageContext.request.contextPath}/home/about">Giới thiệu</a></li>
                                    <li><a href="${pageContext.request.contextPath}/home/travels">Lữ hành</a></li>
                                    <li><a href="${pageContext.request.contextPath}/home/news?kind=2&p=0">Điểm du lịch</a></li>
                                    <li><a href="${pageContext.request.contextPath}/home/news?kind=1&p=0">Khuyến mãi</a></li>
                                    <li><a href="${pageContext.request.contextPath}/home/news?kind=3&p=0">Ẩm thực</a></li>
                                    <li><a href="${pageContext.request.contextPath}/home/contact">Liên hệ</a></li>
                                    <div class="clearfix"></div>
                                </ul>
                            </nav>
                        </div><!-- /.navbar-collapse -->	
                    </nav>
                </div>

                <div class="clearfix"></div>
            </div>
        </div>
        <!--- /footer-btm ---->

    </body>
</html>
