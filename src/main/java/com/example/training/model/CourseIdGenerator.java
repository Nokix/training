package com.example.training.model;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.concurrent.atomic.AtomicLong;

// TODO: Warum erhalte ich hier einen Fehler?
// @GenericGenerator(name = "custom_id_gen", strategy = "com.example.training.model.CourseIdGenerator")
public class CourseIdGenerator implements IdentifierGenerator {
    private static final AtomicLong counter = new AtomicLong(0);

    @Override
    public String generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return "C" + counter.getAndIncrement();
    }
}
