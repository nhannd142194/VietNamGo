
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liên hệ</title>
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
            <div class="banner-1 ">
                <div class="container">
                    <h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> Chuyên Đề J2EE</h1>
                </div>
            </div>
            <!--- /banner-1 ---->
            <!--- contact ---->
            <div class="contact">
                <div class="container">
                    <h3>Liên hệ</h3>
                    <div class="col-md-3 contact-left">
                        <div class="con-top animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <h4>DL Trong nước</h4>
                            <li>0938.301.399</li> 
                            <li># Grand Hyatt New York Road,</li>  
                            <li>Thời gian: 7am to 11pm</li>
                        </div>
                    </div>
                    <div class="col-md-3 contact-left">
                        <div class="con-top animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <h4>DL Nước ngoài</h4>
                            <li>0938.301.388</li>  
                            <li># Grand Hyatt New York Road,</li>   
                            <li>Thời gian: 7am to 11pm</li>
                        </div>
                    </div>
                    <div class="col-md-3 contact-left animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                        <div class="con-top animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <h4>CSKH</h4>
                            <li>0938.301.234</li>  
                            <li>192 Lý Thường Kiệt</li>   
                            <li>Thời gian: 7am to 11pm</li>					
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="col-md-3 contact-left animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                        <div class="con-top animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <h4>FAX</h4>
                            <li>+84938.301.234</li>  
                            <li>Hùng Vương, Bình Thạnh</li>   
                            <li>Thời gian: 7am to 11pm</li>					
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <!--- /contact ---->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
