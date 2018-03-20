/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ZeXVex
 */
public class DALController {
    
        private ConnectionManager cm = new ConnectionManager();

       public void attend(Date sqlDate, int id) throws SQLException {
        try (Connection con = cm.getConnection()) {
            String sql
                    = "INSERT INTO Attendance"
                    + "(SId, Date, Present)"
                    + "VALUES(?,?,?)";
            PreparedStatement pstmt
                    = con.prepareStatement(
                            sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, id);
            pstmt.setDate(2, sqlDate);
            pstmt.setBoolean(id, true);
            
            int affected = pstmt.executeUpdate();
            if(affected<1)
                throw new SQLException("Eat a dick");
        }
    }
    
}
