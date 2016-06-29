/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.io;

import com.google.common.base.Preconditions;
import com.google.security.zynamics.zylib.io.StreamUtils;
import com.google.security.zynamics.zylib.system.SystemHelpers;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class FileUtils {
    public static String calcMD5(File file) {
        MessageDigest messageDigest;
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] arrby = new byte[(int)file.length()];
        fileInputStream.read(arrby);
        fileInputStream.close();
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException var4_4) {
            if ($assertionsDisabled) throw new RuntimeException(var4_4);
            throw new AssertionError((Object)"MD5 not in list of algorithms");
        }
        messageDigest.update(arrby);
        byte[] arrby2 = messageDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        byte[] arrby3 = arrby2;
        int n2 = arrby3.length;
        int n3 = 0;
        while (n3 < n2) {
            byte by2 = arrby3[n3];
            stringBuilder.append(String.format("%02X", Byte.valueOf(by2)));
            ++n3;
        }
        return stringBuilder.toString();
    }

    public static boolean containsDirectory(File file, String string) {
        if (file == null) return false;
        if (!file.isDirectory()) {
            return false;
        }
        File[] arrfile = file.listFiles();
        int n2 = arrfile.length;
        int n3 = 0;
        while (n3 < n2) {
            File file2 = arrfile[n3];
            if (file2.isDirectory() && file2.getName().equals(string)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static boolean containsFile(File file, String string) {
        if (file == null) return false;
        if (!file.isDirectory()) {
            return false;
        }
        File[] arrfile = file.listFiles();
        int n2 = arrfile.length;
        int n3 = 0;
        while (n3 < n2) {
            File file2 = arrfile[n3];
            if (file2.getName().equals(string)) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    public static boolean createDirectory(String string) {
        return new File(string).mkdirs();
    }

    public static String ensureTrailingSlash(String string) {
        if (string == null) return "";
        if (string.equals("")) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        while (stringBuilder.charAt(stringBuilder.length() - 1) == File.separatorChar) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.append(File.separatorChar).toString();
    }

    public static boolean exists(String string) {
        return new File(string).exists();
    }

    public static String extractNameFromPath(String string) {
        return new File(string).getName();
    }

    public static String findLocalRootPath(Class class_) {
        String string;
        Object object;
        int n2;
        String string2 = String.valueOf(class_.getSimpleName()).concat(".class");
        URL uRL = class_.getResource(string2);
        String string3 = String.valueOf(class_.getCanonicalName());
        Preconditions.checkNotNull(uRL, string3.length() != 0 ? "Cannot find resource for class ".concat(string3) : new String("Cannot find resource for class "));
        String string4 = uRL.getProtocol();
        String string5 = uRL.getPath();
        int n3 = n2 = SystemHelpers.isRunningWindows() ? 1 : 0;
        if (string4.equals("file")) {
            object = class_.getPackage();
            if (object != null) {
                String string6 = object != null ? object.getName().replace('.', '/') : "";
                string = string5.substring(n2, string5.lastIndexOf(string6));
            } else {
                string = string5.substring(n2, string5.lastIndexOf(47));
            }
        } else {
            if (!string4.equals("jar")) {
                throw new RuntimeException("Cannot find root path for remote classes");
            }
            if (!string5.startsWith("file:")) {
                String string7;
                String string8 = String.valueOf(class_.getCanonicalName());
                if (string8.length() != 0) {
                    string7 = "Cannot find root path for class ".concat(string8);
                    throw new IllegalArgumentException(string7);
                }
                string7 = new String("Cannot find root path for class ");
                throw new IllegalArgumentException(string7);
            }
            object = string5.substring(5, string5.lastIndexOf(33));
            string = object.substring(n2, object.lastIndexOf(47));
        }
        try {
            return URLDecoder.decode(string.replace('/', File.separatorChar), System.getProperty("file.encoding"));
        }
        catch (UnsupportedEncodingException var7_7) {
            if ($assertionsDisabled) throw new RuntimeException(var7_7);
            throw new AssertionError((Object)"Platform default URL encoding should always be available");
        }
    }

    public static String getFileBasename(File file) {
        String string;
        String string2 = file.getName();
        int n2 = string2.lastIndexOf(".");
        if (n2 == -1) {
            string = string2;
            return string;
        }
        string = string2.substring(0, n2);
        return string;
    }

    public static String getFileExtension(File file) {
        String string = file.getAbsolutePath();
        return string.substring(string.lastIndexOf(".") + 1);
    }

    public static String getPathEllipsis(String string, int n2) {
        return FileUtils.getPathEllipsis(string, n2, "...");
    }

    public static String getPathEllipsis(String string, int n2, String string2) {
        int n3 = string.length();
        int n4 = string2.length();
        Preconditions.checkArgument(n2 >= 4 * n4, "Maximum length too short");
        if (n3 <= n2) {
            return string;
        }
        char c2 = File.separatorChar;
        boolean bl2 = false;
        for (int i2 = 0; !bl2 && i2 < n3; ++i2) {
            c2 = string.charAt(i2);
            bl2 = c2 == '/' || c2 == '\\';
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!bl2) {
            stringBuilder.append(string.substring(0, n2 - n4));
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        int n5 = string.lastIndexOf(c2);
        int n6 = n2 - (n3 - n5);
        int n7 = n6 / 2 - n4 / 2;
        if (n7 > 0) {
            stringBuilder.append(string.substring(0, n7 - n4 % 2 + n6 % 2));
            stringBuilder.append(string2);
            stringBuilder.append(string.substring(n5 - n7 + n4 % 2));
            return stringBuilder.toString();
        }
        stringBuilder.append(string.substring(0, 3));
        stringBuilder.append(string2);
        stringBuilder.append(string.substring(n5, n5 + n2 - 3 - 2 * n4));
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String readTextfile(File file) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String string = System.getProperty("line.separator");
        try {
            String string2 = null;
            while ((string2 = bufferedReader.readLine()) != null) {
                stringBuffer.append(string2);
                stringBuffer.append(string);
            }
            return stringBuffer.toString();
        }
        finally {
            bufferedReader.close();
        }
    }

    public static String readTextfile(String string) {
        return FileUtils.readTextfile(new File(string));
    }

    public static List readTextfileLines(File file) {
        return StreamUtils.readLinesFromReader(new FileReader(file));
    }

    public static void writeBinaryFile(File file, byte[] arrby) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(arrby);
            return;
        }
        finally {
            fileOutputStream.close();
        }
    }

    public static void writeTextFile(File file, String string) {
        Preconditions.checkNotNull(file, "Error: file argument can not be null");
        Preconditions.checkNotNull(string, "Error: text argument can not be null");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write(string);
            return;
        }
        finally {
            bufferedWriter.close();
        }
    }
}

