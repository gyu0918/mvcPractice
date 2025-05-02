<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
    <h1>회원가입</h1>
    <form id="registerForm">
        <input type="text" id="name" placeholder="이름" required><br>
        <input type="email" id="email" placeholder="이메일" required><br>
        <input type="password" id="password" placeholder="비밀번호" required><br>
        <button type="submit">회원가입</button>
    </form>

    <script>
        const form = document.getElementById('registerForm');

        form.addEventListener('submit', function(event) {
            event.preventDefault(); // 폼 기본 제출 막기

            const name = document.getElementById('name').value;
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const data = {
                name: name,
                email: email,
                password: password
            };

            fetch("register", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.text())
            .then(result => {
                alert(result); // "회원가입 완료!" 출력
            })
            .catch(error => {
                console.error('에러 발생:', error);
            });
        });
    </script>
</body>
</html>
    