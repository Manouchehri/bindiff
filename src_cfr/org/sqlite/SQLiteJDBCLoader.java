/*
 * Decompiled with CFR 0_115.
 */
package org.sqlite;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import org.sqlite.OSInfo;

public class SQLiteJDBCLoader {
    private static boolean extracted = false;

    public static boolean initialize() {
        SQLiteJDBCLoader.loadSQLiteNativeLibrary();
        return extracted;
    }

    static boolean getPureJavaFlag() {
        return Boolean.parseBoolean(System.getProperty("sqlite.purejava", "false"));
    }

    public static boolean isPureJavaMode() {
        if (SQLiteJDBCLoader.isNativeMode()) return false;
        return true;
    }

    public static boolean isNativeMode() {
        if (SQLiteJDBCLoader.getPureJavaFlag()) {
            return false;
        }
        SQLiteJDBCLoader.initialize();
        return extracted;
    }

    static String md5sum(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            DigestInputStream digestInputStream = new DigestInputStream(bufferedInputStream, messageDigest);
            while (digestInputStream.read() >= 0) {
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(messageDigest.digest());
            String string = byteArrayOutputStream.toString();
            return string;
        }
        catch (NoSuchAlgorithmException var2_3) {
            throw new IllegalStateException("MD5 algorithm is not available: " + var2_3);
        }
        finally {
            bufferedInputStream.close();
        }
    }

    private static boolean extractAndLoadLibraryFile(String string, String string2, String string3) {
        String string4 = string + "/" + string2;
        String string5 = "sqlite-" + SQLiteJDBCLoader.getVersion() + "-";
        String string6 = string5 + string2;
        File file = new File(string3, string6);
        try {
            Object object;
            Object object2;
            if (file.exists()) {
                object2 = SQLiteJDBCLoader.md5sum(SQLiteJDBCLoader.class.getResourceAsStream(string4));
                if (object2.equals(object = SQLiteJDBCLoader.md5sum(new FileInputStream(file)))) {
                    return SQLiteJDBCLoader.loadNativeLibrary(string3, string6);
                }
                boolean bl2 = file.delete();
                if (!bl2) {
                    throw new IOException("failed to remove existing native library file: " + file.getAbsolutePath());
                }
            }
            object2 = SQLiteJDBCLoader.class.getResourceAsStream(string4);
            object = new FileOutputStream(file);
            byte[] arrby = new byte[1024];
            int n2 = 0;
            while ((n2 = object2.read(arrby)) != -1) {
                object.write(arrby, 0, n2);
            }
            object.close();
            object2.close();
            if (System.getProperty("os.name").contains("Windows")) return SQLiteJDBCLoader.loadNativeLibrary(string3, string6);
            try {
                Runtime.getRuntime().exec(new String[]{"chmod", "755", file.getAbsolutePath()}).waitFor();
                return SQLiteJDBCLoader.loadNativeLibrary(string3, string6);
            }
            catch (Throwable var11_13) {
                // empty catch block
            }
            return SQLiteJDBCLoader.loadNativeLibrary(string3, string6);
        }
        catch (IOException var7_8) {
            System.err.println(var7_8.getMessage());
            return false;
        }
    }

    private static synchronized boolean loadNativeLibrary(String string, String string2) {
        File file = new File(string, string2);
        if (!file.exists()) return false;
        try {
            System.load(new File(string, string2).getAbsolutePath());
            return true;
        }
        catch (UnsatisfiedLinkError var3_3) {
            System.err.println(var3_3);
            return false;
        }
    }

    private static void loadSQLiteNativeLibrary() {
        if (extracted) {
            return;
        }
        boolean bl2 = SQLiteJDBCLoader.getPureJavaFlag();
        if (bl2) {
            extracted = false;
            return;
        }
        String string = System.getProperty("org.sqlite.lib.path");
        String string2 = System.getProperty("org.sqlite.lib.name");
        if (string2 == null) {
            string2 = System.mapLibraryName("sqlitejdbc");
        }
        if (string != null && SQLiteJDBCLoader.loadNativeLibrary(string, string2)) {
            extracted = true;
            return;
        }
        string = "/native/" + OSInfo.getNativeLibFolderPathForCurrentOS();
        if (SQLiteJDBCLoader.class.getResource(string + "/" + string2) == null) {
            return;
        }
        String string3 = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        if (SQLiteJDBCLoader.extractAndLoadLibraryFile(string, string2, string3)) {
            extracted = true;
            return;
        }
        extracted = false;
    }

    private static void getNativeLibraryFolderForTheCurrentOS() {
        String string = OSInfo.getOSName();
        String string2 = OSInfo.getArchName();
    }

    public static int getMajorVersion() {
        String[] arrstring = SQLiteJDBCLoader.getVersion().split("\\.");
        if (arrstring.length <= 0) return 1;
        int n2 = Integer.parseInt(arrstring[0]);
        return n2;
    }

    public static int getMinorVersion() {
        String[] arrstring = SQLiteJDBCLoader.getVersion().split("\\.");
        if (arrstring.length <= 1) return 0;
        int n2 = Integer.parseInt(arrstring[1]);
        return n2;
    }

    public static String getVersion() {
        URL uRL = SQLiteJDBCLoader.class.getResource("/META-INF/maven/org.xerial/sqlite-jdbc/pom.properties");
        if (uRL == null) {
            uRL = SQLiteJDBCLoader.class.getResource("/META-INF/maven/org.xerial/sqlite-jdbc/VERSION");
        }
        String string = "unknown";
        try {
            if (uRL == null) return string;
            Properties properties = new Properties();
            properties.load(uRL.openStream());
            string = properties.getProperty("version", string);
            return string.trim().replaceAll("[^0-9\\.]", "");
        }
        catch (IOException var2_3) {
            System.err.println(var2_3);
        }
        return string;
    }
}

