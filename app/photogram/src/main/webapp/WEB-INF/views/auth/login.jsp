<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous">
    <!-- jQuery CDN을 이용하여 불러오기 -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>

<body>
    <div id="container">
        <main id="loginMain">
            <!-- 로그인 섹션 -->
            <section id="login">
                <!-- 로그인 박스 -->
                <article id="login__form__container">
                    <!-- 로그인 폼 -->
                    <div id="login__form">
                        <h1><img src="/images/logo.jpg" alt=""></h1>

                        <!-- 로그인 인풋 -->
                        <form id="login__input" method="POST">
                            <input type="text" id="email" placeholder="이메일" required="required" />
                            <input type="password" id="pw" placeholder="비밀번호" required="required" />
                            <!-- 버튼에 ID 추가 -->
                            <button id="loginClick">로그인</button>
                        </form>
                        <!-- 로그인 인풋 end -->

                        <!-- 또는 -->
                        <div id="login__horizon">
                            <!-- ID 중복 사용 해결 -->
                            <div class="br"></div>
                            <div class="or">또는</div>
                            <div class="br"></div>
                        </div>
                        <!-- 또는 end -->

                        <!-- Oauth 소셜로그인 -->
                        <div id="login__facebook">
                            <!-- onclick 수정 -->
                            <button onclick="location.href='/oauth2/authorization/facebook'">
                                <!-- 클래스 수정 -->
                                <i class="fab fa-facebook-square"></i>
                                <span>Facebook으로 로그인</span>
                            </button>
                        </div>
                        <!-- Oauth 소셜로그인 end -->
                    </div>

                    <!-- 계정이 없으신가요? -->
                    <div id="login__register">
                        <span>계정이 없으신가요?</span>
                        <a href="/auth/signup">가입하기</a>
                    </div>
                    <!-- 계정이 없으신가요? end -->
                </article>
            </section>
        </main>
    </div>


</body>

</html>

<script>
    $(document).ready(function () {
        oLogin = new login();

        $('#loginClick').click(function () {
            oLogin.loginTry();
        });
    });

    function login() {
        this.loginTry = function () {
            let url = "/auth/login.json";

            let userDTO = {
                email: $('#email').val(),
                pw: $('#pw').val()
            };

            $.ajax({
                type: "POST",
                url: url,
                contentType : 'application/json; charset=utf-8',
                data: JSON.stringify(userDTO),
                success: function (response) {
                    alert(response);
                    console.log(response);
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert("에러: " + textStatus + " " + errorThrown);
                    console.error("에러: " + textStatus, errorThrown);
                }
            });
        };
    }
</script>
