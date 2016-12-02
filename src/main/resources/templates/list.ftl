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
            <#list list.content as item>
            <tr>
                <td>${item.idx}</td>
                <td><a href="view.do?idx=${item.idx}"> ${item.subject}</a></td>
                <td>${item.writer}</td>
            </tr>
            </#list>
            <tr>
                <td colspan="3">
                    <ul class="pager">
                    <#if !list.first>
                        <li class="previous">
                            <a href="?page=${list.number-1}">&larr; 이전페이지</a>
                        </li>
                    </#if>

                    <#if !list.last>
                        <li class="next">
                            <a href="?page=${list.number+1}">다음페이지 &rarr;</a>
                        </li>
                    </#if>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>


    <!-- 합쳐지고 최소화된 최신 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- 부가적인 테마 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>