/*
 * Decompiled with CFR 0_115.
 */
package org.ibex.nestedvm.util;

import java.io.File;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Locale;
import java.util.TimeZone;
import org.ibex.nestedvm.util.Seekable;
import org.ibex.nestedvm.util.Seekable$Lock;

public abstract class Platform {
    private static final Platform p;
    static Class class$org$ibex$nestedvm$util$Platform;

    Platform() {
    }

    public static String getProperty(String string) {
        try {
            return System.getProperty(string);
        }
        catch (SecurityException var1_1) {
            return null;
        }
    }

    abstract boolean _atomicCreateFile(File var1);

    public static boolean atomicCreateFile(File file) {
        return p._atomicCreateFile(file);
    }

    abstract Seekable$Lock _lockFile(Seekable var1, RandomAccessFile var2, long var3, long var5, boolean var7);

    public static Seekable$Lock lockFile(Seekable seekable, RandomAccessFile randomAccessFile, long l2, long l3, boolean bl2) {
        return p._lockFile(seekable, randomAccessFile, l2, l3, bl2);
    }

    abstract void _socketHalfClose(Socket var1, boolean var2);

    public static void socketHalfClose(Socket socket, boolean bl2) {
        p._socketHalfClose(socket, bl2);
    }

    abstract void _socketSetKeepAlive(Socket var1, boolean var2);

    public static void socketSetKeepAlive(Socket socket, boolean bl2) {
        p._socketSetKeepAlive(socket, bl2);
    }

    abstract InetAddress _inetAddressFromBytes(byte[] var1);

    public static InetAddress inetAddressFromBytes(byte[] arrby) {
        return p._inetAddressFromBytes(arrby);
    }

    abstract String _timeZoneGetDisplayName(TimeZone var1, boolean var2, boolean var3, Locale var4);

    public static String timeZoneGetDisplayName(TimeZone timeZone, boolean bl2, boolean bl3, Locale locale) {
        return p._timeZoneGetDisplayName(timeZone, bl2, bl3, locale);
    }

    public static String timeZoneGetDisplayName(TimeZone timeZone, boolean bl2, boolean bl3) {
        return Platform.timeZoneGetDisplayName(timeZone, bl2, bl3, Locale.getDefault());
    }

    abstract void _setFileLength(RandomAccessFile var1, int var2);

    public static void setFileLength(RandomAccessFile randomAccessFile, int n2) {
        p._setFileLength(randomAccessFile, n2);
    }

    abstract File[] _listRoots();

    public static File[] listRoots() {
        return p._listRoots();
    }

    abstract File _getRoot(File var1);

    public static File getRoot(File file) {
        return p._getRoot(file);
    }

    static Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException var1_1) {
            throw new NoClassDefFoundError(var1_1.getMessage());
        }
    }

    static {
        float f2;
        String string;
        try {
            f2 = Platform.getProperty("java.vm.name").equals("SableVM") ? 1.2f : Float.valueOf(Platform.getProperty("java.specification.version")).floatValue();
        }
        catch (Exception var1_1) {
            System.err.println(new StringBuffer().append("WARNING: ").append(var1_1).append(" while trying to find jvm version -  assuming 1.1").toString());
            f2 = 1.1f;
        }
        if (f2 >= 1.4f) {
            string = "Jdk14";
        } else if (f2 >= 1.3f) {
            string = "Jdk13";
        } else if (f2 >= 1.2f) {
            string = "Jdk12";
        } else {
            if (f2 < 1.1f) throw new Error(new StringBuffer().append("JVM Specification version: ").append(f2).append(" is too old. (see org.ibex.util.Platform to add support)").toString());
            string = "Jdk11";
        }
        try {
            Class class_ = class$org$ibex$nestedvm$util$Platform == null ? (Platform.class$org$ibex$nestedvm$util$Platform = Platform.class$("org.ibex.nestedvm.util.Platform")) : class$org$ibex$nestedvm$util$Platform;
            p = (Platform)Class.forName(new StringBuffer().append(class_.getName()).append("$").append(string).toString()).newInstance();
            return;
        }
        catch (Exception var2_3) {
            var2_3.printStackTrace();
            throw new Error("Error instansiating platform class");
        }
    }
}

