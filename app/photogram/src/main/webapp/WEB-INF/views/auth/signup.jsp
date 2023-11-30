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
    <div class="container">
        <main class="loginMain">
           <!--회원가입섹션-->
            <section class="login">
                <article class="login__form__container">

                   <!--회원가입 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><img src="/images/logo.jpg" alt=""></h1>
                         <!--로고end-->

                         <!--회원가입 인풋-->
                        <form class="login__input"  action="/auth/signup.json" method="post">
                            <input type="text" id="name" placeholder="이름" required="required"  maxlength="30"/>
                            <input type="password" id="pw" placeholder="패스워드" required="required" />
                            <input type="email" id="email" placeholder="이메일" required="required" />
                            <input type="text" id="tel" placeholder="전화번호" required="required" />
                            <button id = 'signUpClick'>가입</button>
                        </form>
                        <!--회원가입 인풋end-->
                    </div>
                    <!--회원가입 폼end-->

                    <!--계정이 있으신가요?-->
                    <div class="login__register">
                        <span>계정이 있으신가요?</span>
                        <a href="/auth/signin">로그인</a>
                    </div>
                    <!--계정이 있으신가요?end-->

                </article>
            </section>
        </main>
    </div>
</body>

</html>

<script>
    $(document).ready(function () {
        oSignUp = new signup();

        $('#signUpClick').click(function () {
            oSignUp.signupTry();
        });
    });

    function signup() {
        this.signupTry = function () {
            let url = "/auth/signup.json";

            let userDTO = {
                name: $('#name').val(),
                pw: $('#pw').val(),
                email: $('#email').val(),
                tel: $('#tel').val()
            };

            $.ajax({
                type: "POST",
                dataType: "json",
                url: url,
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(userDTO),
                success: function (response) {
                    console.log(JSON.stringify(response, null, 2));
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert("에러: " + textStatus + " " + errorThrown);
                    console.error("에러: " + textStatus, errorThrown);
                }
            });
        };
    }
</script>
