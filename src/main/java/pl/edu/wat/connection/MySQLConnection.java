package pl.edu.wat.connection;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import pl.edu.wat.model.Zolnierz;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {

    private Statement stmt;
    private Connection conn;

    public MySQLConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://sql.morisson.nazwa.pl:3306/morisson_1", "morisson_1", "Dupa1234");
            stmt = (Statement) conn.createStatement();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Zolnierz z) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://sql.morisson.nazwa.pl:3306/morisson_1", "morisson_1", "Dupa1234");
            stmt = (Statement) conn.createStatement();
            int id = z.getId_zolnierza();
            boolean l4 = z.isL4();
            boolean szpital = z.isSzpital();
            boolean przepustka = z.isPrzepustka();
            boolean sluzba = z.isSluzba();
            stmt.executeUpdate("UPDATE Zolnierz SET l4=" + (l4 ? 1 : 0) + ", szpital=" + (szpital ? 1 : 0) + ", przepustka=" + (przepustka ? 1 : 0) + ", sluzba=" + (sluzba ? 1 : 0) + " WHERE id_zolnierza=" + id);
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Zolnierz> getAllData() {
        ArrayList<Zolnierz> list = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Zolnierz");
            while (rs.next()) {
                Zolnierz zolnierz = new Zolnierz();
                zolnierz.setId_zolnierza(rs.getInt("id_zolnierza"));
                zolnierz.setImie(rs.getString("imie"));
                zolnierz.setNazwisko(rs.getString("nazwisko"));
                zolnierz.setStopien(rs.getString("stopien"));
                zolnierz.setDruzyna(rs.getInt("druzyna"));
                zolnierz.setFunkcja(rs.getString("funkcja"));
                zolnierz.setGrupa_szkoleniowa(rs.getString("grupa_szkoleniowa"));
                zolnierz.setKompania(rs.getInt("kompania"));
                zolnierz.setL4(rs.getBoolean("l4"));
                zolnierz.setPluton(rs.getInt("pluton"));
                zolnierz.setPrzepustka(rs.getBoolean("przepustka"));
                zolnierz.setSluzba(rs.getBoolean("sluzba"));
                zolnierz.setSzpital(rs.getBoolean("szpital"));
                zolnierz.setWydzial(rs.getString("wydzial"));
                list.add(zolnierz);
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
