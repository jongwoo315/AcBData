<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>List page parameters</title>
  </head>
  <body>
    You entered the following parameters:<br />
    <ol>
      <%-- 'param' is an implicit object. It is a Map that maps a 'key'
           (the parameter name) to a 'value' --%>
      <c:forEach var="pageParameter" items="${param}">
        <li> <c:out value="${pageParameter.key}" /> = <c:out value="${pageParameter.value}" />
      </c:forEach>
    </ol>
  </body>
</html>