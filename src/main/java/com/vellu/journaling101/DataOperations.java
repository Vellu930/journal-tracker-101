package com.vellu.journaling101;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static jooq.tables.JournalData.JOURNAL_DATA;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.Record;
import org.jooq.impl.DSL;

public class DataOperations extends sqlConnection {

    private DefaultTableModel model;

    public void addNewNote(String date, String day, String title, String mood, String activity, String health, String note, JTable table) {

        if (day.equals("")) {
            day = "0";
        }
        int dayInt = Integer.parseInt(day);

        super.connect();
        DSLContext context = DSL.using(super.con);
        context.insertInto(JOURNAL_DATA,
                JOURNAL_DATA.DATE, JOURNAL_DATA.DAY, JOURNAL_DATA.TITLE, JOURNAL_DATA.MOOD,
                JOURNAL_DATA.ACTIVITY, JOURNAL_DATA.HEALTH, JOURNAL_DATA.NOTE)
                .values(date, dayInt, title, mood, activity, health, note)
                .execute();
        super.disconnect();

        Object[] newRowArray = {date, day, title, note};
        model = (DefaultTableModel) table.getModel();
        model.addRow(newRowArray);
    }

    public void showNotesData(JTable journalDataTb) {

        super.connect();
        DSLContext context = DSL.using(super.con);
        Result<Record> records = context.select().from(JOURNAL_DATA).fetch();

        String[] dataRow = {"date", "day", "title", "note"};

        for (Record rs : records) {
            dataRow[0] = rs.getValue(JOURNAL_DATA.DATE);
            dataRow[1] = String.valueOf(rs.getValue(JOURNAL_DATA.DAY));
            dataRow[2] = rs.getValue(JOURNAL_DATA.TITLE);
            dataRow[3] = rs.getValue(JOURNAL_DATA.NOTE);

            model = (DefaultTableModel) journalDataTb.getModel();
            model.addRow(dataRow);
        }
        super.disconnect();

    }

    void removeRow(JTable table, int index) {
        super.connect();
        DSLContext context = DSL.using(super.con);

        model = (DefaultTableModel) table.getModel();

        // First remove data from sql DB
        String myDate = model.getValueAt(index, 0).toString();
        context.delete(JOURNAL_DATA).where(JOURNAL_DATA.DATE.eq(myDate)).execute();

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
        String query = "SELECT " + columnName + " FROM journal_data WHERE date='" + myDate + "';";

        try {
            ResultSet rset = null;
            Statement st2 = con.createStatement();
            rset = st2.executeQuery(query);
            itemStr = rset.getString(columnName);
            st2.close();
            rset.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            super.disconnect();
        }
        return itemStr;
    }

    void updateRow(String dateStr, String dayStr, String titleStr, String moodStr, String activityStr, String healthStr, String noteStr, int index, JTable tb) {
        if (dayStr.equals("")) {
            dayStr = "0";
        }
        int dayInt = Integer.parseInt(dayStr);

        model = (DefaultTableModel) tb.getModel();
        String myDate = model.getValueAt(index, 0).toString();
        
        super.connect();
        DSLContext context = DSL.using(super.con);
        
        context.update(JOURNAL_DATA)
                .set(JOURNAL_DATA.DAY, dayInt)
                .set(JOURNAL_DATA.TITLE, titleStr)
                .set(JOURNAL_DATA.MOOD, moodStr)
                .set(JOURNAL_DATA.ACTIVITY, activityStr)
                .set(JOURNAL_DATA.HEALTH, healthStr)
                .set(JOURNAL_DATA.NOTE, noteStr)
                .where(JOURNAL_DATA.DATE.eq(myDate))
                .execute();
        
        super.disconnect();
    }

}
