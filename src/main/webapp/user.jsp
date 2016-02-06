<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Favorites: testuser</title>
</head>
<body>
<table name="favorites">
    <%
        List<String> favorites = (List<String>) request.getAttribute("favorites");
        for (int i = 0; i < favorites.size(); i++) {
            String favorite = favorites.get(i);
    %>
    <tr>
        <td><%=favorite%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<form method="post" action="addFavorite.do">
    <input name="favorite"/>
    <input type="submit" name="Add favorite"/>
</form>
</body>
</html>
