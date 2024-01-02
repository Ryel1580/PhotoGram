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
      }).fail((xhr, status, error) => {
          console.log("실패");
          console.error(xhr.responseText); // 에러 메시지 출력
      });


}
// 친구 목록 불러오기
function getUser(id) {
      $.ajax({
          type: "get",
          url: `/api/getUser/${id}`,
          contentType: 'application/x-www-form-urlencoded; charset=utf-8',
          data: id,
          dataType: "json"
      }).done(res => {
          console.log("성공");
      }).fail((xhr, status, error) => {
          console.log("실패");
          console.error(xhr.responseText); // 에러 메시지 출력
      });


}