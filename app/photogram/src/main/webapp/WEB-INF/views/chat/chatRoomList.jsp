<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/chatRoomList.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>
<main class="main">
	<section class="container">
	    <div class="listContainer">
	        <button type="button" class="list" id="chatList" onClick="chatList(${userInfo.userDTO.usrId})">채팅 목록</button>
	        <button type="button" class="list" id="getUser" onClick="getUser(${userInfo.userDTO.usrId})">사용자 목록</button>
	    </div>
    <!-- 아이탬 영역 -->
    <div>
        <div class="wrap" id="wrap">
            <div class="chat-list" id ="chat-list">
            </div>

            <div class="chat-list" id ="user-list">
            </div>
        </div>
    </div>

    <!-- 채팅 모달 -->
    <div class="modal-info" onclick="modalInfo()">
    	<div class="modal">
    		<button onclick=enterChatRoom()>채팅 시작</button>
    		<button onclick="location.href='/logout'">사용자 정보 보기</button>
    		<button onclick="closePopup('.modal-info')">취소</button>
    	</div>
    </div>



    <!-- hidden -->
    <div>
        <input type="hidden" id = "name"  value="${userInfo.userDTO.name}" />
        <input type="hidden" id = "id"  value="${userInfo.userDTO.usrId}" />
    </div>

    <section>
<main>
    <script src="/js/chatRoomList.js"></script>
</body>
</html>

<%@ include file="../layout/footer.jsp"%>