/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DayaListrik;

import Config.Config;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author titam
 */
public class Model {
    
    public ResultSet getAll(){
        try {
            String sql = "select id,daya,golongan_tarif from daya";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            return res;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
    public boolean insert(String daya, String golonganTarif){
        try {
            String sql = "INSERT INTO daya VALUES (NULL, ?,?)";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, daya);
            pst.setString(2, golonganTarif);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            conn.close();
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    public boolean update(String daya, String golonganTarif, String id){
        try {
            String sql = "UPDATE daya SET daya =?, golongan_tarif=? WHERE id=?"; 
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, daya);
            pst.setString(2, golonganTarif);
            pst.setString(3, id);
            pst.execute();
            conn.close();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
            return false;
        }
    }
    
    public boolean delete(String id){
        try {
            String sql ="DELETE FROM daya WHERE id = ?";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1, id);
            pst.execute();
            conn.close();
            JOptionPane.showMessageDialog(null, "berhasil di hapus");
            return true;
        } catch (HeadlessException | SQLException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
