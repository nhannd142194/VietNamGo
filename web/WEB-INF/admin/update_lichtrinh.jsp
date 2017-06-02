
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
                                <h3 class="title1">Cập Nhật Lịch Trình</h3>
                                <div class="form-three widget-shadow">
                                    <form class="form-horizontal" action="${pageContext.request.contextPath}/admin/lichtrinh/update" 
                                      method="POST">
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Tên Lịch Trình:</label>
                                        <div class="col-sm-8">
                                            <input  type="text" class="form-control1" id="focusedinput" placeholder="Nhập Tên Lịch Trình" name="tenLichTrinh" maxlength="100" value="${lichtrinh.tenLichTrinh}">
                                        </div>
                                        <div class="col-sm-2">
                                            <p style="color: red" class="help-block">${err_tenlichtrinh}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Giá Vé:</label>
                                        <div class="col-sm-8">
                                            <input type="number" class="form-control1" id="focusedinput"  name="giaVe" maxlength="100" value="${lichtrinh.giaVe}">
                                        </div>
                                        <div class="col-sm-2">
                                            <p style="color: red" class="help-block">${err_GiaVe}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Giảm giá:</label>
                                        <div class="col-sm-8">
                                            <select name="giamGia" style="width: 10%">
                                                <c:forEach var="i" begin="0" end="20">
                                                    <option value="${i*5}">${i*5} %</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label class="col-sm-2 control-label">Điểm Đi:</label>
                                            <div class="col-sm-8">
                                                <td>
                                                    <c:set var="diemDi" value="${lichtrinh.diemDi.idDiaDiem}"></c:set>
                                                    <select class="styledselect_form_1" name="idDiemDi">
                                                        <c:forEach var="i" items="${listDiem}">
                                                            <option value="${i.idDiaDiem}" ${i.idDiaDiem == diemDi ? 'selected="selected"' : ''}>${i.tenDiaDiem}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </div>
                                        </div>
                                        <td></td>
                                    </div>
                                    <div class="form-group">
                                        <div class="checkbox">
                                            <label class="col-sm-2 control-label">Điểm đến:</label>
                                            <div class="col-sm-8">
                                                <td>
                                                    <c:set var="diemDen" value="${lichtrinh.diemDen.idDiaDiem}"></c:set>
                                                    <select class="styledselect_form_1" name="idDiemDen">
                                                        <c:forEach var="i" items="${listDiem}">
                                                            <option value="${i.idDiaDiem}" ${i.idDiaDiem == diemDen ? 'selected="selected"' : ''}>${i.tenDiaDiem}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                            </div>
                                        </div>
                                        <td></td>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Ngày Khởi Hành:</label>
                                        <div class="col-sm-8">
                                            <input type="date" class="form-control1" id="focusedinput" name="ngayKhoiHanh" maxlength="100" value="${lichtrinh.ngayKhoiHanh}">
                                        </div>
                                        <div class="col-sm-2">
                                            <p style="color: red"class="help-block">${err_NgayKhoiHanh}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Ngày Kết Thúc:</label>
                                        <div class="col-sm-8">
                                            <input type="date" class="form-control1" id="focusedinput"  name="ngayKetThuc" maxlength="100" value="${lichtrinh.ngayKetThuc}">
                                        </div>
                                        <div class="col-sm-2">
                                            <p style="color: red" class="help-block">${err_NgayKetThuc}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Mô tả ngắn:</label>
                                        <div class="col-sm-8">
                                            <textarea  class="form-textarea" name="moTaNgan" style="width: 100%; height: 100px; " maxlength="500">${lichtrinh.moTaNgan}</textarea>
                                        </div>
                                        <div class="col-sm-2">
                                            <p style="color: red" class="help-block">${err_MoTaNgan}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="focusedinput" class="col-sm-2 control-label">Chi tiết bài viết:</label>
                                        <div class="col-sm-8">
                                            <td><textarea class="form-textarea" id="moTaChiTiet" name="moTaChiTiet">${lichtrinh.moTaChiTiet}</textarea></td>
                                            <script type="text/javascript" language="javascript">
                                                CKEDITOR.replace('moTaChiTiet', {
                                                    width: '100%',
                                                    height: '500px'
                                                });
                                            </script>
                                        </div>
                                        <div class="col-sm-2">
                                            <p style="color: red"class="help-block">${err_MoTaChiTiet}</p>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-8">
                                            <input  type="hidden" value="${lichtrinh.idLichTrinh}" name="idLichTrinh">
                                            <td colspan="3" style="float: right"><input  type="submit" value="Lưu dữ liệu" ></td>
                                            <td colspan="3" style="float: right"><input  type="reset" value="Quay lại trang quản lý" ></td>
                                        </div>

                                    </div>
                                </form>
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
