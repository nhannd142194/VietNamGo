
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>travels</title>

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
        <jsp:include page="content.jsp"></jsp:include>

            <!--- travel ---->
            <div class="travel">
                <div class="container">
                    <h3>Thông tin lịch trình</h3>
                    <div class="tra-top">

                        <ul class="rout">
                            <li class="rou">Lịch trình</li>
                            <li class="las"><span class="sen">Ngày bắt đầu</span></li>
                            <li class="las"><span class="sen">Ngày kết thúc</span></li>
                            <li class="dat">Giá vé</li>
                            <li class="las"></li>
                            <div class="clearfix"></div>
                        </ul>

                    <c:forEach var="p" items="${listTravels}">
                        <!--- rou-secnd ---->
                        <ul class="rou-secnd animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <li class="rou">
                                <p></p>
                                <h6><a href="#">${p.tenLichTrinh}</a></h6>
                            </li>
                            <li class="las">
                                <p>${p.ngayKhoiHanh}</p>
                            </li>
                            <li class="las">
                                <p>${p.ngayKetThuc}</p>
                            </li>
                            <li class="dat">
                                <p>Người lớn: </p>
                                <p style="color: red"><fmt:formatNumber type="number" pattern="#,##0" value="${p.giaVe}" /> VNĐ</p>
                                <p>Giảm giá: ${p.giamGia} %</p>
                            </li>
                            <li class="las">
                                <a href="${pageContext.request.contextPath}/home/checkout?id=${p.idLichTrinh}" class="det">Xem thêm</a>
                            </li>
                            <div class="clearfix"></div>
                        </ul>
                        <!--- /rou-secnd ---->
                    </c:forEach>

                </div>
            </div>
        </div>
        <!--- /travel ---->
        
        <jsp:include page="rupes.jsp"></jsp:include>

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
