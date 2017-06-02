
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>navigation</title>
    </head>
    <body>
        <!--       	left-fixed -navigation
        -->        <div class=" sidebar" role="navigation">
            <div class="navbar-collapse">
                <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/index" class="active"><i class="fa fa-home nav_icon"></i>Trang chủ</a>
                        </li>
                        <li >
                            <a href="${pageContext.request.contextPath}/admin/diadiem/index"><i class="fa fa-book nav_icon"></i>Quản lý địa điểm</a>
                        </li>
                         <li >
                            <a href="${pageContext.request.contextPath}/admin/lichtrinh/index"><i class="fa fa-book nav_icon"></i>Quản lý lịch trình</a>
                        </li>
                        <li >
                            <a href="${pageContext.request.contextPath}/admin/user/index"><i class="fa fa-book nav_icon"></i>Quản lý tài khoản</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/admin/news/index"><i class="fa fa-file-text-o nav_icon"></i>Quản lý tin tức</a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>



    </body>
</html>
