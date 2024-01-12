let selectUser;

$(document).ready(function() {
    $("#chat-list").on("dblclick", ".user", function() {
        selectUser = $(this).find("#usrId").val();
        console.log(selectUser);
        popup('.modal-info');
    });
});



// 채팅방 리스트 불러오기
function chatList(id) {
      $.ajax({
          type: "get",
          url: `/api/chatList/${id}`,
          contentType: 'application/x-www-form-urlencoded; charset=utf-8',
          data: id,
          dataType: "json"
      }).done(res => {
        console.log("성공");
         $("#chat-list").empty();
         $("#user-list").empty();
         res.forEach(function(data) {
            let str = "<div class='chat' id='chat'><div class='chat-info'>";
            str += "<h2>" + 수정해야함 + "</h2>";
            str += "<p>" + 수정해야함 + "</p>";
            str += "</div></div>"
            $("#chat-list").append(str);
         });
      }).fail((xhr, status, error) => {
          console.log("실패");
          console.error(xhr.responseText); // 에러 메시지 출력
      });


}
// 사용자 목록 불러오기
 function getUser(id) {
     $.ajax({
         type: "GET",
         url: `/api/getUser/${id}`,
         dataType: "json"
     }).done(res => {
         console.log("성공");
         $("#chat-list").empty();
         $("#user-list").empty();
         res.forEach(function(data) {
            let str = "<div class='user' id='user'><div class='user-info'>";
            str += "<input type='hidden' id = 'usrId' value=" + data.usrId + ">"
            str += "<h2>" + data.name + "</h2>";
            str += "<p>" + data.email + "</p>";
            str += "</div></div>"
            $("#chat-list").append(str);
         });
     }).fail((xhr, status, error) => {
         console.log("실패");
         console.error(xhr.responseText); // 에러 메시지 출력
     });
 }

// 채팅방 ajax 입장 수정해야함
 function enterChatRoom() {
    let enterChatRoomDTO = {
         sndId: $("#id").val(),
         rcvId: selectUser
    };
     console.log(enterChatRoomDTO);

     $.ajax({
        type: "GET",
        url: "/api/enterChatRoom",
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(enterChatRoomDTO),
        dataType: "json"
     }).done(res => {
         console.log("성공");
     }).fail((xhr, status, error) => {
         console.log("실패");
         console.error(xhr.responseText); // 에러 메시지 출력
     });
 }



// (채팅 모달 닫기)
function modalInfo() {
	$(".modal-info").css("display", "none");
}

// 채팅 모달 열기 닫기
function popup(obj) {
	$(obj).css("display", "flex");
}

function closePopup(obj) {
	$(obj).css("display", "none");
}
