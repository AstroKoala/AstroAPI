/*
 * This file is generated by jOOQ.
 */
package com.astroapi.db.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import com.astroapi.db.Indexes;
import com.astroapi.db.Java;
import com.astroapi.db.Keys;
import com.astroapi.db.tables.records.PostsRecord;


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
public class Posts extends TableImpl<PostsRecord> {

    private static final long serialVersionUID = 1338664614;

    /**
     * The reference instance of <code>Java.Posts</code>
     */
    public static final Posts POSTS = new Posts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostsRecord> getRecordType() {
        return PostsRecord.class;
    }

    /**
     * The column <code>Java.Posts.id</code>.
     */
    public final TableField<PostsRecord, Integer> ID = createField(DSL.name("id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>Java.Posts.userId</code>.
     */
    public final TableField<PostsRecord, Integer> USERID = createField(DSL.name("userId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>Java.Posts.body</code>.
     */
    public final TableField<PostsRecord, String> BODY = createField(DSL.name("body"), org.jooq.impl.SQLDataType.VARCHAR(2048).nullable(false).defaultValue(org.jooq.impl.DSL.inline("n/a", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>Java.Posts.likes</code>.
     */
    public final TableField<PostsRecord, Integer> LIKES = createField(DSL.name("likes"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>Java.Posts.comments</code>.
     */
    public final TableField<PostsRecord, Integer> COMMENTS = createField(DSL.name("comments"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.inline("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>Java.Posts.date_posted</code>.
     */
    public final TableField<PostsRecord, Timestamp> DATE_POSTED = createField(DSL.name("date_posted"), org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false).defaultValue(org.jooq.impl.DSL.field("CURRENT_TIMESTAMP", org.jooq.impl.SQLDataType.TIMESTAMP)), this, "");

    /**
     * Create a <code>Java.Posts</code> table reference
     */
    public Posts() {
        this(DSL.name("Posts"), null);
    }

    /**
     * Create an aliased <code>Java.Posts</code> table reference
     */
    public Posts(String alias) {
        this(DSL.name(alias), POSTS);
    }

    /**
     * Create an aliased <code>Java.Posts</code> table reference
     */
    public Posts(Name alias) {
        this(alias, POSTS);
    }

    private Posts(Name alias, Table<PostsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Posts(Name alias, Table<PostsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Posts(Table<O> child, ForeignKey<O, PostsRecord> key) {
        super(child, key, POSTS);
    }

    @Override
    public Schema getSchema() {
        return Java.JAVA;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.POSTS_ID_UNIQUE, Indexes.POSTS_PRIMARY, Indexes.POSTS_USERID_IDX);
    }

    @Override
    public Identity<PostsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_POSTS;
    }

    @Override
    public UniqueKey<PostsRecord> getPrimaryKey() {
        return Keys.KEY_POSTS_PRIMARY;
    }

    @Override
    public List<UniqueKey<PostsRecord>> getKeys() {
        return Arrays.<UniqueKey<PostsRecord>>asList(Keys.KEY_POSTS_PRIMARY, Keys.KEY_POSTS_ID_UNIQUE);
    }

    @Override
    public List<ForeignKey<PostsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PostsRecord, ?>>asList(Keys.USERID);
    }

    public Users users() {
        return new Users(this, Keys.USERID);
    }

    @Override
    public Posts as(String alias) {
        return new Posts(DSL.name(alias), this);
    }

    @Override
    public Posts as(Name alias) {
        return new Posts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Posts rename(String name) {
        return new Posts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Posts rename(Name name) {
        return new Posts(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, String, Integer, Integer, Timestamp> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}
