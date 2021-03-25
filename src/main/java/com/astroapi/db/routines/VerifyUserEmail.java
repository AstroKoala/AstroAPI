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
public class VerifyUserEmail extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = -258497108;

    /**
     * The parameter <code>Java.Verify_User_Email.email</code>.
     */
    public static final Parameter<String> EMAIL = Internal.createParameter("email", org.jooq.impl.SQLDataType.VARCHAR(255), false, false);

    /**
     * Create a new routine call instance
     */
    public VerifyUserEmail() {
        super("Verify_User_Email", Java.JAVA);

        addInParameter(EMAIL);
    }

    /**
     * Set the <code>email</code> parameter IN value to the routine
     */
    public void setEmail(String value) {
        setValue(EMAIL, value);
    }
}