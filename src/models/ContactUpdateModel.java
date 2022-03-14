package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Contact;
import utils.Constants;
import utils.IdChecker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContactUpdateModel {

    public String updateContact(Contact contact) {
        if (DBCheck.isDBExists()) {
            return updateData(contact);
        } else {
            return Constants.DB_ABSENT_MSG;
        }
    }

    private String updateData(Contact contact) {

        if (IdChecker.isIdExists(contact)) {

            String sql = "UPDATE " + Constants.TABLE_NAME + " SET phone = ? WHERE id = ?";
            try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
                pstmt.setString(1, contact.getPhone());
                pstmt.setInt(2, contact.getId());
                pstmt.executeUpdate();
                return Constants.DATA_UPDATE_MSG;
            } catch (SQLException e) {
                return e.getMessage();
            }
        } else {
            return Constants.ID_NO_EXISTS_MSG;
        }
    }
}
