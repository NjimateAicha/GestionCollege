
package com.college.collegemang;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author WINDOWS 10
 */
public class Database {

    public static Connection connectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/university", "root", "aicha");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}