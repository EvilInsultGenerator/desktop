/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbc;

import com.models.Languages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Niyaz-laptop
 */
public class DBConnection {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public Connection connected() {

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:evilInsult.sqlite");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {

            return null;
        }
    }

    public void disconnect() {
        try {
            conn.close();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public List<Languages> listLanguages() {

        try {
            List<Languages> list = new ArrayList<>();
            ps = connected().prepareStatement("SELECT * FROM languages");
            rs = ps.executeQuery();

            Languages s;
            while (rs.next()) {
                s = new Languages();
                s.setId(rs.getInt("id"));
                s.setLang(rs.getString("short_lang"));
                s.setFullLanguage(rs.getString("full_lang"));

                list.add(s);
            }
            return list;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {

            return null;
        } finally {
            disconnect();
        }
    }

}
