package com.google.security.zynamics.zylib.general;

import com.google.common.base.*;

public class StackTrace
{
    public static String toString(final StackTraceElement[] array) {
        Preconditions.checkNotNull(array, (Object)"Invalid stack trace");
        final StringBuilder sb = new StringBuilder();
        for (int length = array.length, i = 0; i < length; ++i) {
            sb.append(array[i].toString());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}
