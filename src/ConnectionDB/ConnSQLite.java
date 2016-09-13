/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionDB;

import Objects.TableStructure;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pallas
 */
public class ConnSQLite {

    private Connection connection;
    private Statement st;

    public ConnSQLite() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:RestorantManagmentSystem.sqlite";
            connection = DriverManager.getConnection(url);
            st = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error baglanti :" + e);
        }
    }
    
    
    //------------------------------------------------------------------------------      
    
    
    public void InsertUpdateTableStructure(TableStructure t) {
        try {
            String SqlEmri = "";
            if (t.idTableStructure == 0) {
                SqlEmri = "insert into TableStructure (Name, Status) values("
                        + "'" + t.Name + "',"
                        + "'" + t.Status + "')";
            } else {
                SqlEmri = "update TableStructure set "
                        + "'Name='" + t.Name + "',"
                        + "'Status='" + t.Status + "'"
                        + " where idTableStructure=" + t.idTableStructure;
            }

            st.execute(SqlEmri);

        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    private List<TableStructure> AllTableStructure(String where) {
        try {
            String SqlEmri = "select * from TableStructure " + where;
            List<TableStructure> list = new ArrayList<>();
            ResultSet rs = st.executeQuery(SqlEmri);
            while (rs.next()) {
                list.add(new TableStructure(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e+"sdaf");
            return null;
        }
    }

    public List<TableStructure> GetAllTableStructure() {
        return AllTableStructure("");
    }

    public TableStructure GetTableStructurebyid(int idTableStructure) {
        return AllTableStructure("where idTableStructure=" + idTableStructure).get(0);
    }

    //------------------------------------------------------------------------------  
}
