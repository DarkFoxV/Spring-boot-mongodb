package com.io.darkfoxv.application.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    public static String decodeParam(String url){
        try {
            return URLDecoder.decode(url,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date convertDate(String text, Date defaultDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(text);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
