
package com.vellu.journaling101;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataOperations extends sqlConnection {
    
    private DefaultTableModel model;
    
    public void addNewNote(String date, String day, String title, String mood, String activity, String health, String note, JTable table) {
        super.connect();
        
        PreparedStatement pst = null;
        if (day.equals(""))
            day = "0";
        int dayInt = Integer.parseInt(day);
        try {
            String query = "INSERT INTO  journal_data (date, day, title, mood, activity, health, note) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setString(1, date);
            pst.setInt(2, dayInt);
            pst.setString(3, title);
            pst.setString(4, mood);
            pst.setString(5, activity);
            pst.setString(6, health);
            pst.setString(7, note);
            pst.executeUpdate();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
        finally {
            super.disconnect();
        }
        
        Object [] newRowArray = {date, day, title, note};
        model = (DefaultTableModel) table.getModel();
        model.addRow(newRowArray);
    }
    
    
    public void showNotesData(JTable journalDataTb) {
        
        super.connect();
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM journal_data";
            Statement stat = con.createStatement();
            rs = stat.executeQuery(query);
            String [] dataRow = {"date", "day", "title", "note"};
            
            while (rs.next()) {
                dataRow[0] = rs.getString("date");
                dataRow[1] = String.valueOf(rs.getInt("day"));
                dataRow[2] = rs.getString("title");
                dataRow[3] = rs.getString("note");
                
                
                model = (DefaultTableModel) journalDataTb.getModel();
                model.addRow(dataRow);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally {
            try {
                rs.close();
                stat.close();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            
        super.disconnect();
        }
    }

    void removeRow(JTable table, int index) {
        super.connect();
        
        model = (DefaultTableModel) table.getModel();
       
       // first remove data from sql DB
        String myDate = model.getValueAt(index, 0).toString();
        String query = "DELETE FROM journal_data WHERE date=?";
        try {
            PreparedStatement prepstat = con.prepareStatement(query);
            prepstat.setString(1, myDate);
            prepstat.executeUpdate();
            prepstat.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
       // remove data from JTable
        model.removeRow(index);
        
        super.disconnect();
    }

    // Returns value from database based on selected row(date) in JTable
    String getItem(int index, String columnName, JTable table) {
        super.connect();
        String itemStr = null;
        model = (DefaultTableModel) table.getModel();
        String myDate = model.getValueAt(index, 0).toString();
        String query = "SELECT " +columnName+ " FROM journal_data WHERE date='" +myDate+ "';";

        try {
            ResultSet rset = null;
            Statement st2 = con.createStatement();
            rset = st2.executeQuery(query);
            itemStr = rset.getString(columnName);
            st2.close();
            rset.close();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally {
            super.disconnect();
        }
        return itemStr;
    }

    void updateRow(String dateStr, String dayStr, String titleStr, String moodStr, String activityStr, String healthStr, String noteStr, int index, JTable tb) {
        super.connect();
        if (dayStr.equals(""))
            dayStr = "0";
        int dayInt = Integer.parseInt(dayStr);

        model = (DefaultTableModel) tb.getModel();
        String myDate = model.getValueAt(index, 0).toString();
        String query = "UPDATE journal_data "+ 
                "SET date=" +dateStr+ ", day= " +dayInt+ ", title="+titleStr+","+ 
                "mood=" +moodStr+ ", activity=" +activityStr+ ","+
                "health=" +healthStr+ ", note=" +noteStr+ " WHERE date="+myDate;
        
        try {            
            Statement st3 = con.createStatement();
            st3.executeUpdate(query);
            st3.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally {
            super.disconnect();
        }
    }

   
    
}
