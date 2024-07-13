

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Order Details</h2>
        <table border="1px">
            <tr>
                <th>ProductId</th>
                <th>ProductName</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${requestScope.olList}" var="o">
                <tr>
                    <td>${o.pid}</td>
                    <td>${o.pName}</td>
                    <td>${o.quantity}</td>
                    <td>${o.price}</td>
                </tr>
            </c:forEach>
        </table>
        Total Price: ${requestScope.total}
    </body>
</html>
