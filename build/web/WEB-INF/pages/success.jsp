
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hoàn tất đăng ký</title>
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

           <!--- banner-1 ---->
            <div class="banner-1">
                <div class="container">
                    <h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> Chuyên Đề J2EE </h1>
                </div>
            </div>
            <!--- /banner-1 ---->
            <!--- track ---->
            <div class="tracking">
                <div class="container">
                    <div class="tracking-top">
                        <div class="col-md-6 tracking-left wow fadeInLeft animated" data-wow-delay=".5s">
                            <h3>Đăng ký thành công!</h3>
                            <p>Quá trình đăng ký thành công, yêu cầu của bạn sẽ được phía công ty liên hệ trong thời gian sớm nhất</p>
                        </div>
                        <div class="col-md-6 tracking-right wow fadeInRight animated" data-wow-delay=".5s">
                            <img src="<c:url value="/resources/images/map1.png"/>" class="img-responsive" alt="">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    
                </div>
            </div>
            <!--- /track ---->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
