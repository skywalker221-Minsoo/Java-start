<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
<script type="text/javascript" src="resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
/* 	$(function() {
		$('button').click(function() {
			dataTag = $('#data')
			dataValue = dataTag.val()
			alert(dataValue)
		})
	}) */
	//버튼을 클릭했을 때
	//data에 들어있는 value를 가지고 와서 출력
	$(function() {
		$('#button1').click(function() {
			data = $('#data').val()
			alert(data)
		})
		
		$('#button2').click(function() {
			data = $('#data2').val()
			alert(data)
		})
		
		$('#button3').click(function() {
			data = $('#data3').val()
			length = data.length
			alert(length)
		})
	})
	
</script>
</head>
<body>
<input id="data" value="밥먹으러 가자.!!!">
<button id="button1">뭐할거니?</button>
<hr>
<input id="data2" value="태권도장 가자.!!!">
<button id="button2">오늘 끝나고 어디로 갈까?</button>
<hr>
<input id="data3" value="태권도장 가자.!!!">
<button id="button3">아이디 길이체크</button>
<hr>
</body>
</html>