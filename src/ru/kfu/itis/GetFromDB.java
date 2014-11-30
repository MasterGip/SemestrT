package ru.kfu.itis;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by mg on 17.11.14.
 */
public class GetFromDB {

    public static String[] getBooks(){
        ArrayList<String> returningList = new ArrayList<String>();
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "SELECT * FROM Books";
//        PreparedStatement preparedStatement;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            Statement statement = connection.createStatement();
            res = statement.executeQuery(temp);
            while(res.next()){
               returningList.add(res.getInt("id") + " " + res.getString("Film") + " "
                + res.getString("Author") + " " + res.getString("Company") +
                    " " + res.getInt("Year") + ",Цена: " + res.getString("Cost"));

            }


            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String[] strings = new String[returningList.size()];
        for(int i = 0; i < strings.length; i++){
            strings[i] = returningList.get(i);
        }

        return strings;
    }

    public static String[] getINNOfProducers(){
        ArrayList<String> returningList = new ArrayList<String>();
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "SELECT INN FROM Producer";
//        PreparedStatement preparedStatement;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            Statement statement = connection.createStatement();
            res = statement.executeQuery(temp);
            while(res.next()){
                returningList.add(res.getString("INN"));

            }


            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String[] strings = new String[returningList.size()];
        for(int i = 0; i < strings.length; i++){
            strings[i] = returningList.get(i);
        }
        return strings;
    }

    public static String[] getCountNumbers(){
        ArrayList<String> returningList = new ArrayList<String>();
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "SELECT CountNumber FROM Invoice";
//        PreparedStatement preparedStatement;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            Statement statement = connection.createStatement();
            res = statement.executeQuery(temp);
            while(res.next()){
                returningList.add(res.getString("CountNumber"));

            }


            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String[] strings = new String[returningList.size()];
        for(int i = 0; i < strings.length; i++){
            strings[i] = returningList.get(i);
        }
        return strings;
    }

