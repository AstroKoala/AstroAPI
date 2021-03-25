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
import com.astroapi.db.tables.records.VerificationRecord;


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
public class Verification extends TableImpl<VerificationRecord> {

    private static final long serialVersionUID = 1394865367;

    /**
     * The reference instance of <code>Java.Verification</code>
     */
    public static final Verification VERIFICATION = new Verification();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VerificationRecord> getRecordType() {
        return VerificationRecord.class;
    }

    /**
     * The column <code>Java.Verification.VerificationID</code>.
     */
    public final TableField<VerificationRecord, Integer> VERIFICATIONID = createField(DSL.name("VerificationID"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Java.Verification.UserEmail</code>.
     */
    public final TableField<VerificationRecord, String> USEREMAIL = createField(DSL.name("UserEmail"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>Java.Verification.VerificationExpiry</code>.
     */
    public final TableField<VerificationRecord, String> VERIFICATIONEXPIRY = createField(DSL.name("VerificationExpiry"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>Java.Verification.VerificationCode</code>.
     */
    public final TableField<VerificationRecord, String> VERIFICATIONCODE = createField(DSL.name("VerificationCode"), org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * Create a <code>Java.Verification</code> table reference
     */
    public Verification() {
        this(DSL.name("Verification"), null);
    }

    /**
     * Create an aliased <code>Java.Verification</code> table reference
     */
    public Verification(String alias) {
        this(DSL.name(alias), VERIFICATION);
    }

    /**
     * Create an aliased <code>Java.Verification</code> table reference
     */
    public Verification(Name alias) {
        this(alias, VERIFICATION);
    }

    private Verification(Name alias, Table<VerificationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Verification(Name alias, Table<VerificationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Verification(Table<O> child, ForeignKey<O, VerificationRecord> key) {
        super(child, key, VERIFICATION);
    }

    @Override
    public Schema getSchema() {
        return Java.JAVA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.VERIFICATION_PRIMARY, Indexes.VERIFICATION_USERID_UNIQUE, Indexes.VERIFICATION_VERIFICATIONCODE_UNIQUE, Indexes.VERIFICATION_VERIFICATIONID_UNIQUE);
    }

    @Override
    public Identity<VerificationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_VERIFICATION;
    }

    @Override
    public UniqueKey<VerificationRecord> getPrimaryKey() {
        return Keys.KEY_VERIFICATION_PRIMARY;
    }

    @Override
    public List<UniqueKey<VerificationRecord>> getKeys() {
        return Arrays.<UniqueKey<VerificationRecord>>asList(Keys.KEY_VERIFICATION_PRIMARY, Keys.KEY_VERIFICATION_VERIFICATIONID_UNIQUE, Keys.KEY_VERIFICATION_USERID_UNIQUE, Keys.KEY_VERIFICATION_VERIFICATIONCODE_UNIQUE);
    }

    @Override
    public Verification as(String alias) {
        return new Verification(DSL.name(alias), this);
    }

    @Override
    public Verification as(Name alias) {
        return new Verification(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Verification rename(String name) {
        return new Verification(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Verification rename(Name name) {
        return new Verification(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
