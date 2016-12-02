<html>
<head>
    <title>${title}</title>
</head>
<body>
    <form name="writeFrom" action="/doWrite.do" method="post">
        <table border="1">
            <tbody>
                <tr>
                    <td>작성자</td>
                    <td><input type="text" name="writer"></td>
                </tr>
                <tr>
                    <td>패스워드</td>
                    <td><input type="password" name="passwd"></td>
                </tr>
                <tr>
                    <td>제목</td>
                    <td><input type="text" name="subject"></td>
                </tr>
                <tr>
                    <td colspan="2">내용</td>
                </tr>
                <tr>
                    <td colspan="2"><textarea rows="5" cols="35" name="content"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2">태그</td>
                </tr>
                <tr>
                    <td><input type="text" name="tag"></td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="저장">
        <a href="list.do"><button>리스트</button></a>
    </form>
</body>
</html>