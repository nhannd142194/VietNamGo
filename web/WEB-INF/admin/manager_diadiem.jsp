
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý địa điểm</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- Bootstrap Core CSS -->

        <link href="<c:url value="/resources/admin/css/bootstrap.css" />" rel='stylesheet' type='text/css' />
        <!-- Custom CSS -->

        <link href="<c:url value="/resources/admin/css/style.css" />" rel='stylesheet' type='text/css' />
        <!-- font CSS -->
        <!-- font-awesome icons -->

        <link href="<c:url value="/resources/admin/css/font-awesome.css" />" rel="stylesheet"> 
        <!-- //font-awesome icons -->
        <!-- js-->
        <script src="<c:url value="/resources/admin/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/admin/js/modernizr.custom.js" />"></script>

        <!--webfonts-->

        <link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <!--//webfonts--> 
        <!--animate-->

        <link href="<c:url value="/resources/admin/css/animate.css" />" rel="stylesheet" type="text/css" media="all">
        <script src="<c:url value="/resources/admin/js/wow.min.js" />"></script>
        <script>
            new WOW().init();
        </script>
        <!--//end-animate-->
        <!-- chart -->
        <script src="<c:url value="/resources/admin/js/Chart.js" />"></script>
        <!-- //chart -->
        <!--Calender-->
        <link rel="stylesheet" href=" <c:url value="/resources/admin/css/clndr.css" />" type="text/css" />
        <script src="<c:url value="/resources/admin/js/underscore-min.js" />" type="text/javascript"></script>
        <script src= "<c:url value="/resources/admin/js/moment-2.2.1.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/admin/js/clndr.js" />" type="text/javascript"></script>
        <script src="<c:url value="/resources/admin/js/site.js" />" type="text/javascript"></script>
        <!--End Calender-->
        <!-- Metis Menu -->

        <script src="<c:url value="/resources/admin/js/metisMenu.min.js" />"></script>
        <script src="<c:url value="/resources/admin/js/custom.js" />"></script>



        <link href=" <c:url value="/resources/admin/css/custom.css" />" rel="stylesheet">
    </head>
    <body class="cbp-spmenu-push">
        <div class="main-content">
            <!-- navigation-->
            <jsp:include page="navigation.jsp"></jsp:include>
                <!-- //header-ends -->
            <jsp:include page="header.jsp"></jsp:include>
                <!-- main content start-->
                <div id="page-wrapper">
                    <div class="main-page">
                        <div class="tables">
                            <div class="table-responsive bs-example widget-shadow">
                                <h4>Danh Sách Điểm</h4> <a href="${pageContext.request.contextPath}/admin/diadiem/insert">Thêm mới</a>
                            <table class="table table-bordered" style="margin-top: 20px">
                                <thead> 
                                    <tr>
                                        <th>STT</th>
                                        <th>Tên Điểm</th> 
                                        <th>Thao Tác</th> 
                                    </tr>
                                </thead> 
                                <tbody> 
                                    <c:set var="num" value="0"></c:set>

                                    <c:forEach var="d" items="${listDiaDiem}">
                                        <c:set var="num" value="${num + 1}" />
                                        <tr> 
                                            <th scope="row"><c:out value="${num}"></c:out></th>
                                            <td>${d.tenDiaDiem}</td> 
                                            <td><a href="${pageContext.request.contextPath}/admin/diadiem/update?id=${d.idDiaDiem}">Sửa</a> | <a href="${pageContext.request.contextPath}/admin/diadiem/delete?id=${d.idDiaDiem}">Xóa</a></td> 
                                        </tr>
                                    </c:forEach>
                                </tbody> 
                            </table> 
                            <div id="page-info" style="float: right">Trang 
                                <c:forEach var="i" begin="1" end="${size}">
                                    <a href="${pageContext.request.contextPath}/admin/diadiem/indexd?d=${i-1}" id="page-info" > <strong>${i}</strong> </a>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <div hidden="" class="row calender widget-shadow">
                        <h4 class="title">Calender</h4>
                        <div class="cal1">

                        </div>
                    </div>
                </div>
            </div>
            <jsp:include page="footer.jsp"></jsp:include>
            </div>

            <!-- Classie -->

            <script src=" <c:url value="/resources/admin/js/classie.js" />"></script>
        <script>
            var menuLeft = document.getElementById('cbp-spmenu-s1'),
                    showLeftPush = document.getElementById('showLeftPush'),
                    body = document.body;

            showLeftPush.onclick = function () {
                classie.toggle(this, 'active');
                classie.toggle(body, 'cbp-spmenu-push-toright');
                classie.toggle(menuLeft, 'cbp-spmenu-open');
                disableOther('showLeftPush');
            };


            function disableOther(button) {
                if (button !== 'showLeftPush') {
                    classie.toggle(showLeftPush, 'disabled');
                }
            }
        </script>
        <!--scrolling js-->

        <script src="<c:url value="/resources/admin/js/jquery.nicescroll.js" />"></script>

        <script src="<c:url value="/resources/admin/js/scripts.js" />"></script>
        <!--//scrolling js-->
        <!-- Bootstrap Core JavaScript -->

        <script src="<c:url value="/resources/admin/js/bootstrap.js" />"></script>
    </body>
</html>
