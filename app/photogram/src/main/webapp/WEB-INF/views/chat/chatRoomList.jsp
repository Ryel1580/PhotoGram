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

    <div>
        <div class="wrap" id="wrap">
            <div class="chat-list">
              <div class="chat">
                <div class="chat-info">
                  <h2>User 1</h2>
                  <p>Last message...</p>
                </div>
              </div>

              <div class="chat">
                <img src="user2.jpg" alt="User 2" class="profile-pic">
                <div class="chat-info">
                  <h2>User 2</h2>
                  <p>Last message...</p>
                </div>
              </div>
        </div>
        <div>

        </div>
    </div>

    <div>
        <input type="hidden" id = "name"  value="${userInfo.userDTO.name}" />
        <input type="hidden" id = "id"  value="${userInfo.userDTO.usrId}" />
    </div>

    <section>
<main>
    <script src="/js/roomList.js"></script>
</body>
</html>