    public static boolean insertIntoBooks(String film, String author, String
                                       comment, int pages, String company,
                                       int year, float cost, boolean cdrom, String INNOfProducer){
        boolean b = false;
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "INSERT INTO Books(Film, Author, Comment, Pages, Company," +
                "Year, Cost, Cdrom, INNOfProducer) VALUES (?,?,?,?,?,?,?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(temp);

            preparedStatement.setString(1, film);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, comment);
            preparedStatement.setInt(4, pages);
            preparedStatement.setString(5, company);
            preparedStatement.setInt(6, year);
            preparedStatement.setFloat(7, cost);
            preparedStatement.setBoolean(8, cdrom);
            preparedStatement.setString(9, INNOfProducer);
            b = preparedStatement.execute();
            System.out.println("!!!!");

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean insertIntoBooksInInvoice(int bookID, int countNumber){
        boolean b = false;
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "INSERT INTO Books_in_invoice VALUES (?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(temp);

            preparedStatement.setInt(1, bookID);
            preparedStatement.setInt(2, countNumber);

            b = preparedStatement.execute();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean insertIntoBooksOfProducers(String producerINN, int id){
        boolean b = false;
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "INSERT INTO Books_of_Producers VALUES (?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(temp);

            preparedStatement.setString(1, producerINN);
            preparedStatement.setInt(2, id);

            b = preparedStatement.execute();
            //RUSSIANWORD.NET
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean insertIntoCustomer(String customer, boolean customerSign,
                        String iNNcustomer, String addressCust, String chief,
                        String bankCustomer, String phone, String district,
                        String accountCust){
        boolean b = false;
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "INSERT INTO Customer VALUES (?,?,?,?,?,?,?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(temp);

            preparedStatement.setString(1, customer);
            preparedStatement.setBoolean(2, customerSign);
            preparedStatement.setString(3, iNNcustomer);
            preparedStatement.setString(4, addressCust);
            preparedStatement.setString(5, chief);
            preparedStatement.setString(6, bankCustomer);
            preparedStatement.setString(7, phone);
            preparedStatement.setString(8, district);
            preparedStatement.setString(9, accountCust);
            b = preparedStatement.execute();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean insertIntoInvoice(Date dateStart,
                                         String worker, String plus,
                                         String customerINN){
        boolean b = false;
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "INSERT INTO Invoice(DateStart, Worker, Plus, CustomerINN)" +
                " VALUES (?,?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(temp);

            preparedStatement.setDate(1, dateStart);
            preparedStatement.setString(2, worker);
            preparedStatement.setString(3, plus);
            preparedStatement.setString(4, customerINN);


            b = preparedStatement.execute();

            //hibernate
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static boolean insertIntoProducer(String provider, String iNN,
                                          String address, String bank, String account,
                                          boolean sign){
        boolean b = false;
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;;
        ResultSet res;
        String temp = "INSERT INTO Producer VALUES (?,?,?,?,?,?)";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(temp);

            preparedStatement.setString(1, provider);
            preparedStatement.setString(2, iNN);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, bank);
            preparedStatement.setString(5, account);
            preparedStatement.setBoolean(6, sign);

            b = preparedStatement.execute();

            //hibernate
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return b;
    }

    public static String[][] getDataForFirstNumber(String district, String date){

        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        String[] yearMonthDay = date.split("-");
        date = yearMonthDay[2] + "-" + yearMonthDay[1] + "-" + yearMonthDay[0];
        String url = "jdbc:mysql://localhost:3306/BooksDB";
        Connection connection = null;

        String query = "SELECT DISTINCT t2.CountNumber, `DateStart`, `Value`, " +
                "`Worker`, `Tax`, `Plus`, `CustomerINN` " +
                "FROM (SELECT INNcustomer FROM Customer WHERE District = ? ) AS t1 " +
                "INNER JOIN (SELECT * FROM Invoice WHERE DateStart> ? ) AS t2 " +
                "ON t1.INNcustomer=t2.CustomerINN INNER JOIN Books_in_invoice ON Books_in_invoice.CountNumber=t2.CountNumber " +
                "INNER JOIN (SELECT id FROM Books WHERE Cdrom=true) AS t3 ON Books_in_invoice.BookID=t3.id";
        try{
            System.out.println("!!!");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            System.out.println("!!");
            preparedStatement.setString(1, district);
            preparedStatement.setString(2, date);
            System.out.println("!");
            ResultSet resultSet = preparedStatement.executeQuery();

            list = new ArrayList<ArrayList<String>>();
            ArrayList<String> listFromOneCortege = new ArrayList<String>();
            listFromOneCortege.add("CountNumber");
            listFromOneCortege.add("DateStart");
            listFromOneCortege.add("Value");
            listFromOneCortege.add("Worker");
            listFromOneCortege.add("Tax");
            listFromOneCortege.add("Plus");
            listFromOneCortege.add("CustomerINN");
            list.add(listFromOneCortege);
            while(resultSet.next()){
                listFromOneCortege = new ArrayList<String>();
                //System.out.println(resultSet.getInt("CountNumber"));
                for(int i = 1; i <= 7; i++){
                    listFromOneCortege.add(resultSet.getString(i));
                }
                list.add(listFromOneCortege);

            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String[][] returning = null;
        try{
            returning = new String[list.size()][list.get(0).size()];
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < list.get(0).size(); j++){
                    returning[i][j] = list.get(i).get(j);
                }
            }
        }catch (Exception e){

        }

        return returning;
    }

//    public static void makeNum(Date date, String dist){
//        ArrayList<String> returningList = new ArrayList<String>();
//        String url = "jdbc:mysql://localhost:3306/BooksDB";
//        Connection connection;
//        ResultSet res;
//        String temp = "SELECT * FROM (SELECT * FROM Invoice WHERE DateStart>? " +
//                "   INNER JOIN (SELECT * FROM (SELECT * FROM Customer" +
//                " WHERE District=?) AS t3 INNER JOIN Invoice ON Invoice.CustomerINN = t3.INNcustomer) AS t4 " +
//                "INNER JOIN (SELECT CountNumber FROM Books_in_invoice INNER JOIN " +
//                " (SELECT id FROM Books WHERE Cdrom='true') AS t1 ON Books_in_invoice.BookID=" +
//                " t1.id) AS t2 ON t2.CountNumber = t4.CountNumber)";
////        PreparedStatement preparedStatement;
//        try{
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            connection = DriverManager.getConnection(url, "user", "password");
//            Statement statement = connection.createStatement();
//            res = statement.executeQuery(temp);
//            while(res.next()){
//                returningList.add(res.getInt("id") + " " + res.getString("Film") + " "
//                        + res.getString("Author") + " " + res.getString("Company") +
//                        " " + res.getInt("Year"));
//
//            }
//
//
//            //hibernate
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        String[] strings = new String[returningList.size()];
//        for(int i = 0; i < strings.length; i++){
//            strings[i] = returningList.get(i);
//        }
//        return strings;
//    }
}
