package com.danhoh.user.util;

import java.util.UUID;

public final class TestUtils {

    private TestUtils() {}

    public static final class TestValues {

        public static final class UserValues {

            public static final UUID ID = UUID.randomUUID();
            public static final String NAME = "John";
            public static final String LOGIN = "LOGIN";
            public static final String EMAIL = "test@mail.com";
            public static final Byte AGE = 22;
            public static final String PHONE = "9209998883223";
            public static final String PASSWORD = "password";
            public static final String DESCRIPTION = "description";
        }

    }
}
