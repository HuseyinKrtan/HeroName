package djbcPostgreasql;

import java.sql.*;

public class Example1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Driver yukleme
        Class.forName("org.postgresql.Driver");

        //2.Baglantı olusturma
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yasuo","yasuo_db","yasuo1990");

        //3.Statement olusturma
        Statement st = con.createStatement();

        //4.Resulset
        ResultSet veri=st.executeQuery("SELECT * FROM sampiyonlar");

        while (veri.next()){

            System.out.println(veri.getString("name")+" "+veri.getInt("healt")+" "+veri.getInt("mana"));

        }

        con.close();
        st.close();
        veri.close();


    }
}

