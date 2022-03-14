package models;

import database.DBCheck;
import database.DBConn;
import database.entities.Contact;
import utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactReadModel {

    List<Contact> list;

    public List<Contact> readContacts() {
        if (DBCheck.isDBExists()) {
            list = readData();
        } else {
            list = null;
        }
        return list;
    }

    private List<Contact> readData() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT id, name, phone FROM " + Constants.TABLE_NAME;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Contact(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("phone")
                        )
                );
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }
    }
}
