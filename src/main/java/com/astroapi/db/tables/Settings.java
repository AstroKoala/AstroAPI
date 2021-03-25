/*
 * This file is generated by jOOQ.
 */
package com.astroapi.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import com.astroapi.db.Indexes;
import com.astroapi.db.Java;
import com.astroapi.db.Keys;
import com.astroapi.db.tables.records.SettingsRecord;


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
public class Settings extends TableImpl<SettingsRecord> {

    private static final long serialVersionUID = -1599004686;

    /**
     * The reference instance of <code>Java.Settings</code>
     */
    public static final Settings SETTINGS = new Settings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<SettingsRecord> getRecordType() {
        return SettingsRecord.class;
    }

    /**
     * The column <code>Java.Settings.id</code>.
     */
    public final TableField<SettingsRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Java.Settings.userId</code>.
     */
    public final TableField<SettingsRecord, Integer> USERID = createField(DSL.name("userId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>Java.Settings.show_own_posts_in_feed</code>.
     */
    public final TableField<SettingsRecord, Byte> SHOW_OWN_POSTS_IN_FEED = createField(DSL.name("show_own_posts_in_feed"), org.jooq.impl.SQLDataType.TINYINT.nullable(false).defaultValue(org.jooq.impl.DSL.inline("1", org.jooq.impl.SQLDataType.TINYINT)), this, "");

    /**
     * The column <code>Java.Settings.email</code>.
     */
    public final TableField<SettingsRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>Java.Settings</code> table reference
     */
    public Settings() {
        this(DSL.name("Settings"), null);
    }

    /**
     * Create an aliased <code>Java.Settings</code> table reference
     */
    public Settings(String alias) {
        this(DSL.name(alias), SETTINGS);
    }

    /**
     * Create an aliased <code>Java.Settings</code> table reference
     */
    public Settings(Name alias) {
        this(alias, SETTINGS);
    }

    private Settings(Name alias, Table<SettingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Settings(Name alias, Table<SettingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Settings(Table<O> child, ForeignKey<O, SettingsRecord> key) {
        super(child, key, SETTINGS);
    }

    @Override
    public Schema getSchema() {
        return Java.JAVA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.SETTINGS_EMAIL_UNIQUE, Indexes.SETTINGS_PRIMARY);
    }

    @Override
    public Identity<SettingsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_SETTINGS;
    }

    @Override
    public UniqueKey<SettingsRecord> getPrimaryKey() {
        return Keys.KEY_SETTINGS_PRIMARY;
    }

    @Override
    public List<UniqueKey<SettingsRecord>> getKeys() {
        return Arrays.<UniqueKey<SettingsRecord>>asList(Keys.KEY_SETTINGS_PRIMARY, Keys.KEY_SETTINGS_EMAIL_UNIQUE);
    }

    @Override
    public Settings as(String alias) {
        return new Settings(DSL.name(alias), this);
    }

    @Override
    public Settings as(Name alias) {
        return new Settings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Settings rename(String name) {
        return new Settings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Settings rename(Name name) {
        return new Settings(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, Byte, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}