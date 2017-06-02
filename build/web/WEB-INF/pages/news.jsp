
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>blog</title>
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

            <!--- blog ---->
            <div class="blog">
                <div class="container">
                    <div class="col-md-8 blog-left">

                    <c:forEach var="i" items="${listNews}">
                        <div class="comments-list hover14 column animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <h3><a href="${pageContext.request.contextPath}/home/detailnews?id=${i.idTinTuc}">${i.tenTinTuc}</a></h3>
                            <ul>
                                <li><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>${i.ngayDang}<i>|</i></li>
                                <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>${i.user.hoTen}</a></li>
                            </ul>
                            <div>
                                <figure><a href="single1.html"><img width="100%"  src="${pageContext.request.contextPath}/admin/news/img?id=${i.idTinTuc}" alt=" " class="img-responsive"></a></figure>
                            </div>
                            <p style="text-align: justify;">${i.moTaNgan}</p>
                            <div class="more" style="float: right">
                                <a href="${pageContext.request.contextPath}/home/detailnews?id=${i.idTinTuc}">Xem thêm bài viết</a>
                            </div>
                        </div>
                    </c:forEach>

                    <nav style="float: right">
                        <ul class="pagination paging animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                            <li>
                                <a aria-label="Previous">
                                    <span aria-hidden="true">Trang: </span>
                                </a>
                            </li>
                            <c:forEach var="i" begin="1" end="${size}">
                                <li><a href="${pageContext.request.contextPath}/home/news?kind=${kind}&p=${i-1}" id="page-info" > <strong>${i}</strong> </a></li>
                                </c:forEach>     
                        </ul>
                    </nav>
                </div>
                <div class="col-md-4 blog-right">
                    <div class="popular animated wow fadeInUp animated" data-wow-duration="1200ms" data-wow-delay="500ms" style="visibility: visible; animation-duration: 1200ms; animation-delay: 500ms; animation-name: fadeInUp;">
                        <h3>Bản tin chính</h3>
                        <div class="popular-grid">
                            <div class="popular-left">
                                <h4>01.</h4>
                            </div>
                            <div class="popular-right">
                                <h5><a href="${pageContext.request.contextPath}/home/news?kind=1&p=0">Khuyến mãi</a></h5>
                                <p>Cập nhật tin tức khuyến mãi mới, quà tặng hấp dẫn nhất cho bạn.</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="popular-grid">
                            <div class="popular-left">
                                <h4>02.</h4>
                            </div>
                            <div class="popular-right">
                                <h5><a href="${pageContext.request.contextPath}/home/news?kind=2&p=0">Điểm du lịch</a></h5>
                                <p>Mỗi địa danh, đất nước là hàng tá điểm du lịch hút khách mà bạn chưa có dịp khám phá</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                        <div class="popular-grid">
                            <div class="popular-left">
                                <h4>03.</h4>
                            </div>
                            <div class="popular-right">
                                <h5><a href="${pageContext.request.contextPath}/home/news?kind=3&p=0">Ẩm thực</a></h5>
                                <p>Bạn yêu thích ăn uống, vậy thì không thể bỏ qua chuyên mục này được</p>
                            </div>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    

                </div>
                <div class="clearfix"> </div>
            </div>
        </div>
        <!--- /blog ---->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
