/*
 * This file is generated by jOOQ.
 */
package com.astroapi.db.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

import com.astroapi.db.tables.Auth;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AuthRecord extends UpdatableRecordImpl<AuthRecord> implements Record3<Integer, String, String> {

    private static final long serialVersionUID = -584681135;

    /**
     * Setter for <code>Java.Auth.id</code>.
     */
    public void setId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>Java.Auth.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>Java.Auth.val</code>.
     */
    public void setVal(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>Java.Auth.val</code>.
     */
    public String getVal() {
        return (String) get(1);
    }

    /**
     * Setter for <code>Java.Auth.email</code>.
     */
    public void setEmail(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>Java.Auth.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Auth.AUTH.ID;
    }

    @Override
    public Field<String> field2() {
        return Auth.AUTH.VAL;
    }

    @Override
    public Field<String> field3() {
        return Auth.AUTH.EMAIL;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getVal();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getVal();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public AuthRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public AuthRecord value2(String value) {
        setVal(value);
        return this;
    }

    @Override
    public AuthRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public AuthRecord values(Integer value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AuthRecord
     */
    public AuthRecord() {
        super(Auth.AUTH);
    }

    /**
     * Create a detached, initialised AuthRecord
     */
    public AuthRecord(Integer id, String val, String email) {
        super(Auth.AUTH);

        set(0, id);
        set(1, val);
        set(2, email);
    }
}