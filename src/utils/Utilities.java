package utils;

import constants.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
    public static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

    public static Date stringToDate(String date) {
        Date result = null;
        try {
            result =  format.parse(date);
        } catch (ParseException e) {
            System.out.println("Error formating date: " + e.getMessage());
        }
        return result;
    }

    public static String DateToString(Date date) {
        return format.format(date);
    }

    public static int categoryToId(String category) {
        int id = -1;
        for(int i = 0; i < Constants.categories.length; i ++) {
            if(Constants.categories[i].equals(category)) {
                id = i;
                break;
            }
        }
        return id;
    }
}
