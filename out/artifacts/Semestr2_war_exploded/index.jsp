<%--
  Created by IntelliJ IDEA.
  User: mg
  Date: 16.11.14
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.kfu.itis.GetFromDB"%>
<html>
  <head>
    <title>Добро пожаловать!</title>
  </head>
  <body>
        <%String[] producers = GetFromDB.getINNOfProducers();%>
      <p>Добавить книгу</p>
      <form action="/AddServlet" method="post">
          <p>Название:
              <input type="text" name="Film"></p>
          <p>Автор:
              <input type="text" name= "Author"></p>
          <p>Комментарий:
              <input type = "text" name="Comment"></p>
          <p>Число страниц:
              <input type="number" name= "Pages"></p>
          <p>Издательство:
              <input type="text" name = "Company"></p>
          <p>Год издания:
              <input type="text" name= "Year"></p>
          <p>Цена:
              <input type="number" name="Cost"></p>
          <p>Наличие диска?:
              <input type="radio" name = "Cdrom" value="true"> - Да
              <input type="radio" name="Cdrom" value="false"> - Нет
          </p>
          <p>Поставщик:
              <select name="INNOfProducer">
                  <%for(int i = 0; i < producers.length; i++){%>
                  <option value="<%=producers[i] %>"><%=producers[i]%></option>
                  <%}%>
              </select></p>
          <input type = "submit" name="code" value="Добавить книгу">
      </form>
      <hr/>
      <p>Добавить счет-фактуру</p>
      <form action="/AddServlet" method="post">
          <p>Дата:
              <input type="date" name="DateStart"></p>
          <p>Работник:
              <input type="text" name = "Worker"></p>
          <p>Комментарий:
              <input type = "text" name="Plus"></p>
          <p>ИНН заказчика:
              <input type="text" name = "CustomerINN"></p>

          <input type = "submit" name="code" value="Добавить счет-фактуру">
      </form>
      <hr/>
      <p>Добавить заказчика</p>
      <form action="/AddServlet" method="POST">
          <p>Фамилия Имя:
              <input type="text" name="Customer"></p>
          <p>Юр. лицо?:
              <input type="radio" name = "CustomerSign" value="true"> - Да
              <input type="radio" name="CustomerSign" value="false"> - Нет
          </p>
          <p>ИНН:
              <input type = "text" name="INNcustomer" ></p>
          <p>Юр. адрес:
              <input type="text" name = "AddressCust"></p>
          <p>Директор:
              <input type="text" name = "Chief"></p>
          <p>Банк:
              <input type="text" name = "BankCustomer"></p>
          <p>Телефон:
              <input type="text" name="Phone"></p>
          <p>Район:
              <input type="text" name="District"></p>
          <p>Номер счета в банке:
              <input type="text" name="AccountCust"></p>
          <input type = "submit" name="code" value="Добавить заказчика">
      </form>
      <hr/>
      <p>Добавить поставщика</p>
      <form action="/AddServlet" method="post">
          <p>Название:
              <input type="text" name="Provider"></p>
          <p>ИНН:
              <input type="text" name = "INN"></p>
          <p>Адрес:
              <input type = "text" name="Address"></p>
          <p>Банк:
              <input type="text" name= "Bank"></p>
          <p>Номер счета:
              <input type="text" name = "Account"></p>
          <p>Посредник?:
              <input type="radio" name = "Sign" value="true"> - Да
              <input type="radio" name="Sign" value="false"> - Нет
          </p>

          <input type = "submit" name="code" value="Добавить поставщика">
      </form>
      <hr/>
      <p>Добавить книгу поставщику: </p>
      <%String[] books = GetFromDB.getBooks();%>


      <p>Добавить книгу в счет-фактуру: </p>
      <%String[] countNumbers = GetFromDB.getCountNumbers();%>
      <form action="/AddServlet" method="post">
          <p>Книга:
              <select name="BookID">
                  <%for(int i = 0; i < books.length; i++){%>
                  <option value="<%=books[i].substring(0, books[i].indexOf(" ")) %>"><%=books[i]%></option>
                  <%}%>
              </select></p>

          <p>Номер счета:
              <select name="CountNumber">
                  <%for(int i = 0; i < countNumbers.length; i++){%>
                  <option value="<%=countNumbers[i] %>"><%=countNumbers[i]%></option>
                  <%}%>
              </select></p>
          <input type="submit" name = "code" value="Добавить книгу в счет-фактуру"/>
      </form>
      <hr/>
        <p>Выполнить запрос по первой семестровой: </p>

        <form action="/first_number.jsp" method="post">
            <p>Район:
            <input type="text" name="District"></p>
            <p>Дата:
            <input type="date" name="DateStart"></p>
            <input type="submit" name = "code" value="Сделать первый номер!"/>
        </form>
        <hr/>
  </body>
</html>
