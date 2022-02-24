<%@ tag body-content="scriptless" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>

<%
HttpSession httpSession = request.getSession(false);
if (httpSession != null && request.getAttribute("profile") != null) {
%> <jsp:doBody/>
<%
}
%>