<%--
  Created by IntelliJ IDEA.
  User: staxx6
  Date: 20.02.19
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Hello World!</title>
</head>
<body>
    <h2>Hello World! nosasdasd</h2>
    <security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/system">SysAdmin Meeting</a>
    </p>
    </security:authorize>
    <security:authorize access="hasRole('MANAGER')">
        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
        </p>
    </security:authorize>
    <p>
       <form:form action="${pageContext.request.contextPath}/logout" method="POST">
           <input type="submit" value="Logout" />
       </form:form>
    </p>
    <p>
        User: <security:authentication property="principal.username" />
        <br>
        Role(s): <security:authentication property="principal.authorities" />
    </p>
</body>
</html>
