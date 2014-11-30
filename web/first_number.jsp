<%@ page import="ru.kfu.itis.GetFromDB" %>
<%--
  Created by IntelliJ IDEA.
  User: mg
  Date: 30.11.14
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>N1</title>
</head>
<body>
    <%request.setCharacterEncoding("utf-8");
        String[][] table = null;%>
    <%try{
        table = GetFromDB.getDataForFirstNumber(request.getParameter("District"), request.getParameter("DateStart"));
    }catch(Exception e){
        e.printStackTrace();
        System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
    }
    if(table==null){

    %>
    <p>ВЫ НЕ ЗАДАЛИ ПАРАМЕТРЫ!</p>
    <%}else{

    %>
    <table border="2" bordercolor="#000000">
        <%for(int i = 0; i<table.length; i++){%>
        <tr>
            <%for(int j = 0; j < table[0].length; j++){%>
            <td>
                <%=table[i][j]%>
            </td>
        <%}%>
        </tr>
        <%}%>
    </table>


    <%}%>

</body>
</html>
