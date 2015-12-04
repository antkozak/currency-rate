package com.newsoft.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

/**
 * Simple JIBX date serializer/deserializer.
 * <p/>
 * Date: Mar 4, 2010
 *
 * @author Anton Kozak
 */
public final class DateSerializer {

    private DateSerializer() {
    }

    /**
     * This will deserialize a date with a format of "dd-MMM-yy".  This does not take time or anything else into account
     * - just the simple date.  This is necessary as JIBX always wants a date time formate not just a simple date. Null
     * or empty strings cause null dates to be returned.
     *
     * @param date Date string following "dd-MMM-yy" format.
     * @return Returns a date unless the string is null or empty in which case null is returned.
     */
    public static Date deserializeDate(String date) {
        if(date == null || StringUtils.isEmpty(date)) {
            return null;
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
            return sdf.parse(date);
        } catch(ParseException e) {
            throw new RuntimeException("Could not parse date - causing deserialization to fail.", e);
        }
    }

    /**
     * This will serialize the date when creating the XML doc for fields that use the date serializer in the binding
     * file definition.  The date format of the string is "dd-MMM-yy".  For null dates an empty string is returned so
     * that the attribute is still in the XML document.
     *
     * @param date A date object.
     * @return Returns a date string in the format of "dd-MMM-yy" and empty string if the supplied date was null.
     */
    public static String serializeDate(Date date) {
        if(date == null) {
            return "";
        }

        SimpleDateFormat sdf = new SimpleDateFormat(Constants.DATE_FORMAT);
        return sdf.format(date);

    }
}
