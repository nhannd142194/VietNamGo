
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giới thiệu</title>

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
                    <h1 class="wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;"> Chuyên Đề J2EE</h1>
                </div>
            </div>
            <!--- /banner-1 ---->
            <!--- about ---->
            <div class="about">
                <div class="container">
                    <div class="about-top wow zoomIn animated animated" data-wow-delay=".5s" style="visibility: visible; animation-delay: 0.5s; animation-name: zoomIn;">
                        <h2>Giới thiệu</h2>
                        <p>1 bus ticketing and hotel room reservation platform, was founded in 2013 and is a part of the Group. We take pride in providing the platform to book bus tickets with zero booking charges. You can now choose from 10,000+ bus operators and 90,000 routes</p>
                    </div>
                    <div class="about-mid">
                        <div class="col-md-6 abt-lft wow fadeInLeft animated" data-wow-delay=".5s">
                            <h3>TẦM NHÌN</h3>
                            <p>Trên cơ sở phát triển bền vững sau gần 20 năm hình thành và phát triển, Vietravel hướng đến trở thành 1 trong 10 công ty lữ hành hàng đầu khu vực Đông Nam Á vào năm 2015. Đến năm 2020. Vietravel phấn đấu trở thành 1 trong 10 công ty du lịch hàng đầu châu Á và trở thành Top Tập đoàn lữ hành hàng đầu khu vực Châu Á. 
                                Đây là tầm nhìn chiến lược và đầy thử thách nhưng với một mục tiêu chung, Vietravel đã và đang hiện thực hoá những mục tiêu chiến lược của mình.</p>
                        </div>
                        <div class="col-md-6 abt-lft wow fadeInRight animated" data-wow-delay=".5s">
                            <h3>SỨ MỆNH</h3>
                            <p>Mang lại cảm xúc thăng hoa cho du khách trong mỗi hành trình - Đây là mục tiêu và là sứ mệnh Vietravel cam kết và nỗ lực mang lại cho du khách. Vietravel trở thành người bạn đồng hành cùng du khách trong mọi hành trình du lịch và tạo ra những giá trị tốt đẹp. Tại Vietravel, du lịch không những là hành trình khám phá mà còn là hành trình sẻ chia, thể hiện dấu ấn khác biệt của Thương hiệu Vietravel từ 3 thuộc tính thương hiệu: Sự chuyên nghiệp, mang lại cảm xúc thăng hoa cho khách hàng và những giá trị gia tăng hấp dẫn cho du khách sau mỗi chuyến đi. </p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="ab-btm">
                        <div class="col-md-8 ab-lt wow fadeInLeft animated" data-wow-delay=".5s">
                            <h3>TRIẾT LÝ KINH DOANH </h3>
                            <div class="ab-tp">
                                <p>Khách hàng là trung tâm: Vietravel luôn khẳng định khách hàng là trung tâm của mọi hoạt động kinh doanh mà Vietravel hướng đến, vì khách hàng là người góp phần to lớn xây dựng nên thương hiệu Vietravel.</p>
                                
                            </div>
                            <div class="ab-tp">
                                <p>Chuyên nghiệp là thước đo: Khẳng định uy tín thương hiệu, với mục tiêu không ngừng phát triển hoàn thiện để đạt đến những tầm cao mới trong định hướng chiến lược vươn ra thế giới.   </p>
                                
                            </div>
                            <div class="ab-tp">
                                <p>Chất lượng là danh dự: Vietravel cam kết chất lượng dịch vụ cung cấp đến khách hàng là tốt nhất, điều đó tạo nên sự khác biệt so với thị trường, Vietravel xem đó là trách nhiệm, là danh dự của mỗi cán bộ - nhân viên. </p>
                                
                            </div>
                        </div>
                        <div class="col-md-4 ab-rt wow fadeInRight animated" data-wow-delay=".5s">
                            
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <!--- /about ---->

        <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
