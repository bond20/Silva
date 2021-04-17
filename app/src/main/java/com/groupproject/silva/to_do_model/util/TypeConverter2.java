package com.groupproject.silva.to_do_model.util;

import androidx.room.TypeConverter;
import java.util.Date;

public class TypeConverter2 {

    @TypeConverter
    public static Date longToTimeStamp(Long value) {
        if  (value == null) {
            return null;
        }
        else {
            return new Date(value);
        }
    }

    @TypeConverter
    public static Long dateToTimeStamp(Date date) {
        if (date == null) {
            return null;
        }
        else {
            return date.getTime();
        }
    }


}
