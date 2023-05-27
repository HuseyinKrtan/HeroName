package djbcPostgreasql;

import java.sql.*;

public class Example2 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yasuo","yasuo_db","yasuo1990");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM sampiyonlar ");

        while (rs.next()){

            System.out.printf("%-10s %-7d %-7d\n",rs.getString("name"),rs.getInt("healt"),rs.getInt("mana"));

        }

        int count=st.executeUpdate("INSERT INTO sampiyonlar VALUES('Kennen',998)");
        System.out.println(count+" veri güncellendi");


        String [] veri = {"INSERT INTO sampiyonlar VALUES('Rumble',1119)",
                "INSERT INTO sampiyonlar VALUES('Pyke',950,440)",
                "INSERT INTO sampiyonlar VALUES('Thresh',1250,480)"};

        int count2=0;
        for (String each:veri) {
            count2+=st.executeUpdate(each);
        }
        System.out.println(count2+" veri guncellendi");





        st.close();
        con.close();

    }









}
