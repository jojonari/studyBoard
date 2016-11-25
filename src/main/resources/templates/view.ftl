<html>
<head>
    <title>${title}</title>
</head>
<body>
    <table border="1">
        <tbody>
            <tr>
                <td>글번호</td>
                <td><input type="text" name="idx" value="${view.idx}" readonly></td>
            </tr>
            <tr>
                <td>작성자</td>
                <td><input type="text" name="writer" value="${view.writer}" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="subject" value="${view.subject}" readonly></td>
            </tr>
            <tr>
                <td colspan="2">내용</td>
            </tr>
            <tr>
                <td colspan="2"><textarea rows="5" cols="35" name="content" readonly>${view.content}</textarea></td>
            </tr>

        </tbody>
    </table>

    <a href="modify.do?idx=${view.idx}"><button>수정</button></a>
    <a href="list.do"><button>리스트</button></a>
</body>
</html>