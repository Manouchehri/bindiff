/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

import com.google.common.base.Preconditions;

public class StackTrace {
    public static String toString(StackTraceElement[] arrstackTraceElement) {
        Preconditions.checkNotNull(arrstackTraceElement, "Invalid stack trace");
        StringBuilder stringBuilder = new StringBuilder();
        StackTraceElement[] arrstackTraceElement2 = arrstackTraceElement;
        int n2 = arrstackTraceElement2.length;
        int n3 = 0;
        while (n3 < n2) {
            StackTraceElement stackTraceElement = arrstackTraceElement2[n3];
            stringBuilder.append(stackTraceElement.toString());
            stringBuilder.append(System.getProperty("line.separator"));
            ++n3;
        }
        return stringBuilder.toString();
    }
}

