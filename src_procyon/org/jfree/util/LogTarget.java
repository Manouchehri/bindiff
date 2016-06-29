package org.jfree.util;

public interface LogTarget
{
    public static final int ERROR = 0;
    public static final int WARN = 1;
    public static final int INFO = 2;
    public static final int DEBUG = 3;
    public static final String[] LEVELS = { "ERROR: ", "WARN:  ", "INFO:  ", "DEBUG: " };
    
    void log(final int p0, final Object p1);
    
    void log(final int p0, final Object p1, final Exception p2);
}
