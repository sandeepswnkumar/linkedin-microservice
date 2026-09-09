package com.codingshuttle.linkedIn.user_service.util;

import static org.mindrot.jbcrypt.BCrypt.*;

public class BCrypt {

    public static String hashString(String str ){
        return hashpw(str, gensalt());
    }

    public static Boolean match(String str, String hashedStr){
        return checkpw(str, hashedStr);
    }
}
