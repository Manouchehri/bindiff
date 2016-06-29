package com.google.security.zynamics.zylib.io;

import java.security.*;
import com.google.common.base.*;
import com.google.security.zynamics.zylib.system.*;
import java.net.*;
import java.util.*;
import java.io.*;

public class FileUtils
{
    public static String calcMD5(final File file) {
        final FileInputStream fileInputStream = new FileInputStream(file);
        final byte[] array = new byte[(int)file.length()];
        fileInputStream.read(array);
        fileInputStream.close();
        MessageDigest instance;
        try {
            instance = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException ex) {
            assert false : "MD5 not in list of algorithms";
            throw new RuntimeException(ex);
        }
        instance.update(array);
        final byte[] digest = instance.digest();
        final StringBuilder sb = new StringBuilder();
        final byte[] array2 = digest;
        for (int length = array2.length, i = 0; i < length; ++i) {
            sb.append(String.format("%02X", array2[i]));
        }
        return sb.toString();
    }
    
    public static boolean containsDirectory(final File file, final String s) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        for (final File file2 : file.listFiles()) {
            if (file2.isDirectory() && file2.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean containsFile(final File file, final String s) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        final File[] listFiles = file.listFiles();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            if (listFiles[i].getName().equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean createDirectory(final String s) {
        return new File(s).mkdirs();
    }
    
    public static String ensureTrailingSlash(final String s) {
        if (s == null || s.equals("")) {
            return "";
        }
        final StringBuilder sb = new StringBuilder(s);
        while (sb.charAt(sb.length() - 1) == File.separatorChar) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.append(File.separatorChar).toString();
    }
    
    public static boolean exists(final String s) {
        return new File(s).exists();
    }
    
    public static String extractNameFromPath(final String s) {
        return new File(s).getName();
    }
    
    public static String findLocalRootPath(final Class clazz) {
        final URL resource;
        final URL url = resource = clazz.getResource(String.valueOf(clazz.getSimpleName()).concat(".class"));
        final String s = "Cannot find resource for class ";
        final String value = String.valueOf(clazz.getCanonicalName());
        Preconditions.checkNotNull(resource, (Object)((value.length() != 0) ? s.concat(value) : new String(s)));
        final String protocol = url.getProtocol();
        final String path = url.getPath();
        final int runningWindows = SystemHelpers.isRunningWindows() ? 1 : 0;
        String s2;
        if (protocol.equals("file")) {
            final Package package1 = clazz.getPackage();
            if (package1 != null) {
                s2 = path.substring(runningWindows, path.lastIndexOf((package1 != null) ? package1.getName().replace('.', '/') : ""));
            }
            else {
                s2 = path.substring(runningWindows, path.lastIndexOf(47));
            }
        }
        else {
            if (!protocol.equals("jar")) {
                throw new RuntimeException("Cannot find root path for remote classes");
            }
            if (!path.startsWith("file:")) {
                final String s3 = "Cannot find root path for class ";
                final String value2 = String.valueOf(clazz.getCanonicalName());
                throw new IllegalArgumentException((value2.length() != 0) ? s3.concat(value2) : new String(s3));
            }
            final String substring = path.substring(5, path.lastIndexOf(33));
            s2 = substring.substring(runningWindows, substring.lastIndexOf(47));
        }
        try {
            return URLDecoder.decode(s2.replace('/', File.separatorChar), System.getProperty("file.encoding"));
        }
        catch (UnsupportedEncodingException ex) {
            assert false : "Platform default URL encoding should always be available";
            throw new RuntimeException(ex);
        }
    }
    
    public static String getFileBasename(final File file) {
        final String name = file.getName();
        final int lastIndex = name.lastIndexOf(".");
        return (lastIndex == -1) ? name : name.substring(0, lastIndex);
    }
    
    public static String getFileExtension(final File file) {
        final String absolutePath = file.getAbsolutePath();
        return absolutePath.substring(absolutePath.lastIndexOf(".") + 1);
    }
    
    public static String getPathEllipsis(final String s, final int n) {
        return getPathEllipsis(s, n, "...");
    }
    
    public static String getPathEllipsis(final String s, final int n, final String s2) {
        final int length = s.length();
        final int length2 = s2.length();
        Preconditions.checkArgument(n >= 4 * length2, (Object)"Maximum length too short");
        if (length <= n) {
            return s;
        }
        int n2;
        char c;
        boolean b;
        for (n2 = 0, c = File.separatorChar, b = false; !b && n2 < length; b = (c == '/' || c == '\\'), ++n2) {
            c = s.charAt(n2);
        }
        final StringBuilder sb = new StringBuilder();
        if (!b) {
            sb.append(s.substring(0, n - length2));
            sb.append(s2);
        }
        else {
            final int lastIndex = s.lastIndexOf(c);
            final int n3 = n - (length - lastIndex);
            final int n4 = n3 / 2 - length2 / 2;
            if (n4 > 0) {
                sb.append(s.substring(0, n4 - length2 % 2 + n3 % 2));
                sb.append(s2);
                sb.append(s.substring(lastIndex - n4 + length2 % 2));
            }
            else {
                sb.append(s.substring(0, 3));
                sb.append(s2);
                sb.append(s.substring(lastIndex, lastIndex + n - 3 - 2 * length2));
                sb.append(s2);
            }
        }
        return sb.toString();
    }
    
    public static String readTextfile(final File file) {
        final StringBuffer sb = new StringBuffer();
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        final String property = System.getProperty("line.separator");
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append(property);
            }
        }
        finally {
            bufferedReader.close();
        }
        return sb.toString();
    }
    
    public static String readTextfile(final String s) {
        return readTextfile(new File(s));
    }
    
    public static List readTextfileLines(final File file) {
        return StreamUtils.readLinesFromReader(new FileReader(file));
    }
    
    public static void writeBinaryFile(final File file, final byte[] array) {
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
        }
        finally {
            fileOutputStream.close();
        }
    }
    
    public static void writeTextFile(final File file, final String s) {
        Preconditions.checkNotNull(file, (Object)"Error: file argument can not be null");
        Preconditions.checkNotNull(s, (Object)"Error: text argument can not be null");
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        try {
            bufferedWriter.write(s);
        }
        finally {
            bufferedWriter.close();
        }
    }
}
