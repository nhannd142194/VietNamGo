
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Thông tin lịch trình</title>
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

        <jsp:include page="header.jsp"></jsp:include>

            <!--- banner-1 ---->
            <div class="banner-1">
                <div class="container">
                    <h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> Chuyên Đề J2EE</h1>
                </div>
            </div>
            <!--- /banner-1 ---->
            <!--- agent ---->
            <div class="agent">
                <div class="container">
                    <div class="col-md-6 agent-left wow fadeInDown animated" data-wow-delay=".5s">
                    <c:if test="${not empty sessionScope.taiKhoan.email}">
                        <div class="ag-bt">
                            <a class="regist">THÔNG TIN ĐĂNG KÝ</a>
                        </div>
                        <p>Vui lòng cung cấp thông tin theo mẫu bên dưới</p>
                        <form action="${pageContext.request.contextPath}/lichtrinh/register1" method="post">
                            <input type="text" value="${sessionScope.taiKhoan.hoTen}" disabled>
                            <input type="text" value="${sessionScope.taiKhoan.email}" disabled>
                            <input type="text" value="${sessionScope.taiKhoan.dienThoai}" disabled>
                            <select name="soVe" id="" class="grayTextNormal">
                                <option value="1">1 vé</option>
                                <option value="2">2 vé</option>
                                <option value="3">3 vé</option>
                                <option value="4">4 vé</option>
                                <option value="5">5 vé</option>
                            </select>
                            <br />
                            <div class="sub" style="clear: both">
                                <br />
                                <input type="hidden" value="${idLichTrinh}" name="idLichTrinh">
                                <input type="submit" value="Gởi yêu cầu">
                            </div>
                        </form>
                    </c:if>
                    <c:if test="${empty sessionScope.taiKhoan.email}">
                        <div class="ag-bt">
                            <a class="regist">THÔNG TIN ĐĂNG KÝ</a>
                        </div>
                        <p>Vui lòng cung cấp thông tin theo mẫu bên dưới</p>
                        <form action="${pageContext.request.contextPath}/lichtrinh/register2" method="post">
                            <input name="hoTen" type="text" placeholder="Họ tên khách hàng">
                            <input name="email" type="text" placeholder="Địa chỉ Email">
                            <input name="dienThoai" type="text" placeholder="Số điện thoại">
                            <select name="soVe" id="" class="grayTextNormal">
                                <option value="1">1 vé</option>
                                <option value="2">2 vé</option>
                                <option value="3">3 vé</option>
                                <option value="4">4 vé</option>
                                <option value="5">5 vé</option>
                            </select>
                            <br />
                            <div class="sub" style="clear: both">
                                <br />
                                <input type="hidden" value="${idLichTrinh}" name="idLichTrinh">
                                <input type="submit" value="Gởi yêu cầu">
                            </div>
                        </form>
                    </c:if>
                </div>
                <div class="col-md-6 agent-right wow fadeInUp animated" data-wow-delay=".5s">
                    <!--<iframe src="https://player.vimeo.com/video/126154239" width="500" height="375" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe> -->
                    <h3>Liên hệ</h3>
                    <p>Mọi thắc mắc vui lòng liên hệ theo thông tin như sau:</p>
                    <p>Email: j2eeteam2016@gmail.com</p>
                    <p>Hotline: 1900 1234</p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!--- /agent ---->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
