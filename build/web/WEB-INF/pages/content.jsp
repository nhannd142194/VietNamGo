
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>content</title>

        <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
        <script src="<c:url value="/resources/js/jquery.autocomplete.min.js" />"></script>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

        <script>
            $(document).ready(function () {
                $('#diem_di').autocomplete({
                    serviceUrl: '${pageContext.request.contextPath}/home/search',
                    paramName: "tagName",
                    delimiter: ",",
                    transformResult: function (response) {
                        return {
                            suggestions: $.map($.parseJSON(response), function (item) {
                                return {value: item.tenDiaDiem, data: item.idDiaDiem};
                            })
                        };
                    }
                });
            });
        </script>

        <script>
            $(document).ready(function () {
                $('#diem_den').autocomplete({
                    serviceUrl: '${pageContext.request.contextPath}/home/search',
                    paramName: "tagName",
                    delimiter: ",",
                    transformResult: function (response) {
                        return {
                            suggestions: $.map($.parseJSON(response), function (item) {
                                return {value: item.tenDiaDiem, data: item.idDiaDiem};
                            })
                        };
                    }
                });
            });
        </script>

    </head>
    <body>

        <!--- banner ---->
        <div class="banner">
            <div class="container">
                <h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> Chuyên Đề J2EE</h1>
            </div>
        </div>
        <div class="container">
            <div class="col-md-5 bann-info1 wow fadeInLeft animated" data-wow-delay=".5s">
                <i class="fa fa-columns"></i>
                <h3>Nhà tổ chức du lịch chuyên nghiệp</h3>
            </div>
            <div class="col-md-7 bann-info wow fadeInRight animated" data-wow-delay=".5s">
                <h2>Xách balo lên và đi ...</h2>
                <form action="${pageContext.request.contextPath}/home/search" method="post">
                    <div class="ban-top">
                        <div class="bnr-left">
                            <label class="inputLabel">Chọn điểm đi</label>
                            <input class="city" id="diem_di" type="text" placeholder="Enter a city" name="diemDi">
                        </div>
                        <div class="bnr-left">
                            <label class="inputLabel">Chọn điểm đến</label>
                            <input class="city" id="diem_den" type="text" placeholder="Enter a city" name="diemDen">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="ban-bottom">
                        <div class="bnr-right">
                            <label class="inputLabel">Chọn ngày khởi hành</label>
                            <input  id="datepicker" type="date" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />" name="ngayKhoiHanh">
                        </div>
                        <div class="bnr-right">
                            <label class="inputLabel">Chọn giá vé</label>
                            <select class="selectDD" name="giaVe">
                                <option value="0">Tất cả</option>
                                <option value="1000000">Dưới 1 triệu</option>
                                <option value="2000000">Dưới 2 triệu</option>
                                <option value="3000000">Dưới 3 triệu</option>
                                <option value="5000000">Dưới 5 triệu</option>
                                <option value="7000000">Dưới 7 triệu</option>
                                <option value="10000000">Dưới 10 triệu</option>
                                <option value="15000000">Dưới 15 triệu</option>
                                <option value="20000000">Dưới 20 triệu</option>
                            </select>
                        </div>
                        <div class="clearfix"></div>

                    </div>
                    <div class="sear">

                        <center><button class="seabtn">Tìm kiếm nhanh</button></center> 

                    </div>
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
        <!--- /banner ---->

    </body>
</html>
