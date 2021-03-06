/*
 * This file is generated by jOOQ.
 */
package com.example.db;


import com.example.db.tables.Auth;
import com.example.db.tables.Friendship;
import com.example.db.tables.Posts;
import com.example.db.tables.Sessions;
import com.example.db.tables.Settings;
import com.example.db.tables.Users;
import com.example.db.tables.Verification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class Java extends SchemaImpl {

    private static final long serialVersionUID = -1706535595;

    /**
     * The reference instance of <code>Java</code>
     */
    public static final Java JAVA = new Java();

    /**
     * The table <code>Java.Auth</code>.
     */
    public final Auth AUTH = com.example.db.tables.Auth.AUTH;

    /**
     * The table <code>Java.Friendship</code>.
     */
    public final Friendship FRIENDSHIP = com.example.db.tables.Friendship.FRIENDSHIP;

    /**
     * The table <code>Java.Posts</code>.
     */
    public final Posts POSTS = com.example.db.tables.Posts.POSTS;

    /**
     * The table <code>Java.Sessions</code>.
     */
    public final Sessions SESSIONS = com.example.db.tables.Sessions.SESSIONS;

    /**
     * The table <code>Java.Settings</code>.
     */
    public final Settings SETTINGS = com.example.db.tables.Settings.SETTINGS;

    /**
     * The table <code>Java.Users</code>.
     */
    public final Users USERS = com.example.db.tables.Users.USERS;

    /**
     * The table <code>Java.Verification</code>.
     */
    public final Verification VERIFICATION = com.example.db.tables.Verification.VERIFICATION;

    /**
     * No further instances allowed
     */
    private Java() {
        super("Java", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Auth.AUTH,
            Friendship.FRIENDSHIP,
            Posts.POSTS,
            Sessions.SESSIONS,
            Settings.SETTINGS,
            Users.USERS,
            Verification.VERIFICATION);
    }
}
