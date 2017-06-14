<html>
  <head>
    <title>Set page parameters</title>
  </head>

  <body>
    This page allows you to enter information that is sent as request
    parameters to another page. The next page lists them. <P />

    <form action="b02_listPageParameters.jsp" method="get">
      <table>
        <tr><td>Enter an adjective:</td>
            <td><input type="text" name="adjective" /></td>
        </tr>
        <tr><td>Enter a noun:</td>
            <td><input type="text" name="noun" /></td>
        </tr>
        <tr><td>Enter a color:</td>
            <td><input type="text" name="color" /></td>
        </tr>
      </table>
      
      <input type="submit" value="Send parameters" />
      
    </form>
  </body>
</html>
