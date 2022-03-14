package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Contact;
import utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ContactAddModel {

    public String addContact(Contact contact) {

        if (DBCheck.isDBExists()) {
            return addData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    private String addData(Contact contact) {

        String sql = "INSERT INTO " + Constants.TABLE_NAME + "(name, phone) VALUES(?, ?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhone());
            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}
