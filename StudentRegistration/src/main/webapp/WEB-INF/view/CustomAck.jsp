<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             Acknowledgment
                        </h1>
		 </div>
		
            <div id="page-inner"> 
			
              <div class="row">
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-action">
                          
                        </div>
                        <div class="card-content">
                         	<span class="signout-button"> <a id="link-signout"
				class="i-button i-button-signout" href="${pageContext.request.contextPath }/dashboard">Dashboard</a>
			</span>
		<c:if test="${status== true }">
		<br><h1 style="color: green;">
			<br>
		</c:if>
			<c:if test="${status== false }">
		<br><h1 style="color: red;">
			<br>
		</c:if>
			${resultDataMap.message}
			${message }
			
			
</h1>
</div>
</div>
</div>
</div>
</div>
</div>
