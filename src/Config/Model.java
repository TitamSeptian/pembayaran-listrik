/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Config.Config;
import Config.TheCrud;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author titam
 */
public class Model implements TheCrud{
    
    @Override
    public boolean insert(ArrayList data, String table){
        try{
            int length = data.size();
            String query = "INSERT INTO "+table+" VALUES(";
            for(int i=0; i<length; i++){
                query += "'"+data.get(i)+"'";
                if(i<length-1){
                    query += ",";
                }
            }
            query += ")";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
            System.out.print(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            conn.close();
            return true;
        }catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    @Override
    public ResultSet getAll(String table){
        try{
            String query = "SELECT * FROM "+table;
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            return rs;
        }catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(ArrayList data, ArrayList Column, String table, String columnWhere, String where) {
        try{
            int length = data.size();
            String query = "UPDATE "+table+" SET ";
            for(int i=0; i<length; i++){
                query += Column.get(i)+"='"+data.get(i)+"'";
                if(i<length-1){
                    query += ",";
                }
            }
            query += " WHERE "+columnWhere+"='"+where+"'";
//            System.out.print(query);
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Perubahan Data Berhasil");
            conn.close();
            return true;
        }catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String table,String column, String where) {
        try{
            String query = "DELETE FROM "+table+" WHERE "+ column +"='"+where+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penghapusan Data Berhasil");
            conn.close();
            return true;
        }catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

    @Override
    public ResultSet getDataById(String table, String column, String where){
        try{
            String query = "SELECT * FROM "+table+" WHERE "+column+"='"+where+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            return rs;
        }catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public boolean insertSet(ArrayList data, ArrayList column, String table){
        try{
            int length = data.size();
            String query = "INSERT INTO "+table+" (";
            for(int i=0; i<length; i++){
                query += column.get(i);
                if(i<length-1){
                    query += ",";
                }
            }
            query += ") VALUES(";
            for(int i=0; i<length; i++){
                query += "'"+data.get(i)+"'";
                if(i<length-1){
                    query += ",";
                }
            }
            query += ")";
            System.out.println(query);
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            conn.close();
            return true;
        }catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }

}
