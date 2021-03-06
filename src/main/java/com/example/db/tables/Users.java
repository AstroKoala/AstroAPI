/*
 * This file is generated by jOOQ.
 */
package com.example.db.tables;


import com.example.db.Indexes;
import com.example.db.Java;
import com.example.db.Keys;
import com.example.db.tables.records.UsersRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
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
public class Users extends TableImpl<UsersRecord> {

    private static final long serialVersionUID = -1155160187;

    /**
     * The reference instance of <code>Java.Users</code>
     */
    public static final Users USERS = new Users();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UsersRecord> getRecordType() {
        return UsersRecord.class;
    }

    /**
     * The column <code>Java.Users.id</code>.
     */
    public final TableField<UsersRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Java.Users.last_name</code>.
     */
    public final TableField<UsersRecord, String> LAST_NAME = createField(DSL.name("last_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("n/a", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Java.Users.first_name</code>.
     */
    public final TableField<UsersRecord, String> FIRST_NAME = createField(DSL.name("first_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("n/a", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Java.Users.email</code>.
     */
    public final TableField<UsersRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("n/a", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Java.Users.age</code>.
     */
    public final TableField<UsersRecord, Integer> AGE = createField(DSL.name("age"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>Java.Users.verified</code>.
     */
    public final TableField<UsersRecord, Byte> VERIFIED = createField(DSL.name("verified"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>Java.Users.user_name</code>.
     */
    public final TableField<UsersRecord, String> USER_NAME = createField(DSL.name("user_name"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false).defaultValue(org.jooq.impl.DSL.inline("n/a", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * Create a <code>Java.Users</code> table reference
     */
    public Users() {
        this(DSL.name("Users"), null);
    }

    /**
     * Create an aliased <code>Java.Users</code> table reference
     */
    public Users(String alias) {
        this(DSL.name(alias), USERS);
    }

    /**
     * Create an aliased <code>Java.Users</code> table reference
     */
    public Users(Name alias) {
        this(alias, USERS);
    }

    private Users(Name alias, Table<UsersRecord> aliased) {
        this(alias, aliased, null);
    }

    private Users(Name alias, Table<UsersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Users(Table<O> child, ForeignKey<O, UsersRecord> key) {
        super(child, key, USERS);
    }

    @Override
    public Schema getSchema() {
        return Java.JAVA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USERS_EMAIL_UNIQUE, Indexes.USERS_ID_UNIQUE, Indexes.USERS_PRIMARY, Indexes.USERS_USER_NAME_UNIQUE);
    }

    @Override
    public Identity<UsersRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USERS;
    }

    @Override
    public UniqueKey<UsersRecord> getPrimaryKey() {
        return Keys.KEY_USERS_PRIMARY;
    }

    @Override
    public List<UniqueKey<UsersRecord>> getKeys() {
        return Arrays.<UniqueKey<UsersRecord>>asList(Keys.KEY_USERS_PRIMARY, Keys.KEY_USERS_ID_UNIQUE, Keys.KEY_USERS_EMAIL_UNIQUE, Keys.KEY_USERS_USER_NAME_UNIQUE);
    }

    @Override
    public Users as(String alias) {
        return new Users(DSL.name(alias), this);
    }

    @Override
    public Users as(Name alias) {
        return new Users(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(String name) {
        return new Users(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Users rename(Name name) {
        return new Users(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, Integer, Byte, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
