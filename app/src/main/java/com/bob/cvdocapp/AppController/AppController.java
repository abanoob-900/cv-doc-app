package com.bob.cvdocapp.AppController;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

import com.bob.cvdocapp.model.User;
import com.bob.cvdocapp.utils.Config;

import java.util.Locale;

public class AppController extends Application {

    //Getting tag it will be used for displaying log and it is optional
    public static final String TAG = AppController.class.getSimpleName();

    ProgressDialog mDialog;

    //Creating class object
    private static AppController mInstance;

    //Creating sharedPreferences object
    //We will store the user data in sharedPreferences
    private SharedPreferences sharedPreferences;

    //class instance will be initialized on app launch
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    //Public static method to get the instance of this class
    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public ProgressDialog getDialog(Context context) {

        mDialog = new ProgressDialog(context);
        mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);
        return mDialog;
    }

    public ProgressDialog dismissDialog(Context context) {

        if (mDialog == null) {
            mDialog = new ProgressDialog(context);
        }

        return mDialog;
    }

    //Method to get sharedPreferences
    public SharedPreferences getSharedPreferences() {
        if (sharedPreferences == null)
            sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    //This method will clear the sharedPreference
    //It will be called on logout
    public void logout() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.clear();
        editor.apply();
    }

    //This method will store the user data on sharedPreferences
    //It will be called on login
    public void loginUser(User user, int type) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_ID, String.valueOf(user.getId()));
        editor.putString(Config.USER_EMAIL, user.getEmail());
        editor.putString(Config.USER_NAME, user.getName());
        editor.putInt(Config.USER_TYPE, type);
        editor.putBoolean(Config.IS_LOGGED_IN, true);
        editor.apply();
    }

    public void updateClientsName(String name) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_NAME, name);
        editor.apply();
    }

    public void updateClientsPhoto(String photo) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_PHOTO, photo);
        editor.apply();
    }

    public void updateMerchantName(String name) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_NAME, name);
        editor.apply();
    }

    public void updateMerchantPhoto(String photo) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_PHOTO, photo);
        editor.apply();
    }

    public void updateUserData(String name, String email, String phone) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_EMAIL, email);
        editor.putString(Config.USER_NAME, name);
        editor.putString(Config.USER_PHONE, phone);
        editor.apply();
    }

    public void saveLocation(String lat, String longitude) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.Lat, lat);
        editor.putString(Config.Longitude, longitude);
        editor.apply();
    }

    public String getUserCode() {
        return getSharedPreferences().getString(Config.USER_Code, "");
    }

    public String getRefereeLink() {
        return getSharedPreferences().getString(Config.USER_RefereeLink, "");
    }

    public void setUserCode(String userCode) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_Code, userCode);
        editor.apply();
    }

    public void setRefereeLink(String refereeLink) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_RefereeLink, refereeLink);
        editor.apply();
    }

    public String getLatitude() {
        return getSharedPreferences().getString(Config.Lat, null);
    }

    public String getLongitude() {
        return getSharedPreferences().getString(Config.Longitude, null);
    }


    public void setLatitude(String Latitude) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.Lat, Latitude);
        editor.apply();
    }

    public void setLongitude(String Longitude) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.Longitude, Longitude);
        editor.apply();
    }

    public void UpdatePhoto(String photo) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_PHOTO, photo);

        editor.apply();

    }

    //This method will check whether the user is logged in or not
    public boolean isLoggedIn() {
        return getSharedPreferences().getBoolean(Config.IS_LOGGED_IN, false);
    }

    public void setUserPhoto(String img) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.USER_PHOTO, img);
        editor.apply();
    }

    public void setLoggedIn(boolean isLogged) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(Config.IS_LOGGED_IN, isLogged);
        editor.apply();
    }

    public void setAppLanguage(String languageCode, String languageName) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.LANGUAGE_CODE, languageCode);
        editor.putString(Config.LANGUAGE, languageName);
        editor.apply();
    }

    public void setAppCountry(String countryName, int countryId) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(Config.COUNTRY, countryName);
        editor.putInt(Config.COUNTRY_ID, countryId);
        editor.apply();
    }

    public void setAppChangeLanguage(boolean isChange) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(Config.CHANGE_LANGUAGE, isChange);
        editor.apply();
    }

    public void setAppChangeCountry(boolean isChange) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(Config.CHANGE_COUNTRY, isChange);
        editor.apply();
    }

    public void removeKeyAppChangeLanguage() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(Config.CHANGE_LANGUAGE);
        editor.apply();
    }

    public void removeKeyAppTokens() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(Config.TOKEN_MOBILE);
        editor.remove(Config.Api_Token);
        editor.apply();
    }

    public void removeKeyAppChangeCountry() {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.remove(Config.CHANGE_COUNTRY);
        editor.apply();
    }

    public void setNotificationCounter(int counter) {
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putInt(Config.NOTIFICATION_COUNTER, counter);
        editor.apply();
    }

    public int getNotificationCounter() {
        return getSharedPreferences().getInt(Config.NOTIFICATION_COUNTER, 0);
    }

    public String getCurrentLanguage() {
//        return getSharedPreferences().getString(Config.LANGUAGE_CODE, "ar");
        return getSharedPreferences().getString(Config.LANGUAGE_CODE, Locale.getDefault().getLanguage());
    }

    public String getNameLanguage() {
//        return getSharedPreferences().getString(Config.LANGUAGE, "Arabic");
        return getSharedPreferences().getString(Config.LANGUAGE, Locale.getDefault().getDisplayLanguage());
    }

    public String getAppCountry() {

        return getSharedPreferences().getString(Config.COUNTRY, null);
    }

    public boolean getChangeLanguage() {

        return getSharedPreferences().getBoolean(Config.CHANGE_LANGUAGE, false);
    }

    public boolean getChangeCountry() {

        return getSharedPreferences().getBoolean(Config.CHANGE_COUNTRY, false);
    }

    public int getAppCountryID() {

        return getSharedPreferences().getInt(Config.COUNTRY_ID, -1);
    }

    public String getUserId() {

        return getSharedPreferences().getString(Config.USER_ID, null);
    }

    /**
     * UserType == 1 > client
     * UserType == 2 > merchant
     * @return
     */
    public Integer getUserType() {
        return getSharedPreferences().getInt(Config.USER_TYPE,0);
    }

    public String getUserPhoto() {

        return getSharedPreferences().getString(Config.USER_PHOTO, null);
    }


    //This method will return the username of logged in user
    public String getUserName() {

        return getSharedPreferences().getString(Config.USER_NAME, "");
    }

    public String getUserEmail() {

        return getSharedPreferences().getString(Config.USER_EMAIL, null);
    }

    public String getUserPhone() {

        return getSharedPreferences().getString(Config.USER_PHONE, null);
    }

    public String getApiToken() {

        return getSharedPreferences().getString(Config.Api_Token, "");
    }

    public void RateUsInPlayStore() {

        Uri uri;
        uri = Uri.parse("market://details?id=" + getPackageName());
        Intent view = new Intent();
        view.setAction(Intent.ACTION_VIEW);
        view.setData(Uri.parse(String.valueOf(uri)));
        view.addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK);
        view.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        view.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.

        try {
            startActivity(view);
        } catch (ActivityNotFoundException exception) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName()));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
