package com.example.sms;

public class Storage {
    private static String Name;
    private static String password;

    // This is how u should do it but u can also make field public and use them directly
    // for example -> 'Public static String Name' then use it as 'Storage.name'

    public static String getName() {
        return Name;
    }
    public static void setName(String name) {
        Name = name;
    }
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        Storage.password = password;
    }
}

