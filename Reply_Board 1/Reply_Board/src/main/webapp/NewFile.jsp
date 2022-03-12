<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
function 등록하다(){
	alert( $('#summernote').val());
	return false;
}
</script>
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
에디터



<form onsubmit="return 등록하다()" action="board" method="post" >
<textarea id="summernote" name="contents"></textarea><br>
<input type="submit" value="등록"/> 
</form>
</body>
</html>
<script>
$(document).ready(function() {
	  $('#summernote').summernote();
	});

</script>