package com.example.demo.session;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static final Map<String, String> users = new HashMap<>();

    static {
        users.put("admin", "0000");
        users.put("user", "1111");
        users.put("guest", "2222");
    }

    public static boolean isValidUser(String user, String password) {
        return users.containsKey(user) && users.get(user).equals(password);
    }
}
