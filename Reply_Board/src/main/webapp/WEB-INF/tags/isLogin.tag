<%@ tag body-content="scriptless" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true"%>

<%
HttpSession httpSession = request.getSession(false);
if (httpSession != null && httpSession.getAttribute("loginUser") != null) {
%> <jsp:doBody/>
<%
}
%>