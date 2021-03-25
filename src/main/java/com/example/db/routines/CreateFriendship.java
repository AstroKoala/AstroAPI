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
public class CreateFriendship extends AbstractRoutine<java.lang.Void> {

    private static final long serialVersionUID = 1484313144;

    /**
     * The parameter <code>Java.Create_Friendship.user_1_ID</code>.
     */
    public static final Parameter<Integer> USER_1_ID = Internal.createParameter("user_1_ID", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * The parameter <code>Java.Create_Friendship.user_2_ID</code>.
     */
    public static final Parameter<Integer> USER_2_ID = Internal.createParameter("user_2_ID", org.jooq.impl.SQLDataType.INTEGER, false, false);

    /**
     * Create a new routine call instance
     */
    public CreateFriendship() {
        super("Create_Friendship", Java.JAVA);

        addInParameter(USER_1_ID);
        addInParameter(USER_2_ID);
    }

    /**
     * Set the <code>user_1_ID</code> parameter IN value to the routine
     */
    public void setUser_1Id(Integer value) {
        setValue(USER_1_ID, value);
    }

    /**
     * Set the <code>user_2_ID</code> parameter IN value to the routine
     */
    public void setUser_2Id(Integer value) {
        setValue(USER_2_ID, value);
    }
}