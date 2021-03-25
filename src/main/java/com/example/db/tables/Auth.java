/*
 * This file is generated by jOOQ.
 */
package com.example.db.tables;


import com.example.db.Indexes;
import com.example.db.Java;
import com.example.db.Keys;
import com.example.db.tables.records.AuthRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Auth extends TableImpl<AuthRecord> {

    private static final long serialVersionUID = -1474071756;

    /**
     * The reference instance of <code>Java.Auth</code>
     */
    public static final Auth AUTH = new Auth();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AuthRecord> getRecordType() {
        return AuthRecord.class;
    }

    /**
     * The column <code>Java.Auth.id</code>.
     */
    public final TableField<AuthRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Java.Auth.val</code>.
     */
    public final TableField<AuthRecord, String> VAL = createField(DSL.name("val"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>Java.Auth.email</code>.
     */
    public final TableField<AuthRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>Java.Auth</code> table reference
     */
    public Auth() {
        this(DSL.name("Auth"), null);
    }

    /**
     * Create an aliased <code>Java.Auth</code> table reference
     */
    public Auth(String alias) {
        this(DSL.name(alias), AUTH);
    }

    /**
     * Create an aliased <code>Java.Auth</code> table reference
     */
    public Auth(Name alias) {
        this(alias, AUTH);
    }

    private Auth(Name alias, Table<AuthRecord> aliased) {
        this(alias, aliased, null);
    }

    private Auth(Name alias, Table<AuthRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Auth(Table<O> child, ForeignKey<O, AuthRecord> key) {
        super(child, key, AUTH);
    }

    @Override
    public Schema getSchema() {
        return Java.JAVA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.AUTH_EMAIL_UNIQUE, Indexes.AUTH_PRIMARY, Indexes.AUTH_UID_UNIQUE);
    }

    @Override
    public Identity<AuthRecord, Integer> getIdentity() {
        return Keys.IDENTITY_AUTH;
    }

    @Override
    public UniqueKey<AuthRecord> getPrimaryKey() {
        return Keys.KEY_AUTH_PRIMARY;
    }

    @Override
    public List<UniqueKey<AuthRecord>> getKeys() {
        return Arrays.<UniqueKey<AuthRecord>>asList(Keys.KEY_AUTH_PRIMARY, Keys.KEY_AUTH_UID_UNIQUE, Keys.KEY_AUTH_EMAIL_UNIQUE);
    }

    @Override
    public Auth as(String alias) {
        return new Auth(DSL.name(alias), this);
    }

    @Override
    public Auth as(Name alias) {
        return new Auth(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Auth rename(String name) {
        return new Auth(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Auth rename(Name name) {
        return new Auth(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
