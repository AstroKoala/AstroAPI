/*
 * This file is generated by jOOQ.
 */
package com.astroapi.db.routines;


import javax.annotation.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;

import com.astroapi.db.Java;


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
public class GetSettingsForUser extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 749873775;

    /**
     * The parameter <code>Java.Get_Settings_For_User.inUserId</code>.
     */
    public static final Parameter<Integer> INUSERID = Internal.createParameter("inUserId", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>Java.Get_Settings_For_User.showOwnPostsInFeed</code>.
     */
    public static final Parameter<Byte> SHOWOWNPOSTSINFEED = Internal.createParameter("showOwnPostsInFeed", org.jooq.impl.SQLDataType.TINYINT, false, false);

    /**
     * Create a new routine call instance
     */
    public GetSettingsForUser() {
        super("Get_Settings_For_User", Java.JAVA);

        addInParameter(INUSERID);
        addOutParameter(SHOWOWNPOSTSINFEED);
    }

    /**
     * Set the <code>inUserId</code> parameter IN value to the routine
     */
    public void setInuserid(Integer value) {
        setValue(INUSERID, value);
    }

    /**
     * Get the <code>showOwnPostsInFeed</code> parameter OUT value from the routine
     */
    public Byte getShowownpostsinfeed() {
        return get(SHOWOWNPOSTSINFEED);
    }
}