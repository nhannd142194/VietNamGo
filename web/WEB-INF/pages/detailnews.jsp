
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/resources/css/animate.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/font-awesome.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

        <script type="text/javascript"  src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/js/jquery-1.12.0.min.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/js/jquery-ui.js" />"></script>
        <script type="text/javascript"  src="<c:url value="/resources/js/wow.min.js" />"></script>
        <script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <!--- track ---->
            <div class="tracking">
                <div class="container">
                    <div class="tracking-top">
                        <div class="col-md-6 tracking-left wow fadeInLeft animated" data-wow-delay=".5s">
                            <h3>${tinTuc.tenTinTuc}</h3>
                        <p style="text-align: justify;">${tinTuc.moTaNgan}</p>
                    </div>
                    <div class="col-md-6 tracking-right wow fadeInRight animated" data-wow-delay=".5s">
                        <img src="${pageContext.request.contextPath}/admin/news/img?id=${tinTuc.idTinTuc}" class="img-responsive" alt="">
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        <!--- /track ---->

        <!--- blog ---->

        <div class="container">
            <div class="col-md-8 blog-left">

                <div class="comments-list hover14 column animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">

                    <p>${tinTuc.moTaChiTiet}</p>

                </div>

            </div>

            <div class="col-md-4 blog-right">
                <div class="popular animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                    <h3>XEM THÊM</h3>
                    <c:forEach var="i" items="${listNews}">

                        <div class="popular-grid">
                            <div class="popular-left">
                                <h4>>> </h4>
                            </div>
                            <div class="popular-right">
                                <h5><a href="${pageContext.request.contextPath}/home/detailnews?id=${i.idTinTuc}">${i.tenTinTuc}</a></h5>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </c:forEach>
                    <div class="clearfix"> </div>
                </div>

            </div>
            <div class="clearfix"> </div>
        </div>
        <br />

        <!--- /blog ---->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
