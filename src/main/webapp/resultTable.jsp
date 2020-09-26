<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/header.css" type="text/css"/>
    <link rel="stylesheet" href="css/table.css" type="text/css"/>
    <link rel="stylesheet" href="css/body.css" type="text/css"/>
    <link rel="stylesheet" href="css/footer.css" type="text/css"/>
    <link rel="stylesheet" href="css/returnButton.css" type="text/css"/>
</head>
<body>
<div class="header">
    Web-Programming <br>
    Dzhukashev Daniel P3230 <br>
    Variant 2610
</div>
<div class="table">
    <table>
        <thead id="head">
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Current Time</th>
            <th>Execution Time</th>
            <th>Result</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach var="par" items="${requestScope.row.results}">
                <td>${par}</td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
<div class="justButton">
    <form  action="<%=request.getAttribute("path")%>" method="get">
        <input class="ret-button" type="submit" value="на главную">
    </form>
</div>
<div class="nothing"></div>
<div class="footer">
    <a class="linkBlock" target="_blank" href="https://vk.com/blossompuke"><img src = 'icons/vk.png' alt=""/> VK</a>
    <a class="linkBlock" target="_blank" href="https://instagram.com/belinracle?igshid=jv4ozb3f42km"><img src="icons/inst.png" alt=""/> INSTAGRAM</a>
    <a class="linkBlock" target="_blank" href="https://github.com/Belinracle/WebLab1"><img src = 'icons/git.png' alt=""/> GIT HUB</a>
</div>
</body>
</html>