package com.example.onlineTicket.config.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aman on 7/11/17.
 */
public class SeatIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        String prefix = "seat";
        Connection connection = session.connection();

        try {
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("select count(seat_id) as Id from onlineTicket.seat");

            if (rs.next()) {
                int id = rs.getInt(1) + 101;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
