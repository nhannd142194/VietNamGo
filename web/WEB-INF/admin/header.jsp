

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
    <!-- header-starts -->
    <div class="sticky-header header-section ">
        <div class="header-left">
            <!--toggle button start-->
            <button id="showLeftPush"><i class="fa fa-bars"></i></button>
            <!--toggle button end-->
            <!--logo -->
            <div class="logo">
                <a href="${pageContext.request.contextPath}/admin/index">
                    <h1>VIETNAMGO</h1>
                    <span>Manager</span>
                </a>
            </div>
            <div class="clearfix"> </div>
        </div>
        <div class="header-right">
            <div class="profile_details_left"><!--notifications of menu start -->
                <ul class="nofitications-dropdown">
                    <li class="dropdown head-dpdn">
                        <ul class="dropdown-menu">
                        </ul>
                    </li>	
                </ul>
                <div class="clearfix"> </div>
            </div>
            <!--notification menu end -->
            <div class="profile_details">		
                <ul>
                    <li class="dropdown profile_details_drop">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                            <div class="profile_img">	
                                <span class="prfil-img"></span> 
                                <div class="user-name">
                                    <p>${sessionScope.taiKhoan.email}</p>
                                </div>
                                <i class="fa fa-angle-down lnr"></i>
                                <i class="fa fa-angle-up lnr"></i>
                                <div class="clearfix"></div>	
                            </div>	
                        </a>
                        <ul class="dropdown-menu drp-mnu">
                            <li> <a href="${pageContext.request.contextPath}/admin/user/forgetpass"><i class="fa fa-sign-out"></i>Đổi mật khẩu</a> </li>
                            <li> <a href="${pageContext.request.contextPath}/admin/user/logout"><i class="fa fa-sign-out"></i>Đăng xuất</a> </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="clearfix"> </div>				
        </div>
        <div class="clearfix"> </div>	
    </div>
</body>
</html>
