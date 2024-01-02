<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/chat.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>
<main class="main">
	<section class="container">
    <div>
        <div class="wrap" id="wrap">
        </div>

        <div class="inputArea">
            <form class="label" id="submitMsg">
                <textarea class="textBox" id="msgData" type="text"></textarea>
                <button type="button" class="button" id="sendMsg">전송</button>
            </form>
        </div>
    </div>

    <div>
        <input type="hidden" id = "name" value="${userInfo.userDTO.name}" />
        <input type="hidden" id = "id" value="${userInfo.userDTO.usrId}" />
    </div>

    <section>
<main>
    <script>
        $(document).ready(function(){
            let username = $('#name').val();
            let userId = $('#id').val();

            <!-- Enter 키 전송 및 shiftEnter 전송 막기 -->
            $("#msgData").on("keyup click", (e) => {
               if (e.key === "Enter" && !e.shiftKey) {
                 if (event.key === "Enter" && event.shiftKey) {
                    return null;
                    }
                    send();
                }
            });

            $("#sendMsg").on("click", (e) => {
                send();
            });

            const websocket = new WebSocket("ws://localhost:8080/ws/chat");

            websocket.onmessage = onMessage;
            websocket.onopen = onOpen;
            websocket.onclose = onClose;

            function scrollToBottom() {
                var wrap = document.getElementById("wrap");
                wrap.scrollTop = wrap.scrollHeight;
            }

            function send(){
                let MsgDTO ={
                    roomId : $('#roomId').val(),
                    sndId : $('#sndId').val(),
                    sndNm : $('#sndNm').val(),
                    msg : $('#msg').val(),
                    rgsDate : $('#rgsDate').val(),
                    rgsUsr : $('#rgsUsr').val()
                };

                let msg = $("#msgData");
                let url = "/chat/chat.json"

                $.ajax({
                    type: "POST",
                    dataTyoe : "json",
                    url : url,
                    contentType: 'application/json; charset=utf-8',
                    data: JSON.stringify(MsgDTO),
                    success: function (response) {
                        alert(response);
                        console.log(response);
                        websocket.send(username + ":" + msg.val());
                        msg.val('');  // 입력 필드 초기화
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        alert("에러: " + textStatus + " " + errorThrown);
                        console.error("에러: " + textStatus, errorThrown);
                        msg.val('');  // 입력 필드 초기화
                    }
                });
                scrollToBottom();
            }

            function onClose(e){
                let str = username + ": 님이 방을 나가셨습니다.";
                websocket.send(str);
            }

            function onOpen(e){
                 var str = username + ": 님이 입장하셨습니다.";
                 websocket.send(str);
            }

            function onMessage(msg){
                var data = msg.data;
                var sessionId = null;
                var message = null;
                var arr = data.split(":");

                var cur_session = username;

                sessionId = arr[0];
                message = arr[1];

                if(sessionId == cur_session){
                    var str = "<div class='chat receive'>";
                }else{
                    var str = "<div class='chat send'>";
                }
                /* i 태그 이미지 주소 */
                str += "<div class='icon'><i class='fa-solid fa-user'></i></div>";
                str += "<div class='textbox'>" + sessionId + " : " + message + "</div>";
                str += "</div>";
                $("#wrap").append(str);
            }
        });




    </script>
</body>
</html>
