package com.newsoft.common;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;


/**
 * Simple JIBX number serializer/deserializer.
 * <p/>
 * Date: Mar 5, 2010
 *
 * @author Anton Kozak
 */

public final class NumberSerializer {

    private NumberSerializer() {
    }

    /**
     * Deserializes a String into a Double.
     *
     * @param value the String to deserialize
     * @return the Double value of the String, or null if it was not a number.
     */
    public static Double deserializeDouble(String value) {
        if(StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return null;
        } else {
            return new Double(value);
        }
    }

    /**
     * Deserializes a String into an Integer.
     *
     * @param value the String to deserialize
     * @return the Double value of the String, or null if it was not a number.
     */
    public static Integer deserializeInteger(String value) {
        if(StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return null;
        } else {
            return new Integer(value);
        }
    }

    /**
     * Deserializes a String into a Long.
     *
     * @param value the String to deserialize
     * @return the Long value of the String, or null if it was not a number.
     */
    public static Long deserializeLong(String value) {
        if(StringUtils.isEmpty(value) || !NumberUtils.isNumber(value)) {
            return null;
        } else {
            return new Long(value);
        }
    }

}
