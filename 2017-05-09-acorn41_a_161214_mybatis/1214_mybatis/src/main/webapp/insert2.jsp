<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <center>
        <h2>글 쓰 기 !</h2>
        
        <form method="post" action="insertcomment.jsp">
            <table border="1" width="400">            
                <tr>
                    <th width="80">번호</th>
                    <td align="center"><input type="text" name="commentNo" size="40"/></td>
                </tr>            
                <tr>
                    <th width="80">아이디</th>
                    <td align="center"><input type="text" name="userId" size="40"/></td>
                </tr>
                <tr>
                    <th width="80">내용</th>
                    <td align="center"><input type="text" name="commentContent" size="100"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="right">
                        <input type="submit" value="저장"/>&nbsp;&nbsp;
                    </td>
                </tr>                
            </table>
        </form> <!-- insertcomment  -->
        <br><br>
        <hr>
        <br><br>
        
        <form method="post" action="selectcomment.jsp">
        	<input type="text" name="commentNo">
        	<button type="submit">코멘트보기</button>
        </form>
        <br><br>
        <hr>
        <br><br>

        <form method="post" action="deletecomment.jsp">
        	<input type="text" name="commentNo">        
        	<button type="submit">코멘트삭제</button>
        </form>
        
    </center>
</body>
</html>
