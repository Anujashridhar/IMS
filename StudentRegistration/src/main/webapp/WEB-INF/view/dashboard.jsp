 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@include file="header.jsp" %><h1>hfyh ${userId}${templateChooseForm }</h1>
<div id="frame_div" >
 <c:if test="${templateChooseForm }">
 <%-- <%@include file="ChooseTemplate.jsp" %> --%>
 </c:if>
  <%-- <c:if test="${templateChooseForm } ">
<%@include file="dashboard.jsp" %>
</c:if> --%>
</div>
 <%@include file="footer.jsp" %> 