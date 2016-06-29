package org.sqlite;

import java.security.*;
import java.io.*;
import java.util.*;
import java.net.*;

public class SQLiteJDBCLoader
{
    private static boolean extracted;
    
    public static boolean initialize() {
        loadSQLiteNativeLibrary();
        return SQLiteJDBCLoader.extracted;
    }
    
    static boolean getPureJavaFlag() {
        return Boolean.parseBoolean(System.getProperty("sqlite.purejava", "false"));
    }
    
    public static boolean isPureJavaMode() {
        return !isNativeMode();
    }
    
    public static boolean isNativeMode() {
        if (getPureJavaFlag()) {
            return false;
        }
        initialize();
        return SQLiteJDBCLoader.extracted;
    }
    
    static String md5sum(final InputStream inputStream) {
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            final MessageDigest instance = MessageDigest.getInstance("MD5");
            while (new DigestInputStream(bufferedInputStream, instance).read() >= 0) {}
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(instance.digest());
            return byteArrayOutputStream.toString();
        }
        catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("MD5 algorithm is not available: " + ex);
        }
        finally {
            bufferedInputStream.close();
        }
    }
    
    private static boolean extractAndLoadLibraryFile(final String s, final String s2, final String s3) {
        final String string = s + "/" + s2;
        final String string2 = "sqlite-" + getVersion() + "-" + s2;
        final File file = new File(s3, string2);
        try {
            if (file.exists()) {
                if (md5sum(SQLiteJDBCLoader.class.getResourceAsStream(string)).equals(md5sum(new FileInputStream(file)))) {
                    return loadNativeLibrary(s3, string2);
                }
                if (!file.delete()) {
                    throw new IOException("failed to remove existing native library file: " + file.getAbsolutePath());
                }
            }
            final InputStream resourceAsStream = SQLiteJDBCLoader.class.getResourceAsStream(string);
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            final byte[] array = new byte[1024];
            int read;
            while ((read = resourceAsStream.read(array)) != -1) {
                fileOutputStream.write(array, 0, read);
            }
            fileOutputStream.close();
            resourceAsStream.close();
            if (!System.getProperty("os.name").contains("Windows")) {
                try {
                    Runtime.getRuntime().exec(new String[] { "chmod", "755", file.getAbsolutePath() }).waitFor();
                }
                catch (Throwable t) {}
            }
            return loadNativeLibrary(s3, string2);
        }
        catch (IOException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
    
    private static synchronized boolean loadNativeLibrary(final String s, final String s2) {
        if (new File(s, s2).exists()) {
            try {
                System.load(new File(s, s2).getAbsolutePath());
                return true;
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                System.err.println(unsatisfiedLinkError);
                return false;
            }
        }
        return false;
    }
    
    private static void loadSQLiteNativeLibrary() {
        if (SQLiteJDBCLoader.extracted) {
            return;
        }
        if (getPureJavaFlag()) {
            SQLiteJDBCLoader.extracted = false;
            return;
        }
        final String property = System.getProperty("org.sqlite.lib.path");
        String s = System.getProperty("org.sqlite.lib.name");
        if (s == null) {
            s = System.mapLibraryName("sqlitejdbc");
        }
        if (property != null && loadNativeLibrary(property, s)) {
            SQLiteJDBCLoader.extracted = true;
            return;
        }
        final String string = "/native/" + OSInfo.getNativeLibFolderPathForCurrentOS();
        if (SQLiteJDBCLoader.class.getResource(string + "/" + s) == null) {
            return;
        }
        if (extractAndLoadLibraryFile(string, s, new File(System.getProperty("java.io.tmpdir")).getAbsolutePath())) {
            SQLiteJDBCLoader.extracted = true;
            return;
        }
        SQLiteJDBCLoader.extracted = false;
    }
    
    private static void getNativeLibraryFolderForTheCurrentOS() {
        OSInfo.getOSName();
        OSInfo.getArchName();
    }
    
    public static int getMajorVersion() {
        final String[] split = getVersion().split("\\.");
        return (split.length > 0) ? Integer.parseInt(split[0]) : 1;
    }
    
    public static int getMinorVersion() {
        final String[] split = getVersion().split("\\.");
        return (split.length > 1) ? Integer.parseInt(split[1]) : 0;
    }
    
    public static String getVersion() {
        URL url = SQLiteJDBCLoader.class.getResource("/META-INF/maven/org.xerial/sqlite-jdbc/pom.properties");
        if (url == null) {
            url = SQLiteJDBCLoader.class.getResource("/META-INF/maven/org.xerial/sqlite-jdbc/VERSION");
        }
        String s = "unknown";
        try {
            if (url != null) {
                final Properties properties = new Properties();
                properties.load(url.openStream());
                s = properties.getProperty("version", s);
                s = s.trim().replaceAll("[^0-9\\.]", "");
            }
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        return s;
    }
    
    static {
        SQLiteJDBCLoader.extracted = false;
    }
}
