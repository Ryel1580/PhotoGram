// (1) 회원정보 수정
function update(id) {

    let data =$("#profileUpdate").serialize();

    console.log(data);

      $.ajax({
          type: "put",
          url: `/api/user/${id}`,
          contentType: 'application/x-www-form-urlencoded; charset=utf-8',
          data: data,
          dataType: "json"
      }).done(res => {
          alert("회원정보 수정 완료");
          console.log("성공");
          location.href = "/";
      }).fail((xhr, status, error) => {
          console.log("실패");
          console.error(xhr.responseText); // 에러 메시지 출력
      });


}