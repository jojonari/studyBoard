<html>
<head>
    <title>${title}</title>
</head>
<body>
    <a href="writeInit.do"><button >새글</button></a>
    <table border="1">
        <thead>
            <tr>
                <td>no.</td>
                <td width="150">제목</td>
                <td>글쓴이</td>
            </tr>
        </thead>
        <tbody>
            <#list list as item>
            <tr>
                <td>${item.idx}</td>
                <td><a href="view.do?idx=${item.idx}"> ${item.subject}</a></td>
                <td>${item.writer}</td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>