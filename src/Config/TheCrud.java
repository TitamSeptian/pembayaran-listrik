/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.util.ArrayList;
import java.sql.ResultSet;
/**
 *
 * @author titam
 */
public interface TheCrud{
    public boolean insert(ArrayList data, String table);
    public boolean update(ArrayList data, ArrayList column,  String table, String columnWhere, String where);
    public boolean delete(String table, String column , String where);
    public ResultSet getAll(String table);
}
