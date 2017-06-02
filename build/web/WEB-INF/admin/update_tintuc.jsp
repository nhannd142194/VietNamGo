
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

    <c:if test="${sessionScope.taiKhoan.quyen != 1}">
        <c:redirect url="${url}"/>
    </c:if>

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
                                <h3 class="title1">Cập nhật tin tức</h3>
                                <div class="form-three widget-shadow">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/news/update" 
                                      method="post" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Tiêu đề bài viết:</label>
                                        <div class="col-sm-8">
                                            <input type="text" class="form-control1" id="focusedinput" placeholder="Nhập Tên Tin Tức" name="tenTinTuc" value="${tintuc.tenTinTuc}">
                                        </div>
                                        <div class="col-sm-2">
                                            <p class="help-block" style="color: red">${err_tenTinTuc}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label class="col-sm-2 control-label">Thuộc chuyên mục:</label>
                                            <div class="col-sm-8">
                                                <td>
                                                    <c:set var="num" value="${tintuc.loaiTin.idLoaiTen}"></c:set>
                                                        <select class="styledselect_form_1" name="idLoaiTen">
                                                        <c:forEach var="i" items="${listLoaiTin}">
                                                            <option value="${i.idLoaiTen}" ${i.idLoaiTen == num ? 'selected="selected"' : ''}>${i.tenLoai}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </div>
                                            <div class="col-sm-2">
                                                <p class="help-block"></p>
                                            </div>
                                        </div>
                                        <td></td>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label"></label>
                                        <div class="col-sm-8">
                                            <td></td><td><img width="250px" src="${pageContext.request.contextPath}/admin/news/img?id=${tintuc.idTinTuc}" alt="" /></td>
                                        </div>
                                        <div class="col-sm-2">
                                            <p class="help-block"></p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Hình ảnh:</label>
                                        <div class="col-sm-8">
                                            <td></td>  <td ><input  type="file" name="hinhAnh"></td>
                                        </div>
                                        <div class="col-sm-2">
                                            <p class="help-block" style="color: red">${err_hinhAnh}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Mô tả ngắn:</label>
                                        <div class="col-sm-8">
                                            <input  type="text" class="form-control1" id="focusedinput" placeholder="Nhập Mô Tả Ngắn"  name="moTaNgan" value="${tintuc.moTaNgan}">
                                        </div>
                                        <div class="col-sm-2">
                                            <p class="help-block" style="color: red">${err_moTaNgan}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Chi tiết bài viết:</label>
                                        <div class="col-sm-8">
                                            <td><textarea class="form-textarea" id="moTaChiTiet" name="moTaChiTiet">${tintuc.moTaChiTiet}</textarea></td>
                                            <script type="text/javascript" language="javascript">
            CKEDITOR.replace('moTaChiTiet', {
                width: '100%',
                height: '500px'
            });
                                            </script>
                                        </div>
                                        <div class="col-sm-2">
                                            <p class="help-block" style="color: red">${err_moTaChiTiet}</p>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-8">
                                            <input type="hidden" name="idTinTuc" value="${tintuc.idTinTuc}">
                                            <td colspan="3" style="float: right"><input  type="submit" value="Lưu dữ liệu" ></td>
                                            <td colspan="3" style="float: right"><input  type="reset" value="Quay lại trang quản lý" ></td>
                                        </div>

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
