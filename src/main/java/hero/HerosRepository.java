package hero;

import java.sql.*;

//DB ye baglanacak olan sınıf:Connection,Statement,PreparedStatement
public class HerosRepository {
    private Connection con;

    private Statement st;

    private PreparedStatement prst;


    //1-connection olusturma icin method
    private void setConnection() {

        try {
            this.con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/yasuo", "yasuo_db", "yasuo1990");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    //2-statement olusturmak icin method

    private void setStatement() {

        try {
            this.st = con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    //3-preaparedStatement olusturmak icin method
    private void setPreparedStatement(String query) {

        try {
            this.prst = con.prepareStatement(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    //4-tablo olusturma

    public void createTable() {
        setConnection();
        setStatement();

        try {
            st.execute("CREATE TABLE IF NOT EXISTS hero  ( name varchar(30) UNIQUE NOT NULL CHECK(LENGTH(name)>0) ," +
                    " healt int NOT NULL," +
                    " mana int NOT NULL " +
                    " )");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        }


    }

    //9-Tabloya kayıt ekleme
    public void save(Heros newheroes) {
        String sql = "INSERT INTO hero (name,healt,mana)VALUES (?,?,?)";
        setConnection();
        setPreparedStatement(sql);
        try {
            prst.setString(1, newheroes.getName());
            prst.setInt(2, newheroes.getHealt());
            prst.setInt(3, newheroes.getMana());
            prst.executeUpdate();
            System.out.println("Hero basarıyla eklendi....");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
                prst.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //11-tablodaki tum fieldları getirip yazdırma
    public void getAll() {
        String sql = "SELECT * FROM hero";
        setConnection();
        setStatement();
        System.out.println("================  Tum Herolar  ======================");
        try {
            ResultSet veri = st.executeQuery(sql);
            while (veri.next()) {
                System.out.println("name : " + veri.getString("name") +
                        "     healt : " + veri.getInt("healt") +
                        "     mana " + veri.getInt("mana"));
                System.out.println();

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }


    //14=isim tabloda  var mı VARSA GUNCELLE
    public void isEqual(String name) {

        String sql = "SELECT name FROM hero WHERE name='" + name + "'";
        setConnection();
        setStatement();

        try {
            int count = 0;
            ResultSet veri = st.executeQuery(sql);
            while (veri.next()) {
                count++;
            }

            if (count > 0) {
                ResultSet veri1 = st.executeQuery(sql);
                while (veri1.next()) {
                    String eskiname = veri1.getString("name");

                    System.out.println(name + " isimli heronun guncellemek ıstedıgınız adını giriniz.");
                    String newName = Depo.input.next();
                    System.out.println(name + " isimli heronun guncellemek ıstedıgınız healt' ini giriniz.");
                    int newHealt = Depo.input.nextInt();
                    System.out.println(name + " isimli heronun guncellemek ıstedıgınız mana' sini giriniz.");
                    int newMana = Depo.input.nextInt();
                    String query = "UPDATE hero SET name='" + newName + "'" + ",healt=" + newHealt + ",mana=" + newMana + " WHERE name='" + eskiname + "'";
                    int count2 = st.executeUpdate(query);
                    System.out.println(count2 + " adet kayit hero guncellendi");


                }


            } else {
                System.out.println("Boyle bir Hero tabloda bulunmamaktadir...");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    }

    public void deleteName(String name) {
        String sql = "SELECT name FROM hero WHERE name='" + name + "'";
        setConnection();
        setStatement();

        try {
            int count = 0;
            ResultSet veri = st.executeQuery(sql);
            while (veri.next()) {
                count++;
            }

            if (count > 0) {
                String query="DELETE FROM hero WHERE name='"+name+"'";
                int count2 = st.executeUpdate(query);
                System.out.println(count2+" adet hero silindi ismi "+name);


            } else {
                System.out.println("Boyle bir Hero tabloda bulunmamaktadir...");

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }





    }









}