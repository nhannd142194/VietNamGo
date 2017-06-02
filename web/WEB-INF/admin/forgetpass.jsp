
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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

        <script src="<c:url value="/resources/ckeditor/ckeditor.js" />"></script>

    </head>
    <body class="cbp-spmenu-push">
        
        <div class="main-content">
            <!-- navigation-->
            <jsp:include page="navigation.jsp"></jsp:include>
                <!-- //header-ends -->
            <jsp:include page="header.jsp"></jsp:include>
                <div id="page-wrapper">
                    <div class="main-page">
                        <div class="forms">
                            <div class="row">
                                <h3 class="title1">Đổi mật khẩu</h3>
                                <div class="form-three widget-shadow">
                                    <form action="${pageContext.request.contextPath}/admin/user/forgetpass" class="form-horizontal" method="POST">
                                        <div class="form-group">
                                            <label for="focusedinput" class="col-sm-2 control-label">Mật khẩu cũ</label>
                                            <div class="col-sm-8">
                                                <input name="matKhauCu" type="text" class="form-control1" id="focusedinput" placeholder="Nhập mật khẩu cũ">
                                            </div>
                                            <div class="col-sm-2">
                                                <p style="color: red" class="help-block">${err_matKhauCu}</p>
                                        </div>
                                    </div>
                                         <div class="form-group">
                                            <label for="focusedinput" class="col-sm-2 control-label">Mật khẩu mới</label>
                                            <div class="col-sm-8">
                                                <input name="matKhauMoi" type="text" class="form-control1" id="focusedinput" placeholder="Nhập Mật khẩu mới">
                                            </div>
                                            <div class="col-sm-2">
                                                <p style="color: red" class="help-block">${err_matKhauMoi}</p>
                                        </div>
                                    </div>
                                         <div class="form-group">
                                            <label for="focusedinput" class="col-sm-2 control-label">Nhập lai mật khẩu</label>
                                            <div class="col-sm-8">
                                                <input name="nmatKhauMoi" type="text" class="form-control1" id="focusedinput" placeholder="Nhập lai mật khẩu">
                                            </div>
                                            <div class="col-sm-2">
                                                <p style="color: red" class="help-block">${err_matKhauNMoi}</p>
                                        </div>
                                    </div>
                                        <div class="form-group">
                                            <label for="focusedinput" class="col-sm-2 control-label"></label>
                                             <div class="col-sm-8">
                                                 <input type="submit"  value="Lưu dữ liệu"  />
                                                
                                             </div>
                                      <td></td>
                                        </div>
                                          
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- footer-->
            <jsp:include page="footer.jsp"></jsp:include>

            </dv>
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
