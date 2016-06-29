package org.ibex.nestedvm.util;

import java.io.*;
import java.net.*;
import java.util.*;

public abstract class Platform
{
    private static final Platform p;
    static Class class$org$ibex$nestedvm$util$Platform;
    
    public static String getProperty(final String s) {
        try {
            return System.getProperty(s);
        }
        catch (SecurityException ex) {
            return null;
        }
    }
    
    abstract boolean _atomicCreateFile(final File p0);
    
    public static boolean atomicCreateFile(final File file) {
        return Platform.p._atomicCreateFile(file);
    }
    
    abstract Seekable$Lock _lockFile(final Seekable p0, final RandomAccessFile p1, final long p2, final long p3, final boolean p4);
    
    public static Seekable$Lock lockFile(final Seekable seekable, final RandomAccessFile randomAccessFile, final long n, final long n2, final boolean b) {
        return Platform.p._lockFile(seekable, randomAccessFile, n, n2, b);
    }
    
    abstract void _socketHalfClose(final Socket p0, final boolean p1);
    
    public static void socketHalfClose(final Socket socket, final boolean b) {
        Platform.p._socketHalfClose(socket, b);
    }
    
    abstract void _socketSetKeepAlive(final Socket p0, final boolean p1);
    
    public static void socketSetKeepAlive(final Socket socket, final boolean b) {
        Platform.p._socketSetKeepAlive(socket, b);
    }
    
    abstract InetAddress _inetAddressFromBytes(final byte[] p0);
    
    public static InetAddress inetAddressFromBytes(final byte[] array) {
        return Platform.p._inetAddressFromBytes(array);
    }
    
    abstract String _timeZoneGetDisplayName(final TimeZone p0, final boolean p1, final boolean p2, final Locale p3);
    
    public static String timeZoneGetDisplayName(final TimeZone timeZone, final boolean b, final boolean b2, final Locale locale) {
        return Platform.p._timeZoneGetDisplayName(timeZone, b, b2, locale);
    }
    
    public static String timeZoneGetDisplayName(final TimeZone timeZone, final boolean b, final boolean b2) {
        return timeZoneGetDisplayName(timeZone, b, b2, Locale.getDefault());
    }
    
    abstract void _setFileLength(final RandomAccessFile p0, final int p1);
    
    public static void setFileLength(final RandomAccessFile randomAccessFile, final int n) {
        Platform.p._setFileLength(randomAccessFile, n);
    }
    
    abstract File[] _listRoots();
    
    public static File[] listRoots() {
        return Platform.p._listRoots();
    }
    
    abstract File _getRoot(final File p0);
    
    public static File getRoot(final File file) {
        return Platform.p._getRoot(file);
    }
    
    static Class class$(final String s) {
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            throw new NoClassDefFoundError(ex.getMessage());
        }
    }
    
    static {
        float floatValue;
        try {
            if (getProperty("java.vm.name").equals("SableVM")) {
                floatValue = 1.2f;
            }
            else {
                floatValue = Float.valueOf(getProperty("java.specification.version"));
            }
        }
        catch (Exception ex) {
            System.err.println("WARNING: " + ex + " while trying to find jvm version -  assuming 1.1");
            floatValue = 1.1f;
        }
        String s;
        if (floatValue >= 1.4f) {
            s = "Jdk14";
        }
        else if (floatValue >= 1.3f) {
            s = "Jdk13";
        }
        else if (floatValue >= 1.2f) {
            s = "Jdk12";
        }
        else {
            if (floatValue < 1.1f) {
                throw new Error("JVM Specification version: " + floatValue + " is too old. (see org.ibex.util.Platform to add support)");
            }
            s = "Jdk11";
        }
        try {
            p = (Platform)Class.forName(((Platform.class$org$ibex$nestedvm$util$Platform == null) ? (Platform.class$org$ibex$nestedvm$util$Platform = class$("org.ibex.nestedvm.util.Platform")) : Platform.class$org$ibex$nestedvm$util$Platform).getName() + "$" + s).newInstance();
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
            throw new Error("Error instansiating platform class");
        }
    }
}
