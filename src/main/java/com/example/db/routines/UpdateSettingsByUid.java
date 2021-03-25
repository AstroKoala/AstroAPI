/*
 * This file is generated by jOOQ.
 */
package com.example.db.routines;


import com.example.db.Java;

import javax.annotation.Generated;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;


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
public class UpdateSettingsByUid extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 325738990;

    /**
     * The parameter <code>Java.Update_Settings_By_UID.inUID</code>.
     */
    public static final Parameter<Integer> INUID = Internal.createParameter("inUID", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>Java.Update_Settings_By_UID.inShowOwnPostsInFeed</code>.
     */
    public static final Parameter<Byte> INSHOWOWNPOSTSINFEED = Internal.createParameter("inShowOwnPostsInFeed", org.jooq.impl.SQLDataType.TINYINT, false, false);

    /**
     * Create a new routine call instance
     */
    public UpdateSettingsByUid() {
        super("Update_Settings_By_UID", Java.JAVA);

        addInParameter(INUID);
        addInParameter(INSHOWOWNPOSTSINFEED);
    }

    /**
     * Set the <code>inUID</code> parameter IN value to the routine
     */
    public void setInuid(Integer value) {
        setValue(INUID, value);
    }

    /**
     * Set the <code>inShowOwnPostsInFeed</code> parameter IN value to the routine
     */
    public void setInshowownpostsinfeed(Byte value) {
        setValue(INSHOWOWNPOSTSINFEED, value);
    }
}
