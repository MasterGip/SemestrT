<%@ page import="ru.kfu.itis.GetFromDB" %>
<%--
  Created by IntelliJ IDEA.
  User: mg
  Date: 08.12.14
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> N2</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");%>
    <table>
        <tr>

    <%String[][] table = null;%>
            <td valign="top">
                <p>Поставщики:</p>
<%try{
    table = GetFromDB.getProducerInfoForSecondNumber();
}catch(Exception e){
    e.printStackTrace();
//    System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
        </td>
        <td valign="top">
            <p>Книги:</p>
            <%try{
                table = GetFromDB.getBooksInfoForSecondNumber();
            }catch(Exception e){
                e.printStackTrace();
//                System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
        </td>
        <td valign="top">
            <p>Книги и счета:</p>
            <%try{
                table = GetFromDB.getBooksInInvoiceInfoForSecondNumber();
            }catch(Exception e){
                e.printStackTrace();
//                System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
        </td>
        <td valign="top">
            <p>Счета</p>
            <%try{
                table = GetFromDB.getInvoiceInfoForSecondNumber();
            }catch(Exception e){
                e.printStackTrace();
//                System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
        </td>
        <td valign="top">
            <p>Заказчики:</p>
            <%try{
                table = GetFromDB.getCustomerInfoForSecondNumber();
            }catch(Exception e){
                e.printStackTrace();
//                System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
        </td>
        </tr>
        </table>
<p>N1:</p>
<%try{
    table = GetFromDB.getFirstNumberTableFromSecondSemester();
}catch(Exception e){
    e.printStackTrace();
//    System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
<p>N2:</p>
<%try{
    table = GetFromDB.getSecondNumberTableFromSecondSemester();
}catch(Exception e){
    e.printStackTrace();
//    System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
<p>N3:</p>
<%try{
    table = GetFromDB.getThirdNumberTableFromSecondSemester();
}catch(Exception e){
    e.printStackTrace();
//    System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
<p>N4:</p>
<%try{
    table = GetFromDB.getFourthNumberTableFromSecondSemester();
}catch(Exception e){
    e.printStackTrace();
//    System.out.println(request.getParameter("District") + " " +request.getParameter("DateStart") + " ");
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
