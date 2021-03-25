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

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>Java</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index AUTH_EMAIL_UNIQUE = Indexes0.AUTH_EMAIL_UNIQUE;
    public static final Index AUTH_PRIMARY = Indexes0.AUTH_PRIMARY;
    public static final Index AUTH_UID_UNIQUE = Indexes0.AUTH_UID_UNIQUE;
    public static final Index FRIENDSHIP_PRIMARY = Indexes0.FRIENDSHIP_PRIMARY;
    public static final Index FRIENDSHIP_SECOND_USER_ID_IDX = Indexes0.FRIENDSHIP_SECOND_USER_ID_IDX;
    public static final Index POSTS_ID_UNIQUE = Indexes0.POSTS_ID_UNIQUE;
    public static final Index POSTS_PRIMARY = Indexes0.POSTS_PRIMARY;
    public static final Index POSTS_USERID_IDX = Indexes0.POSTS_USERID_IDX;
    public static final Index SESSIONS_COOKIE_UNIQUE = Indexes0.SESSIONS_COOKIE_UNIQUE;
    public static final Index SESSIONS_PRIMARY = Indexes0.SESSIONS_PRIMARY;
    public static final Index SESSIONS_SESSION_ID_UNIQUE = Indexes0.SESSIONS_SESSION_ID_UNIQUE;
    public static final Index SETTINGS_EMAIL_UNIQUE = Indexes0.SETTINGS_EMAIL_UNIQUE;
    public static final Index SETTINGS_PRIMARY = Indexes0.SETTINGS_PRIMARY;
    public static final Index USERS_EMAIL_UNIQUE = Indexes0.USERS_EMAIL_UNIQUE;
    public static final Index USERS_ID_UNIQUE = Indexes0.USERS_ID_UNIQUE;
    public static final Index USERS_PRIMARY = Indexes0.USERS_PRIMARY;
    public static final Index USERS_USER_NAME_UNIQUE = Indexes0.USERS_USER_NAME_UNIQUE;
    public static final Index VERIFICATION_PRIMARY = Indexes0.VERIFICATION_PRIMARY;
    public static final Index VERIFICATION_USERID_UNIQUE = Indexes0.VERIFICATION_USERID_UNIQUE;
    public static final Index VERIFICATION_VERIFICATIONCODE_UNIQUE = Indexes0.VERIFICATION_VERIFICATIONCODE_UNIQUE;
    public static final Index VERIFICATION_VERIFICATIONID_UNIQUE = Indexes0.VERIFICATION_VERIFICATIONID_UNIQUE;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index AUTH_EMAIL_UNIQUE = Internal.createIndex("email_UNIQUE", Auth.AUTH, new OrderField[] { Auth.AUTH.EMAIL }, true);
        public static Index AUTH_PRIMARY = Internal.createIndex("PRIMARY", Auth.AUTH, new OrderField[] { Auth.AUTH.ID }, true);
        public static Index AUTH_UID_UNIQUE = Internal.createIndex("uid_UNIQUE", Auth.AUTH, new OrderField[] { Auth.AUTH.ID }, true);
        public static Index FRIENDSHIP_PRIMARY = Internal.createIndex("PRIMARY", Friendship.FRIENDSHIP, new OrderField[] { Friendship.FRIENDSHIP.ID }, true);
        public static Index FRIENDSHIP_SECOND_USER_ID_IDX = Internal.createIndex("second_user_id_idx", Friendship.FRIENDSHIP, new OrderField[] { Friendship.FRIENDSHIP.FIRST_USER_ID, Friendship.FRIENDSHIP.SECOND_USER_ID }, false);
        public static Index POSTS_ID_UNIQUE = Internal.createIndex("id_UNIQUE", Posts.POSTS, new OrderField[] { Posts.POSTS.ID }, true);
        public static Index POSTS_PRIMARY = Internal.createIndex("PRIMARY", Posts.POSTS, new OrderField[] { Posts.POSTS.ID }, true);
        public static Index POSTS_USERID_IDX = Internal.createIndex("userId_idx", Posts.POSTS, new OrderField[] { Posts.POSTS.USERID }, false);
        public static Index SESSIONS_COOKIE_UNIQUE = Internal.createIndex("cookie_UNIQUE", Sessions.SESSIONS, new OrderField[] { Sessions.SESSIONS.COOKIE }, true);
        public static Index SESSIONS_PRIMARY = Internal.createIndex("PRIMARY", Sessions.SESSIONS, new OrderField[] { Sessions.SESSIONS.SESSION_ID }, true);
        public static Index SESSIONS_SESSION_ID_UNIQUE = Internal.createIndex("session_id_UNIQUE", Sessions.SESSIONS, new OrderField[] { Sessions.SESSIONS.SESSION_ID }, true);
        public static Index SETTINGS_EMAIL_UNIQUE = Internal.createIndex("email_UNIQUE", Settings.SETTINGS, new OrderField[] { Settings.SETTINGS.EMAIL }, true);
        public static Index SETTINGS_PRIMARY = Internal.createIndex("PRIMARY", Settings.SETTINGS, new OrderField[] { Settings.SETTINGS.ID }, true);
        public static Index USERS_EMAIL_UNIQUE = Internal.createIndex("email_UNIQUE", Users.USERS, new OrderField[] { Users.USERS.EMAIL }, true);
        public static Index USERS_ID_UNIQUE = Internal.createIndex("ID_UNIQUE", Users.USERS, new OrderField[] { Users.USERS.ID }, true);
        public static Index USERS_PRIMARY = Internal.createIndex("PRIMARY", Users.USERS, new OrderField[] { Users.USERS.ID }, true);
        public static Index USERS_USER_NAME_UNIQUE = Internal.createIndex("user_name_UNIQUE", Users.USERS, new OrderField[] { Users.USERS.USER_NAME }, true);
        public static Index VERIFICATION_PRIMARY = Internal.createIndex("PRIMARY", Verification.VERIFICATION, new OrderField[] { Verification.VERIFICATION.VERIFICATIONID }, true);
        public static Index VERIFICATION_USERID_UNIQUE = Internal.createIndex("UserId_UNIQUE", Verification.VERIFICATION, new OrderField[] { Verification.VERIFICATION.USEREMAIL }, true);
        public static Index VERIFICATION_VERIFICATIONCODE_UNIQUE = Internal.createIndex("VerificationCode_UNIQUE", Verification.VERIFICATION, new OrderField[] { Verification.VERIFICATION.VERIFICATIONCODE }, true);
        public static Index VERIFICATION_VERIFICATIONID_UNIQUE = Internal.createIndex("VerificationID_UNIQUE", Verification.VERIFICATION, new OrderField[] { Verification.VERIFICATION.VERIFICATIONID }, true);
    }
}