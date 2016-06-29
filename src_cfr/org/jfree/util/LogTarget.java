/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

public interface LogTarget {
    public static final int ERROR = 0;
    public static final int WARN = 1;
    public static final int INFO = 2;
    public static final int DEBUG = 3;
    public static final String[] LEVELS = new String[]{"ERROR: ", "WARN:  ", "INFO:  ", "DEBUG: "};

    public void log(int var1, Object var2);

    public void log(int var1, Object var2, Exception var3);
}

