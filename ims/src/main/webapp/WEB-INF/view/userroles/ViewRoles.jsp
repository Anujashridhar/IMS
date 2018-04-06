<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!-- 	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"> -->
	<link href="${pageContext.request.contextPath }/resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
</head>
<div id="page-wrapper">
	<div class="header">
		<h1 class="page-header">Roles List</h1>
	</div>

	<div id="page-inner">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
		<table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
 				   <thead>
            <tr>
                <th>Role Id</th>
                <th>Role Name</th>
                <th>Authorities</th>
                <th>Edit</th>
               
            </tr>
        </thead>
        
          <tbody>
          <c:forEach items="${roleWrapperList }" var="roleWrapper">
          
         
            <tr>
            	
                <td>${roleWrapper.role.roleId}</td>
                <td>${roleWrapper.role.roleName}</td>
                <td><c:forEach items="${roleWrapper.assignedAuthoritiesList }" var="authority">${fn:substringAfter(authority.name,"_")}, </c:forEach></td>
                <td><button class="glyphicon glyphicon-pencil" onclick="getContent('${pageContext.request.contextPath }/auth/createModifyRole?roleId=${roleWrapper.role.roleId}')"></button></td>
               
            </tr>
             </c:forEach>
            </tbody>
            
        <tfoot>
            <tr>
                 <th>Role Id</th>
                <th>Role Name</th>
                <th>Authorities</th>
            </tr>
        </tfoot>
      
    </table>
						
</div>
</div>
</div>
</div>
</div>
<%-- 
<script src="${pageContext.request.contextPath }/resources/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.dataTables.min.js"></script>
 
<script type="text/javascript">
<!--

//-->

$(document).ready(function() {
	 $.noConflict();
    $('#example').DataTable();
} )
</script>
--%>

</html>