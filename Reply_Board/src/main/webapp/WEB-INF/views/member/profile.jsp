<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
   //응답(response)객체에 이미지 전송하도록 설정
   byte[] 프로필=(byte[])request.getAttribute("profile"); 
   response.setContentType("image/png");
   ServletOutputStream 배송자= response.getOutputStream();
      배송자.write(프로필);
%>