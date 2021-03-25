/*
 * This file is generated by jOOQ.
 */
package com.astroapi.db;


import javax.annotation.Generated;

import org.jooq.Configuration;

import com.astroapi.db.routines.AddNewUser;
import com.astroapi.db.routines.AuthWithEmail;
import com.astroapi.db.routines.CreateFriendship;
import com.astroapi.db.routines.CreateVerification;
import com.astroapi.db.routines.DeleteSessionByCookie;
import com.astroapi.db.routines.DeleteUserByEmail;
import com.astroapi.db.routines.DeleteUserById;
import com.astroapi.db.routines.DeleteVerification;
import com.astroapi.db.routines.GetSettingsForUser;
import com.astroapi.db.routines.GetUserByEmail;
import com.astroapi.db.routines.GetUserById;
import com.astroapi.db.routines.GetUserSession;
import com.astroapi.db.routines.GetVerification;
import com.astroapi.db.routines.PublishPost;
import com.astroapi.db.routines.StoreSession;
import com.astroapi.db.routines.UpdatePassword;
import com.astroapi.db.routines.UpdateSettingsByUid;
import com.astroapi.db.routines.VerifyUserEmail;


/**
 * Convenience access to all stored procedures and functions in Java
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>Java.Add_New_User</code>
     */
    public static void addNewUser(Configuration configuration, String inemail, String inpass, String inusername) {
        AddNewUser p = new AddNewUser();
        p.setInemail(inemail);
        p.setInpass(inpass);
        p.setInusername(inusername);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Auth_With_Email</code>
     */
    public static String authWithEmail(Configuration configuration, String inemail) {
        AuthWithEmail p = new AuthWithEmail();
        p.setInemail(inemail);

        p.execute(configuration);
        return p.getOutval();
    }

    /**
     * Call <code>Java.Create_Friendship</code>
     */
    public static void createFriendship(Configuration configuration, Integer user_1Id, Integer user_2Id) {
        CreateFriendship p = new CreateFriendship();
        p.setUser_1Id(user_1Id);
        p.setUser_2Id(user_2Id);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Create_Verification</code>
     */
    public static void createVerification(Configuration configuration, String inemail, String intime, String incode) {
        CreateVerification p = new CreateVerification();
        p.setInemail(inemail);
        p.setIntime(intime);
        p.setIncode(incode);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Delete_Session_By_Cookie</code>
     */
    public static void deleteSessionByCookie(Configuration configuration, String cook) {
        DeleteSessionByCookie p = new DeleteSessionByCookie();
        p.setCook(cook);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Delete_User_By_Email</code>
     */
    public static void deleteUserByEmail(Configuration configuration, String useremail) {
        DeleteUserByEmail p = new DeleteUserByEmail();
        p.setUseremail(useremail);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Delete_User_By_Id</code>
     */
    public static void deleteUserById(Configuration configuration, Integer userid) {
        DeleteUserById p = new DeleteUserById();
        p.setUserid(userid);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Delete_Verification</code>
     */
    public static void deleteVerification(Configuration configuration, String inemail) {
        DeleteVerification p = new DeleteVerification();
        p.setInemail(inemail);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Get_Settings_For_User</code>
     */
    public static Byte getSettingsForUser(Configuration configuration, Integer inuserid) {
        GetSettingsForUser p = new GetSettingsForUser();
        p.setInuserid(inuserid);

        p.execute(configuration);
        return p.getShowownpostsinfeed();
    }

    /**
     * Call <code>Java.Get_User_By_Email</code>
     */
    public static GetUserByEmail getUserByEmail(Configuration configuration, String inemail) {
        GetUserByEmail p = new GetUserByEmail();
        p.setInemail(inemail);

        p.execute(configuration);
        return p;
    }

    /**
     * Call <code>Java.Get_User_By_ID</code>
     */
    public static String getUserById(Configuration configuration, Integer inid) {
        GetUserById p = new GetUserById();
        p.setInid(inid);

        p.execute(configuration);
        return p.getFname();
    }

    /**
     * Call <code>Java.Get_User_Session</code>
     */
    public static GetUserSession getUserSession(Configuration configuration, String input) {
        GetUserSession p = new GetUserSession();
        p.setInput(input);

        p.execute(configuration);
        return p;
    }

    /**
     * Call <code>Java.Get_Verification</code>
     */
    public static GetVerification getVerification(Configuration configuration, String inemail) {
        GetVerification p = new GetVerification();
        p.setInemail(inemail);

        p.execute(configuration);
        return p;
    }

    /**
     * Call <code>Java.Publish_Post</code>
     */
    public static void publishPost(Configuration configuration, String intext, Integer inuser) {
        PublishPost p = new PublishPost();
        p.setIntext(intext);
        p.setInuser(inuser);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Store_Session</code>
     */
    public static void storeSession(Configuration configuration, String cook, Integer uid) {
        StoreSession p = new StoreSession();
        p.setCook(cook);
        p.setUid(uid);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Update_Password</code>
     */
    public static void updatePassword(Configuration configuration, String inemail, String inpass) {
        UpdatePassword p = new UpdatePassword();
        p.setInemail(inemail);
        p.setInpass(inpass);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Update_Settings_By_UID</code>
     */
    public static void updateSettingsByUid(Configuration configuration, Integer inuid, Byte inshowownpostsinfeed) {
        UpdateSettingsByUid p = new UpdateSettingsByUid();
        p.setInuid(inuid);
        p.setInshowownpostsinfeed(inshowownpostsinfeed);

        p.execute(configuration);
    }

    /**
     * Call <code>Java.Verify_User_Email</code>
     */
    public static void verifyUserEmail(Configuration configuration, String email) {
        VerifyUserEmail p = new VerifyUserEmail();
        p.setEmail(email);

        p.execute(configuration);
    }
}