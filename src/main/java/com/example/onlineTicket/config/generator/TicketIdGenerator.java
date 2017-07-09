package com.example.onlineTicket.config.generator;

import java.io.Serializable;
import java.sql.*;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TicketIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException {

        UUID idOne = UUID.randomUUID();
        return idOne;
    }

}