package ru.kfu.itis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

/**
 * Created by mg on 16.11.14.
 */
public class AddServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");
        System.out.println(code);
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        boolean b = false;
        if(code.equals("Добавить книгу")){
            String film = req.getParameter("Film");
            String author = req.getParameter("Author");
            String comment = req.getParameter("Comment");
            int pages = new Integer(req.getParameter("Pages"));
            String company = req.getParameter("Company");
            int year = new Integer(req.getParameter("Year"));
            float cost = new Float(req.getParameter("Cost"));
            boolean cdrom = (req.getParameter("Cdrom").equals("true"))?true:false;
            String INNOfProducer = req.getParameter("INNOfProducer");
            b = GetFromDB.insertIntoBooks(film, author, comment, pages, company, year, cost, cdrom, INNOfProducer);

        }
        if(code.equals("Добавить счет-фактуру")){
            String date = req.getParameter("DateStart");
            String myDate[] = date.split(".");
            date = myDate[2] + "-" + myDate[1] + "-" + myDate[0];

            Date dateStart = Date.valueOf(date);
            String worker = req.getParameter("Worker");
            String plus = req.getParameter("Plus");

            String customerINN = req.getParameter("CustomerINN");

            b = GetFromDB.insertIntoInvoice(dateStart, worker, plus, customerINN);

        }
        if(code.equals("Добавить заказчика")){
            String customer = req.getParameter("Customer");
            boolean customerSign = (req.getParameter("CustomerSign").equals("true"))?true:false;
            String iNNcustomer = req.getParameter("INNCustomer");

            String addressCust = req.getParameter("AddressCust");
            String chief = req.getParameter("Chief");
            String bankCustomer = req.getParameter("BankCustomer");
            String phone = req.getParameter("Phone");
            String district = req.getParameter("District");
            String accountCust = req.getParameter("AccountCust");

            b = GetFromDB.insertIntoCustomer(customer, customerSign, iNNcustomer, addressCust,
                    chief,bankCustomer, phone,district, accountCust);

        }
        if(code.equals("Добавить поставщика")){
            String provider = req.getParameter("Provider");
            String iNN = req.getParameter("INN");

            String address = req.getParameter("Address");
            String bank = req.getParameter("Bank");
            String account = req.getParameter("Account");
            boolean sign = (req.getParameter("Sign").equals("true"))?true:false;
            b = GetFromDB.insertIntoProducer(provider, iNN,address, bank, account, sign);

        }



        if(code.equals("Добавить книгу в счет-фактуру")){
            int bookID = new Integer(req.getParameter("BookID"));
            int countNumber = new Integer(req.getParameter("CountNumber"));

           b =  GetFromDB.insertIntoBooksInInvoice(bookID, countNumber);

        }
//        resp.sendRedirect("index.jsp");
        if(b){
            writer.write("Inserted");
        }else{
            writer.write("Some Error(");
        }

    }
}
