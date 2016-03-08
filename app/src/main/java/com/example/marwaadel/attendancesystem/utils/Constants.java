package com.example.marwaadel.attendancesystem.utils;

/**
 * Constants class store most important strings and paths of the app
 */
public final class Constants {

    /**
     * Constants related to locations in Firebase, such as the name of the node
     * where active lists are stored (ie "activeLists")
     */
    public static final String FIREBASE_PROPERTY_LIST_NAME = "StudentList";

    /**
     * Constants for Firebase object properties
     */
    public static final String FIREBASE_PROPERTY_TIMESTAMP_LAST_CHANGED = "timestampLastChanged";
    public static final String FIREBASE_PROPERTY_TIMESTAMP = "timestamp";

    /**
     * Constants for Firebase URL
     */
    public static final String FIREBASE_URL = "https://boiling-torch-9221.firebaseio.com/";
    public static final String FIREBASE_URL_ACTIVE_LIST = FIREBASE_URL + "/" + FIREBASE_PROPERTY_LIST_NAME;

    /**
     * Constants for bundles, extras and shared preferences keys
     */


}
