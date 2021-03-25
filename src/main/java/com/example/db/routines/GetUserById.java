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
public class GetUserById extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 985870819;

    /**
     * The parameter <code>Java.Get_User_By_ID.inId</code>.
     */
    public static final Parameter<Integer> INID = Internal.createParameter("inId", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>Java.Get_User_By_ID.fname</code>.
     */
    public static final Parameter<String> FNAME = Internal.createParameter("fname", org.jooq.impl.SQLDataType.VARCHAR(255), false, false);

    /**
     * Create a new routine call instance
     */
    public GetUserById() {
        super("Get_User_By_ID", Java.JAVA);

        addInParameter(INID);
        addOutParameter(FNAME);
    }

    /**
     * Set the <code>inId</code> parameter IN value to the routine
     */
    public void setInid(Integer value) {
        setValue(INID, value);
    }

    /**
     * Get the <code>fname</code> parameter OUT value from the routine
     */
    public String getFname() {
        return get(FNAME);
    }
}
