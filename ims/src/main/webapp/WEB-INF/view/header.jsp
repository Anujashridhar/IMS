<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Admin Dashboard</title>
	
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="resources/assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="resources/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="resources/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="resources/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="resources/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="resources/assets/js/Lightweight-Chart/cssCharts.css"> 
    <script src="resources/assets/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/header.js"></script>
  <!--   
    <script>
        function getContent(url)
        {
        	debugger;
        	$.ajax({url: url, success: function(result){
            	debugger;
                $("#frame_div").html(result);
               
            }});
        }
	</script>
     -->
    
    
</head>
<style>
.submitLink {
  background-color: transparent;
  text-decoration: underline;
  border: none;
  color: blue;
  cursor: pointer;
}
submitLink:focus {
  outline: none;
}
</style>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
              <!--  <a class="navbar-brand waves-effect waves-dark" href="index.html"><i class="large material-icons">insert_chart</i> <strong>TRACK</strong></a>  -->
				  <a class="navbar-brand waves-effect waves-dark" href="index.html"><i class="large material-icons">home</i> <strong>IMS</strong></a>
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right"> 
				<li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown4"><i class="fa fa-envelope fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>				
				<li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown3"><i class="fa fa-tasks fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown2"><i class="fa fa-bell fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>
				  <li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>
            </ul>
        </nav>
		<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">
<li><a href="#"><i class="fa fa-user fa-fw"></i> My Profile</a>
</li>

<li><a href="${pageContext.request.contextPath }/dashboard/ChangePassword"><i class="fa fa-gear fa-fw"></i> ChangePassword</a>
</li> 
<li><form:form action="logout" method="post"><input type="submit" class="submitLink" value="logout"></form:form>
</li>
</ul>
<ul id="dropdown2" class="dropdown-content w250">
  <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
</ul>
<ul id="dropdown3" class="dropdown-content dropdown-tasks w250">
<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 1</strong>
					<span class="pull-right text-muted">60% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						<span class="sr-only">60% Complete (success)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 2</strong>
					<span class="pull-right text-muted">28% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
						<span class="sr-only">28% Complete</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 3</strong>
					<span class="pull-right text-muted">60% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						<span class="sr-only">60% Complete (warning)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 4</strong>
					<span class="pull-right text-muted">85% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
						<span class="sr-only">85% Complete (danger)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
</ul>   
<ul id="dropdown4" class="dropdown-content dropdown-tasks w250">
  <li>
                            <a href="#">
                                <div>
                                    <strong>John Doe</strong>
                                    <span class="pull-right text-muted">
               
                                        <em>Today</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since an kwilnw...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
</ul>  
	   <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

             <!--        <li>
                        <a class="active-menu waves-effect waves-dark" onclick="getContent('dashboard')"><i class="fa fa-dashboard"></i> Dashboard</a>
                    </li>
                     <li>
                    	<a onclick="getContent('ChooseTemplate')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                     <li>
                    	<a onclick="getContent('siteTemplateSetupG')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Site Data</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                     <li>
                    	<a onclick="getContent('countryList')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Country Master</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                      <li>
                    	<a onclick="getContent('ChooseState')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>State Master</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                     <li>
                    	<a onclick="getContent('SiteImagesForm')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Upload site Images</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                     <li>
                    	<a onclick="getContent('ChooseLocationLevel1')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Location Level 1</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
           			<li>
                    	<a onclick="getContent('ChooseLocationLevel2')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Location Level 2</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                    <li>
                    	<a onclick="getContent('ChooseLocationLevel3')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Location Level 3</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                     <li>
                    	<a onclick="getContent('ChooseLocationLevel4')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Location Level 4</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                    <li>
                    	<a onclick="getContent('uploadLogo')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Upload Logo</a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
                    <li>
                    	<a onclick="getContent('contentDetail')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Div Content </a>
                    	<a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a>
                    </li>
 -->
					
<c:forEach items="${menus}" var="menuGroup">
					<c:forEach items="${menuGroup.menuList}" var="menu">

		 					<li>
		                    	<a onclick="getContent('${pageContext.request.contextPath}${menu.url}')" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>${menu.menuName }</a>
		                    	<!-- <a href="ChooseTemplate" class="waves-effect waves-dark"><i class="fa fa-desktop"></i>Select Template</a> -->
		                    </li>
                    
                    </c:forEach>
</c:forEach>



                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->
      
	
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    </div>

 

</body>

</html>