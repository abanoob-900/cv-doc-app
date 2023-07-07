package com.bob.cvdocapp.utils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

public class Config {
    public static final String SHARED_PREF_NAME = "cvdocapp";
    public static final String USER_ID = "userid";
    public static final String USER_PHOTO = "user_photo";
    public static final String USER_PHOTO_FILE = "user_photo_file";
    public static final String USER_NAME = "user_name";
    public static final String TOKEN_MOBILE = "token_mobile";
    public static final String USER_EMAIL = "email";
    public static final String USER_PHONE = "phone";
    public static final String USER_DATE = "date";
    public static final String USER_PASSWORD = "password";
    public static final String USER_Code = "RefereeCode";
    public static final String USER_RefereeLink = "RefereeLink";
    public static final String Api_Token = "api_token";

    public static final String COUNTRY = "country";
    public static final String COUNTRY_ID = "country_id";
    public static final String LANGUAGE = "language";

    public static final String USER_TYPE = "user_type";

    // change values
    public static final String CHANGE_LANGUAGE = "change_language";
    public static final String CHANGE_COUNTRY = "change_country";

    public static final String IS_LOGGED_IN = "is_logged_in";
    public static final String NOTIFICATION_COUNTER = "notification_counter";

    public static final String messagesUnread = "messagesUnread";
    public static final String APP_Language = "En";

    public static final String Lat = "Lat";
    public static final String Longitude = "Longitude";
    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static int num_of_car_today = 0;

    private static final int SECOND_MILLIS = 1000;
    private static final int MINUTE_MILLIS = 60 * SECOND_MILLIS;
    private static final int HOUR_MILLIS = 60 * MINUTE_MILLIS;
    private static final int DAY_MILLIS = 24 * HOUR_MILLIS;

    /**
     * For default language change, please check
     * LanguageFragment for language code and country code
     * ..............................................................
     * Language             | Language Code     | Country Code
     * ..............................................................
     * "English"            | "en"              | ""
     * "Arabic"             | "ar"              | ""
     * "Chinese (Mandarin)" | "zh"              | ""
     * "French"             | "fr"              | ""
     * "German"             | "de"              | ""
     * "India (Hindi)"      | "hi"              | "rIN"
     * "Indonesian"         | "in"              | ""
     * "Italian"            | "it"              | ""
     * "Japanese"           | "ja"              | ""
     * "Korean"             | "ko"              | ""
     * "Malay"              | "ms"              | ""
     * "Portuguese"         | "pt"              | ""
     * "Russian"            | "ru"              | ""
     * "Spanish"            | "es"              | ""
     * "Thai"               | "th"              | ""
     * "Turkish"            | "tr"              | ""
     * ..............................................................
     */
    public static final String LANGUAGE_CODE = "En";
    public static final String DEFAULT_LANGUAGE_COUNTRY_CODE = "";
    public static final String DEFAULT_LANGUAGE = LANGUAGE_CODE;
}
