<html>
<head>
    <title>${title}</title>
</head>
<body>
    <form name="writeFrom" action="/updateView.do" method="post">
        <table border="1">
            <tbody>
                <tr>
                    <td>글번호</td>
                    <td><input type="text" name="idx" value="${view.idx}" readonly></td>
                </tr>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" name="writer" value="${view.writer}"></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="subject" value="${view.subject}"></td>
                </tr>
                <tr>
                    <td colspan="2">내용</td>
                </tr>
                <tr>
                    <td colspan="2"><textarea rows="5" cols="35" name="content">${view.content}</textarea></td>
                </tr>
                <tr>
                    <td>패스워드 확인(등록시 입력한 패스워드를 입력하세요!)</td>
                    <td><input type="password" name="passwd"></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="수정">
        <a href="delete.do?idx=${view.idx}"><button>삭제</button></a>
        <a href="list.do"><button>리스트</button></a>
    </form>
</body>
</html>